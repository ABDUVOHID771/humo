package com.example.springhumo.service.api;

import com.example.springhumo.constant.*;
import com.example.springhumo.mapper.CommonMapper;
import com.example.springhumo.model.dto.CreateAndConfirmRequestDto;
import com.example.springhumo.model.dto.CreateAndConfirmResponseDto;
import com.example.springhumo.model.dto.humo.request.ConfirmPaymentRequestDto;
import com.example.springhumo.model.dto.humo.request.CreatePaymentRequestDto;
import com.example.springhumo.model.dto.humo.request.RevertRequestDto;
import com.example.springhumo.model.dto.humo.response.CheckPaymentResponseEnvelopDto;
import com.example.springhumo.model.dto.humo.response.ErrorDto;
import com.example.springhumo.model.dto.humo.response.PaymentResponseEnvelopDto;
import com.example.springhumo.model.entity.Bank;
import com.example.springhumo.model.entity.Card;
import com.example.springhumo.model.entity.HumoReconciliation;
import com.example.springhumo.repository.ReconciliationRepository;
import com.example.springhumo.service.local.BankService;
import com.example.springhumo.service.local.CardService;
import com.example.springhumo.service.local.TransactionManagementService;
import com.example.springhumo.util.CardUtil;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
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
public class HumoPayService {
    private static Logger logger = LogManager.getLogger(HumoPayService.class);
    private static final String CURRENCY_CODE = "860";
    private static final String POINT_CODE = "100001104110";
    @Value("${api.humo.issuing}")
    private String issuingUrl;
    @Value("${api.humo.balance}")
    private String balanceUrl;
    @Value("${api.humo.payment.and.confirm}")
    private String payAndConfirmUrl;
    @Value("${api.humo.export.and.import}")
    private String exportAndImport;
    @Value("${humo.username}")
    private String username;
    @Autowired
    private WebClientService manager;
    @Autowired
    private ApiManager apiManager;
    @Autowired
    private BankService bankService;
    @Autowired
    private CardService cardService;
    @Autowired
    private TransactionManagementService transactionManagementService;
    @Autowired
    private ReconciliationRepository reconciliationRepository;

    public HumoPayService() {
    }

    public ResponseEntity<?> createPayment(CreatePaymentRequestDto requestDto, PaymentType paymentType) throws TimeoutException {
        Optional<Card> card = this.cardService.getCardByToken(requestDto.getToken());
        if (!card.isPresent()) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResults.ERR_004);
        } else {
            String encPan = ((Card)card.get()).getEncPan();
            String pan = CardUtil.decode(encPan);
            if (pan.isEmpty()) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResults.ERR_004);
            } else {
                Optional<Bank> bank = this.bankService.getBankByPan(pan);
                if (!bank.isPresent()) {
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResults.ERR_025);
                } else {
                    String requestBody = paymentType == PaymentType.PAY ? "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:SOAP-ENC=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:ebppif1=\"urn:PaymentServer\">\n    <SOAP-ENV:Body>\n        <ebppif1:Payment>\n            <billerRef>SOAP_SMS</billerRef>\n            <payinstrRef>SOAP_SMS</payinstrRef>\n            <sessionID>{SESSION_ID}</sessionID>\n            <paymentRef>{PAYMENT_REF}</paymentRef>\n            <details>\n                <item>\n                    <name>pan</name>\n                    <value>{PAN}</value>\n                </item>\n                <item>\n                    <name>expiry</name>\n                    <value>{EXPIRY}</value>\n                </item>\n                <item>\n                    <name>ccy_code</name>\n                    <value>{CURRENCY_CODE}</value>\n                </item>\n                <item>\n                    <name>amount</name>\n                    <value>{AMOUNT}</value>\n                </item>\n                <item>\n                    <name>merchant_id</name>\n                    <value>{MERCHANT_ID}</value>\n                </item>\n                <item>\n                    <name>terminal_id</name>\n                    <value>{TERMINAL_ID}</value>\n                </item>\n                <item>\n                    <name>point_code</name>\n                    <value>{POINT_CODE}</value>\n                </item>\n                <item>\n                    <name>centre_id</name>\n                    <value>{CENTER_ID}</value>\n                </item>\n            </details>\n            <paymentOriginator>{USER}</paymentOriginator>\n        </ebppif1:Payment>\n    </SOAP-ENV:Body>\n</SOAP-ENV:Envelope>" : "<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:SOAP-ENC=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:ebppif1=\"urn:PaymentServer\">\n   <SOAP-ENV:Body>\n      <ebppif1:Payment>\n         <billerRef>SOAP_DMS</billerRef>\n         <payinstrRef>SOAP_DMS</payinstrRef>\n         <sessionID>DMD_TEST-a12s4f5d54fds85s4</sessionID>\n         <details>\n            <item>\n               <name>pan</name>\n               <value>{PAN}</value>\n            </item>\n            <item>\n               <name>expiry</name>\n               <value>{EXPIRY}</value>\n            </item>\n            <item>\n               <name>ccy_code</name>\n               <value>{CURRENCY_CODE}</value>\n            </item>\n            <item>\n               <name>amount</name>\n               <value>{AMOUNT}</value>\n            </item>\n            <item>\n               <name>merchant_id</name>\n               <value>{MERCHANT_ID}</value>\n            </item>\n            <item>\n               <name>terminal_id</name>\n               <value>{TERMINAL_ID}</value>\n            </item>\n            <item>\n               <name>point_code</name>\n               <value>{POINT_CODE}</value>\n            </item>\n            <item>\n               <name>centre_id</name>\n               <value>{CENTER_ID}</value>\n            </item>\n         </details>\n         <paymentOriginator>{USER}</paymentOriginator>\n      </ebppif1:Payment>\n   </SOAP-ENV:Body>\n</SOAP-ENV:Envelope>";
                    requestBody = requestBody.replaceAll("\\{SESSION_ID}", requestDto.getSessionId());
                    requestBody = requestBody.replaceAll("\\{PAYMENT_REF}", requestDto.getSessionId());
                    requestBody = requestBody.replaceAll("\\{PAN}", pan);
                    requestBody = requestBody.replaceAll("\\{EXPIRY}", ((Card)card.get()).getExpDate());
                    requestBody = requestBody.replaceAll("\\{CURRENCY_CODE}", "860");
                    requestBody = requestBody.replaceAll("\\{AMOUNT}", requestDto.getAmount());
                    requestBody = requestBody.replaceAll("\\{MERCHANT_ID}", requestDto.getMerchantId());
                    requestBody = requestBody.replaceAll("\\{TERMINAL_ID}", requestDto.getTerminalId());
                    requestBody = requestBody.replaceAll("\\{POINT_CODE}", "100001104110");
                    requestBody = requestBody.replaceAll("\\{CENTER_ID}", ((Bank)bank.get()).getCenterId());
                    requestBody = requestBody.replaceAll("\\{USER}", this.username);
                    ResponseEntity<?> responseEntity = this.manager.requestHumoRest(this.payAndConfirmUrl, HumoAction.PAYMENT, requestBody);
                    if (responseEntity.getStatusCode() != HttpStatus.OK) {
                        Optional<ErrorDto> errorDto = CommonMapper.xmlErrorStringToErrorDto(responseEntity.getBody().toString(), "<ebppif1:PaymentServerException>", "</ebppif1:PaymentServerException>");
                        if (errorDto.isPresent()) {
                            this.transactionManagementService.updateStatusCode(requestDto.getSessionId(), ((ErrorDto)errorDto.get()).getError().toString());
                            HumoError humoError = HumoError.findById(((ErrorDto)errorDto.get()).getError());
                            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(humoError.getResult());
                        } else {
                            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResults.ERR_001);
                        }
                    } else {
                        String rawXml = responseEntity.getBody().toString();
                        Integer startIndex = rawXml.lastIndexOf("<ebppif1:PaymentResponse>");
                        Integer endIndex = rawXml.indexOf("</ebppif1:PaymentResponse>");
                        rawXml = rawXml.substring(startIndex + 25, endIndex);
                        rawXml = "<envelop>" + rawXml + "</envelop>";
                        XmlMapper mapper = new XmlMapper();
                        PaymentResponseEnvelopDto envelopDto = null;

                        try {
                            envelopDto = (PaymentResponseEnvelopDto)mapper.readValue(rawXml, PaymentResponseEnvelopDto.class);
                            return ResponseEntity.ok(envelopDto);
                        } catch (JsonParseException var15) {
                            var15.printStackTrace();
                        } catch (JsonMappingException var16) {
                            var16.printStackTrace();
                        } catch (IOException var17) {
                            var17.printStackTrace();
                        }

                        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResults.ERR_001);
                    }
                }
            }
        }
    }

    public ResponseEntity<?> confirmPayment(ConfirmPaymentRequestDto requestDto) {
        XmlMapper mapper = new XmlMapper();
        String sessionId = requestDto.getSessionId();
        Integer paymentId = requestDto.getPaymentId();
        String requestBody = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:SOAP-ENC=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:ebppif1=\"urn:PaymentServer\">\n<SOAP-ENV:Body>\n   <ebppif1:Payment>\n     <sessionID>{SESSION_ID}</sessionID>\n     <paymentID>{PAYMENT_ID}</paymentID>\n     <paymentRef>{PAYMENT_REF}</paymentRef>\n     <confirmed>true</confirmed>\n     <finished>true</finished>\n     <paymentOriginator>{USER}</paymentOriginator>\n   </ebppif1:Payment>\n</SOAP-ENV:Body>\n</SOAP-ENV:Envelope>\n\n";
        requestBody = requestBody.replaceAll("\\{SESSION_ID}", sessionId);
        requestBody = requestBody.replaceAll("\\{PAYMENT_REF}", sessionId);
        requestBody = requestBody.replaceAll("\\{PAYMENT_ID}", paymentId.toString());
        requestBody = requestBody.replaceAll("\\{USER}", this.username);
        ResponseEntity<?> responseEntity = this.apiManager.requestHumoRest(this.payAndConfirmUrl, HumoAction.PAYMENT, requestBody);
        if (responseEntity.getStatusCode() != HttpStatus.OK) {
            Optional<ErrorDto> errorDto = CommonMapper.xmlErrorStringToErrorDto(responseEntity.getBody().toString(), "<ebppif1:PaymentServerException>", "</ebppif1:PaymentServerException>");
            if (errorDto.isPresent()) {
                this.transactionManagementService.updateStatusCode(requestDto.getSessionId(), ((ErrorDto)errorDto.get()).getError().toString());
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CreateAndConfirmResponseDto((ErrorDto)errorDto.get(), requestDto));
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResults.ERR_001);
            }
        } else {
            String rawXml = responseEntity.getBody().toString();
            Integer startIndex = rawXml.lastIndexOf("<ebppif1:PaymentResponse>");
            Integer endIndex = rawXml.indexOf("</ebppif1:PaymentResponse>");
            rawXml = rawXml.substring(startIndex + 25, endIndex);
            rawXml = "<envelop>" + rawXml + "</envelop>";

            try {
                PaymentResponseEnvelopDto confirmEnvelop = (PaymentResponseEnvelopDto)mapper.readValue(rawXml, PaymentResponseEnvelopDto.class);
                CreateAndConfirmResponseDto responseDto = new CreateAndConfirmResponseDto(confirmEnvelop);
                return ResponseEntity.status(HttpStatus.OK).body(responseDto);
            } catch (JsonParseException var12) {
                logger.error(var12.getMessage());
            } catch (JsonMappingException var13) {
                logger.error(var13.getMessage());
            } catch (IOException var14) {
                logger.error(var14.getMessage());
            }

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CreateAndConfirmResponseDto());
        }
    }

    public ResponseEntity<?> createAndConfirm(CreateAndConfirmRequestDto createAndConfirmRequestDto, PaymentType paymentType) throws TimeoutException {
        ResponseEntity<?> createResponse = this.createPayment(new CreatePaymentRequestDto(createAndConfirmRequestDto), paymentType);
        if (createResponse.getStatusCode() != HttpStatus.OK) {
            return createResponse;
        } else {
            PaymentResponseEnvelopDto envelopDto = (PaymentResponseEnvelopDto)createResponse.getBody();
            String coreTransactionId = createAndConfirmRequestDto.getExt();
            String humoPaymentId = envelopDto.getPaymentId().toString();
            this.transactionManagementService.addPaymentIdToTransaction(coreTransactionId, humoPaymentId);
            ConfirmPaymentRequestDto confirmPaymentRequestDto = new ConfirmPaymentRequestDto();
            confirmPaymentRequestDto.setPaymentId(envelopDto.getPaymentId());
            confirmPaymentRequestDto.setSessionId(createAndConfirmRequestDto.getExt());
            ResponseEntity<?> confirmResponse = this.confirmPayment(confirmPaymentRequestDto);
            return confirmResponse;
        }
    }

    public ResponseEntity<?> revert(String transactionId) throws TimeoutException {
        RevertRequestDto revertRequestDto = this.transactionManagementService.generateRevertObject(transactionId);
        if (revertRequestDto == null) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("");
        } else {
            String requestBody = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:urn=\"urn:PaymentServer\">\n    <soapenv:Header/>\n    <soapenv:Body>\n        <urn:ReturnPayment>\n            <paymentID>{PAYMENT_ID}</paymentID>\n            <paymentRef>{PAYMENT_REF}</paymentRef>\n            <item>\n                <name>merchant_id</name>\n                <value>{MERCHANT_ID}</value>\n            </item>\n            <item>\n                <name>centre_id</name>\n                <value>{CENTER_ID}</value>\n            </item>\n            <item>\n                <name>terminal_id</name>\n                <value>{TERMINAL_ID}</value>\n            </item>\n            <paymentOriginator>{USER}</paymentOriginator>\n        </urn:ReturnPayment>\n    </soapenv:Body>\n</soapenv:Envelope>";
            requestBody = requestBody.replaceAll("\\{MERCHANT_ID}", revertRequestDto.getMerchantId());
            requestBody = requestBody.replaceAll("\\{TERMINAL_ID}", revertRequestDto.getTerminalId());
            requestBody = requestBody.replaceAll("\\{CENTER_ID}", revertRequestDto.getCenterId());
            requestBody = requestBody.replaceAll("\\{PAYMENT_ID}", revertRequestDto.getPaymentId());
            requestBody = requestBody.replaceAll("\\{PAYMENT_REF}", transactionId);
            requestBody = requestBody.replaceAll("\\{USER}", this.username);
            ResponseEntity<?> responseEntity = this.manager.requestHumoRest(this.payAndConfirmUrl, HumoAction.revert, requestBody);
            return responseEntity;
        }
    }

    public ResponseEntity<?> revertFull(String merchant, String terminal, String center, String paymentId, String extId) throws TimeoutException {
        String requestBody = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:urn=\"urn:PaymentServer\">\n    <soapenv:Header/>\n    <soapenv:Body>\n        <urn:ReturnPayment>\n            <paymentID>{PAYMENT_ID}</paymentID>\n            <paymentRef>{PAYMENT_REF}</paymentRef>\n            <item>\n                <name>merchant_id</name>\n                <value>{MERCHANT_ID}</value>\n            </item>\n            <item>\n                <name>centre_id</name>\n                <value>{CENTER_ID}</value>\n            </item>\n            <item>\n                <name>terminal_id</name>\n                <value>{TERMINAL_ID}</value>\n            </item>\n            <paymentOriginator>{USER}</paymentOriginator>\n        </urn:ReturnPayment>\n    </soapenv:Body>\n</soapenv:Envelope>";
        requestBody = requestBody.replaceAll("\\{MERCHANT_ID}", merchant);
        requestBody = requestBody.replaceAll("\\{TERMINAL_ID}", terminal);
        requestBody = requestBody.replaceAll("\\{CENTER_ID}", center);
        requestBody = requestBody.replaceAll("\\{PAYMENT_ID}", paymentId);
        requestBody = requestBody.replaceAll("\\{PAYMENT_REF}", extId);
        requestBody = requestBody.replaceAll("\\{USER}", this.username);
        ResponseEntity<?> responseEntity = this.manager.requestHumoRest(this.payAndConfirmUrl, HumoAction.revert, requestBody);
        return responseEntity;
    }

    public ResponseEntity<?> revertCreate(String paymentId, String extId) throws TimeoutException {
        String requestBody = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:urn=\"urn:PaymentServer\">\n    <soapenv:Header/>\n    <soapenv:Body>\n        <urn:CancelRequest>\n            <paymentID>{PAYMENT_ID}</paymentID>\n            <paymentRef>{PAYMENT_REF}</paymentRef>\n            <paymentOriginator>{USER}</paymentOriginator>\n        </urn:CancelRequest>\n    </soapenv:Body>\n</soapenv:Envelope>";
        requestBody = requestBody.replaceAll("\\{PAYMENT_ID}", paymentId);
        requestBody = requestBody.replaceAll("\\{USER}", this.username);
        requestBody = requestBody.replaceAll("\\{PAYMENT_REF}", extId);
        ResponseEntity<?> responseEntity = this.manager.requestHumoRest(this.payAndConfirmUrl, HumoAction.revert, requestBody);
        return responseEntity;
    }

    public ResponseEntity<CheckPaymentResponseEnvelopDto> checkTransaction(String paymentId, String extId) throws TimeoutException {
        String requestBody = "<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:SOAP-ENC=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:ebppif1=\"urn:PaymentServer\">\n    <SOAP-ENV:Body>\n        <ebppif1:GetPayment>\n            <paymentID>{PAYMENT_ID}</paymentID>\n            <paymentRef>{PAYMENT_REF}</paymentRef>\n            <paymentOriginator>{USER}</paymentOriginator>\n        </ebppif1:GetPayment>\n    </SOAP-ENV:Body>\n</SOAP-ENV:Envelope>";
        requestBody = requestBody.replaceAll("\\{PAYMENT_ID}", paymentId);
        requestBody = requestBody.replaceAll("\\{PAYMENT_REF}", extId);
        requestBody = requestBody.replaceAll("\\{USER}", this.username);
        ResponseEntity<?> responseEntity = this.manager.requestHumoRest(this.payAndConfirmUrl, HumoAction.GET_PAYMENT, requestBody);
        if (!responseEntity.getStatusCode().is2xxSuccessful()) {
            return ResponseEntity.status(responseEntity.getStatusCode()).build();
        } else {
            String rawXml = responseEntity.getBody().toString();
            Integer startIndex = rawXml.lastIndexOf("<ebppif1:GetPaymentResponse>");
            Integer endIndex = rawXml.indexOf("</ebppif1:GetPaymentResponse>");
            rawXml = rawXml.substring(startIndex + 28, endIndex);
            rawXml = "<envelop>" + rawXml + "</envelop>";
            XmlMapper mapper = new XmlMapper();

            try {
                CheckPaymentResponseEnvelopDto envelopDto = (CheckPaymentResponseEnvelopDto)mapper.readValue(rawXml, CheckPaymentResponseEnvelopDto.class);
                return ResponseEntity.ok(envelopDto);
            } catch (JsonParseException var11) {
                var11.printStackTrace();
                logger.error(var11.getMessage());
            } catch (JsonMappingException var12) {
                var12.printStackTrace();
                logger.error(var12.getMessage());
            } catch (IOException var13) {
                var13.printStackTrace();
                logger.error(var13.getMessage());
            }

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity<?> reconcileCreate(String terminal) throws TimeoutException {
        String requestBody = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:SOAP-ENC=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:ebppif1=\"urn:PaymentServer\"> <SOAP-ENV:Body>\n<ebppif1:Payment>\n  <billerRef>SOAP_RECO</billerRef>\n  <payinstrRef>SOAP_RECO</payinstrRef>\n  <details>\n    <item><name>terminal_id</name>\n    <value>{TERMINAL_ID}</value></item>\n  </details>\n  <paymentOriginator>{USER}</paymentOriginator>\n</ebppif1:Payment>\n</SOAP-ENV:Body>\n</SOAP-ENV:Envelope>";
        requestBody = requestBody.replaceAll("\\{TERMINAL_ID}", terminal);
        requestBody = requestBody.replaceAll("\\{USER}", this.username);
        ResponseEntity<?> responseEntity = this.manager.requestHumoRest(this.payAndConfirmUrl, HumoAction.PAYMENT, requestBody);
        if (responseEntity.getStatusCode() != HttpStatus.OK) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResults.ERR_001);
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
                logger.error(var10.getMessage());
            } catch (JsonMappingException var11) {
                var11.printStackTrace();
                logger.error(var11.getMessage());
            } catch (IOException var12) {
                var12.printStackTrace();
                logger.error(var12.getMessage());
            }

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResults.ERR_001);
        }
    }

    public ResponseEntity<?> reconcileConfirm(Integer paymentId, String terminal) throws TimeoutException {
        String requestBody = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:SOAP-ENC=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:ebppif1=\"urn:PaymentServer\">\n    <SOAP-ENV:Body>\n        <ebppif1:Payment>\n            <paymentID>{PAYMENT_ID}</paymentID>\n            <confirmed>true</confirmed>\n            <finished>true</finished>\n        </ebppif1:Payment>\n    </SOAP-ENV:Body>\n</SOAP-ENV:Envelope>";
        requestBody = requestBody.replaceAll("\\{PAYMENT_ID}", paymentId.toString());
        ResponseEntity<?> responseEntity = this.manager.requestHumoRest(this.payAndConfirmUrl, HumoAction.PAYMENT, requestBody);
        if (responseEntity.getStatusCode() != HttpStatus.OK) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResults.ERR_001);
        } else {
            String rawXml = responseEntity.getBody().toString();
            Integer startIndex = rawXml.lastIndexOf("<ebppif1:PaymentResponse>");
            Integer endIndex = rawXml.indexOf("</ebppif1:PaymentResponse>");
            rawXml = rawXml.substring(startIndex + 25, endIndex);
            rawXml = "<envelop>" + rawXml + "</envelop>";
            XmlMapper mapper = new XmlMapper();
            HumoReconciliation reconciliation = new HumoReconciliation();
            reconciliation.setTerminalId(terminal);
            reconciliation = (HumoReconciliation)this.reconciliationRepository.save(reconciliation);

            try {
                PaymentResponseEnvelopDto envelopDto = (PaymentResponseEnvelopDto)mapper.readValue(rawXml, PaymentResponseEnvelopDto.class);
                Map<String, String> itemsMap = envelopDto.getItemsMap();
                reconciliation.setPaymentId(envelopDto.getPaymentId());
                reconciliation.setStatus(ReconciliationStatus.CONFIRMED);
                reconciliation.setDebitsNumber(new BigDecimal((String)itemsMap.getOrDefault("debits_number", "0.00")));
                reconciliation.setDebitsAmount(new BigDecimal((String)itemsMap.getOrDefault("debits_amount", "0.00")));
                reconciliation.setCreditsReversalAmount(new BigDecimal((String)itemsMap.getOrDefault("credits_reversal_amount", "0.00")));
                reconciliation.setCreditsReversalNumber(new BigDecimal((String)itemsMap.getOrDefault("credits_reversal_number", "0.00")));
                reconciliation.setUpdated(LocalDateTime.now());
                this.reconciliationRepository.save(reconciliation);
                return ResponseEntity.ok(envelopDto);
            } catch (JsonParseException var12) {
                var12.printStackTrace();
                logger.error(var12.getMessage());
            } catch (JsonMappingException var13) {
                var13.printStackTrace();
                logger.error(var13.getMessage());
            } catch (IOException var14) {
                var14.printStackTrace();
                logger.error(var14.getMessage());
            }

            reconciliation.setStatus(ReconciliationStatus.ERROR);
            reconciliation.setUpdated(LocalDateTime.now());
            this.reconciliationRepository.save(reconciliation);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResults.ERR_001);
        }
    }

    public ResponseEntity<?> holdCharge(HashMap<String, Object> params) {
        String coreTransactionId = params.getOrDefault("transaction_id", "0").toString();
        String humoPaymentId = params.getOrDefault("payment_id", "").toString();
        if (coreTransactionId.equals("0") && humoPaymentId.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("");
        } else {
            this.transactionManagementService.addPaymentIdToTransaction(coreTransactionId, humoPaymentId);
            ConfirmPaymentRequestDto confirm = new ConfirmPaymentRequestDto();
            confirm.setPaymentId(Integer.valueOf(humoPaymentId));
            confirm.setSessionId(coreTransactionId);
            ResponseEntity<?> confirmResponse = this.confirmPayment(confirm);
            return confirmResponse;
        }
    }

    public ResponseEntity<?> holdDismiss(Integer paymentId) throws TimeoutException {
        String requestBody = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:urn=\"urn:PaymentServer\">\n   <soapenv:Header/>\n   <soapenv:Body>\n      <urn:CancelRequest>\n         <paymentID>{PAYMENT_ID}</paymentID>\n         <paymentRef>{PAYMENT_REF}</paymentRef>\n         <paymentOriginator>{USER}</paymentOriginator>\n      </urn:CancelRequest>\n   </soapenv:Body>\n</soapenv:Envelope>";
        requestBody = requestBody.replaceAll("\\{PAYMENT_ID}", paymentId.toString());
        requestBody = requestBody.replaceAll("\\{USER}", this.username);
        ResponseEntity<?> responseEntity = this.manager.requestHumoRest(this.payAndConfirmUrl, HumoAction.revert, requestBody);
        return responseEntity;
    }
}
