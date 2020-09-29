package com.example.springhumo.service.api;

//CHANGED
import com.example.springhumo.constant.ApiResults;
import com.example.springhumo.constant.HumoAction;
import com.example.springhumo.model.dto.humo.request.P2pApplyRequestDto;
import com.example.springhumo.model.dto.humo.request.P2pCreateRequestDto;
import com.example.springhumo.model.dto.humo.response.PaymentResponseEnvelopDto;
import com.example.springhumo.model.entity.Card;
import com.example.springhumo.model.entity.P2pBankHumo;
import com.example.springhumo.service.local.BankService;
import com.example.springhumo.service.local.CardService;
import com.example.springhumo.util.CardUtil;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.TimeoutException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class HumoP2pService {
    private Logger logger = LogManager.getLogger(HumoP2pService.class);
    @Value("${humo.username}")
    private String username;
    @Value("${api.humo.payment.and.confirm}")
    private String payAndConfirmUrl;
    @Autowired
    private WebClientService webClient;
    @Autowired
    private ApiManager restTemplate;
    @Autowired
    private CardService cardService;
    @Autowired
    private BankService bankService;

    public HumoP2pService() {
    }

    public ResponseEntity<?> create(P2pCreateRequestDto requestDto) throws TimeoutException {
        String requestBody = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\"\nxmlns:SOAP-ENC=\"http://schemas.xmlsoap.org/soap/encoding/\"\nxmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"\nxmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\nxmlns:ebppif1=\"urn:PaymentServer\">\n    <SOAP-ENV:Body>\n        <ebppif1:Request SOAP-ENV:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">\n            <language>en</language>\n            <paymentRef>{PAYMENT_REF}</paymentRef>\n            <switchingID>\n                <value>{SWITCHING_ID}</value>\n            </switchingID>\n            <autoSwitch>1</autoSwitch>\n            <details>\n                <item>\n                    <name>pan</name>\n                    <value>{PAN_FROM}</value>\n                </item>\n                <item>\n                    <name>expiry</name>\n                    <value>{EXPIRY_FROM}</value>\n                </item>\n                <item>\n                    <name>pan2</name>\n                    <value>{PAN_TO}</value>\n                </item>\n                <item>\n                    <name>amount</name>\n                    <value>{AMOUNT}</value>\n                </item>\n                <item>\n                    <name>ccy_code</name>\n                    <value>860</value>\n                </item>\n                <item>\n                    <name>merchant_id</name>\n                    <value>{MERCHANT_ID}</value>\n                </item>\n                <item>\n                    <name>terminal_id</name>\n                    <value>{TERMINAL_ID}</value>\n                </item>\n            </details>\n            <paymentOriginator>{USER}</paymentOriginator>\n        </ebppif1:Request>\n    </SOAP-ENV:Body>\n</SOAP-ENV:Envelope>";
        Long amount = requestDto.getAmount();
        Optional<Card> cardFromEntity = Optional.empty();
        Optional<Card> cardToEntity = Optional.empty();
        if (requestDto.isPaymentById()) {
            cardFromEntity = this.cardService.getCardById(requestDto.getCardIdFrom());
            cardToEntity = this.cardService.getCardById(requestDto.getCardIdTo());
        }

        if (requestDto.isPaymentByToken()) {
            cardFromEntity = this.cardService.getCardByToken(requestDto.getCardTokenFrom());
            cardToEntity = this.cardService.getCardByToken(requestDto.getCardTokenTo());
        }

        if (cardFromEntity.isPresent() && cardToEntity.isPresent()) {
            String panFrom = CardUtil.decode(((Card)cardFromEntity.get()).getEncPan());
            String expFrom = ((Card)cardFromEntity.get()).getExpDate();
            String panTo = CardUtil.decode(((Card)cardToEntity.get()).getEncPan());
            Optional<P2pBankHumo> p2pBankHumoTo = this.bankService.getP2pBankByPan(panTo);
            if (!p2pBankHumoTo.isPresent()) {
                this.logger.warn("Bank not found for the given pan: " + panTo);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ApiResults.ERR_025);
            } else {
                Optional<P2pBankHumo> p2pBankHumoFrom = this.bankService.getP2pBankByPan(panFrom);
                if (!p2pBankHumoFrom.isPresent()) {
                    this.logger.warn("Bank not found for the given pan: " + panFrom);
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ApiResults.ERR_025);
                } else {
                    String switchingId;
                    String merchantId;
                    String terminalId;
                    if (!((P2pBankHumo)p2pBankHumoFrom.get()).getBank().getBankId().equals(((P2pBankHumo)p2pBankHumoTo.get()).getBank().getBankId())) {
                        switchingId = ((P2pBankHumo)p2pBankHumoTo.get()).getInterbankSwitchId();
                        merchantId = ((P2pBankHumo)p2pBankHumoTo.get()).getInterbankMerchant();
                        terminalId = ((P2pBankHumo)p2pBankHumoTo.get()).getInterbankTerminal();
                    } else {
                        switchingId = ((P2pBankHumo)p2pBankHumoTo.get()).getIntrabankSwitchId();
                        merchantId = ((P2pBankHumo)p2pBankHumoTo.get()).getIntrabankMerchant();
                        terminalId = ((P2pBankHumo)p2pBankHumoTo.get()).getIntrabankTerminal();
                    }

                    requestBody = requestBody.replaceAll("\\{SWITCHING_ID}", switchingId);
                    requestBody = requestBody.replaceAll("\\{PAN_FROM}", panFrom);
                    requestBody = requestBody.replaceAll("\\{EXPIRY_FROM}", expFrom);
                    requestBody = requestBody.replaceAll("\\{PAN_TO}", panTo);
                    requestBody = requestBody.replaceAll("\\{AMOUNT}", amount.toString());
                    requestBody = requestBody.replaceAll("\\{MERCHANT_ID}", merchantId);
                    requestBody = requestBody.replaceAll("\\{TERMINAL_ID}", terminalId);
                    requestBody = requestBody.replaceAll("\\{USER}", this.username);
                    ResponseEntity<?> responseEntity = this.webClient.requestHumoRest(this.payAndConfirmUrl, HumoAction.PAYMENT, requestBody);
                    if (responseEntity.getStatusCode() != HttpStatus.OK) {
                        this.logger.error("Could not create p2p transaction");
                        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResults.ERR_115);
                    } else {
                        String rawXml = responseEntity.getBody().toString();
                        Integer startIndex = rawXml.lastIndexOf("<ebppif1:RequestResponse>");
                        Integer endIndex = rawXml.indexOf("</ebppif1:RequestResponse>");
                        rawXml = rawXml.substring(startIndex + 24, endIndex);
                        rawXml = "<envelop>" + rawXml + "</envelop>";
                        XmlMapper mapper = new XmlMapper();

                        try {
                            PaymentResponseEnvelopDto envelopDto = (PaymentResponseEnvelopDto)mapper.readValue(rawXml, PaymentResponseEnvelopDto.class);
                            return ResponseEntity.ok(envelopDto);
                        } catch (JsonParseException var21) {
                            var21.printStackTrace();
                            this.logger.error(var21.getMessage());
                        } catch (JsonMappingException var22) {
                            var22.printStackTrace();
                            this.logger.error(var22.getMessage());
                        } catch (IOException var23) {
                            var23.printStackTrace();
                            this.logger.error(var23.getMessage());
                        }

                        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResults.ERR_001);
                    }
                }
            }
        } else {
            this.logger.warn("Card not found: " + requestDto.getCardIdFrom() + "; " + requestDto.getCardIdTo());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ApiResults.ERR_004);
        }
    }

    public ResponseEntity<?> apply(P2pApplyRequestDto requestDto) {
        String requestBody = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<SOAP-ENV:Envelope\nxmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\"\nxmlns:SOAP-ENC=\"http://schemas.xmlsoap.org/soap/encoding/\"\nxmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\nxmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"\nxmlns:ebppif1=\"urn:PaymentServer\">\n    <SOAP-ENV:Body>\n        <ebppif1:Payment>\n            <!-- paymentID must be used from the response of the first request -->\n            <paymentID>{PAYMENT_ID}</paymentID>\n            <paymentRef>{PAYMENT_REF}</paymentRef>\n            <confirmed>true</confirmed>\n            <finished>true</finished>\n            <paymentOriginator>{USER}</paymentOriginator>\n        </ebppif1:Payment>\n    </SOAP-ENV:Body>\n</SOAP-ENV:Envelope>";
        requestBody = requestBody.replaceAll("\\{PAYMENT_ID}", requestDto.getPaymentId().toString());
        requestBody = requestBody.replaceAll("\\{USER}", this.username);
        ResponseEntity<?> responseEntity = this.restTemplate.requestHumoRest(this.payAndConfirmUrl, HumoAction.PAYMENT, requestBody);
        if (responseEntity.getStatusCode() != HttpStatus.OK) {
            this.logger.error("Could not create p2p transaction");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResults.ERR_115);
        } else {
            String rawXml = responseEntity.getBody().toString();
            Integer startIndex = rawXml.lastIndexOf("<ebppif1:PaymentResponse>");
            Integer endIndex = rawXml.indexOf("</ebppif1:PaymentResponse>");
            rawXml = rawXml.substring(startIndex + 25, endIndex);
            rawXml = "<envelop>" + rawXml + "</envelop>";
            XmlMapper mapper = new XmlMapper();

            try {
                PaymentResponseEnvelopDto envelopDto = (PaymentResponseEnvelopDto)mapper.readValue(rawXml, PaymentResponseEnvelopDto.class);
                return ResponseEntity.ok(envelopDto);
            } catch (JsonParseException var10) {
                var10.printStackTrace();
                this.logger.error(var10.getMessage());
            } catch (JsonMappingException var11) {
                var11.printStackTrace();
                this.logger.error(var11.getMessage());
            } catch (IOException var12) {
                var12.printStackTrace();
                this.logger.error(var12.getMessage());
            }

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResults.ERR_001);
        }
    }

    public ResponseEntity<?> createAndApply(P2pCreateRequestDto requestDto) throws TimeoutException {
        ResponseEntity<?> createResponseEntity = this.create(requestDto);
        if (createResponseEntity.getStatusCode() != HttpStatus.OK) {
            return createResponseEntity;
        } else {
            PaymentResponseEnvelopDto createResponseDto = (PaymentResponseEnvelopDto)createResponseEntity.getBody();
            Integer paymentId = createResponseDto.getPaymentId();
            this.logger.info("PaymentId: " + paymentId);
            P2pApplyRequestDto applyRequestDto = new P2pApplyRequestDto();
            applyRequestDto.setPaymentId(paymentId);
            return this.apply(applyRequestDto);
        }
    }
}
