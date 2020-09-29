package com.example.springhumo.service.api;

import com.example.springhumo.constant.HumoAction;
import com.example.springhumo.mapper.CommonMapper;
import com.example.springhumo.mapper.ListCustomerCardMapper;
import com.example.springhumo.mapper.QueryCardInfoMapper;
import com.example.springhumo.mapper.QueryTryCountMapper;
import com.example.springhumo.model.dto.humo.response.ListCustomer;
import com.example.springhumo.model.dto.humo.response.ListCustomerCard;
import com.example.springhumo.model.dto.humo.response.ListCustomerResponseEnvelopDto;
import com.example.springhumo.model.entity.Card;
import com.example.springhumo.service.local.CardService;
import com.example.springhumo.service.local.ClientService;
import com.example.springhumo.util.CardUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeoutException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

@Service
public class HumoWsService {
    private static Logger logger = LogManager.getLogger(HumoWsService.class);
    @Autowired
    private WebClientService manager;
    @Autowired
    private CardService cardService;
    @Autowired
    private ClientService clientService;
    @Value("${api.humo.issuing}")
    private String issuingUrl;

    public HumoWsService() {
    }

    public ResponseEntity<ListCustomer> listCustomers(String card) throws TimeoutException {
        String requestBody = "<soapenv:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:bin=\"urn:IssuingWS/binding\">\n    <soapenv:Header/>\n    <soapenv:Body>\n        <bin:listCustomers soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">\n            <ConnectionInfo xsi:type=\"urn:OperationConnectionInfo\" xmlns:urn=\"urn:issuing_v_01_02_xsd\">\n                <BANK_C xsi:type=\"xsd:string\">{BANK_C}</BANK_C>\n                <GROUPC xsi:type=\"xsd:string\">{GROUP_C}</GROUPC>\n                <EXTERNAL_SESSION_ID xsi:type=\"xsd:string\">{SESSION_ID_PARAM}</EXTERNAL_SESSION_ID>\n            </ConnectionInfo>\n            <Parameters xsi:type=\"urn:RowType_ListCustomers_Request\" xmlns:urn=\"urn:issuing_v_01_02_xsd\">\n                <CARD xsi:type=\"xsd:string\">{CARD}</CARD>\n                <BANK_C xsi:type=\"xsd:string\">{BANK_C}</BANK_C>\n            </Parameters>\n        </bin:listCustomers>\n    </soapenv:Body>\n</soapenv:Envelope>";
        String bankCode = CardUtil.getBankCode(card);
        String groupCode = CardUtil.getGroupCode(card);
        requestBody = requestBody.replaceAll("\\{SESSION_ID_PARAM\\}", "PAYMO" + System.currentTimeMillis() + "listCustomers");
        requestBody = requestBody.replaceAll("\\{BANK_C\\}", bankCode);
        requestBody = requestBody.replaceAll("\\{GROUP_C\\}", groupCode);
        requestBody = requestBody.replaceAll("\\{CARD\\}", card);
        ResponseEntity<?> responseEntity = this.manager.requestHumoRest(this.issuingUrl, HumoAction.LIST_CUSTOMERS, requestBody);
        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            String rawXml = responseEntity.getBody().toString();
            XmlMapper xmlMapper = new XmlMapper();

            try {
                ListCustomerResponseEnvelopDto envelop = (ListCustomerResponseEnvelopDto)xmlMapper.readValue(rawXml, ListCustomerResponseEnvelopDto.class);
                JsonNode[] nodes = envelop.getBody().getMultiRef();
                Map<String, String> params = new HashMap();
                JsonNode[] var12 = nodes;
                int var13 = nodes.length;

                for(int var14 = 0; var14 < var13; ++var14) {
                    JsonNode node = var12[var14];
                    Object nodeName = node.get("name");
                    Object nodeValue = node.get("value");
                    if (nodeName != null && nodeValue != null) {
                        JsonNode name = ((JsonNode)nodeName).get("");
                        JsonNode value = ((JsonNode)nodeValue).get("");
                        params.put(name == null ? "" : name.textValue(), value == null ? "" : value.textValue());
                    }
                }

                ListCustomer customer = new ListCustomer(params);
                return ResponseEntity.ok(customer);
            } catch (IOException var20) {
                var20.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    public ResponseEntity<List<ListCustomerCard>> listCustomerCards(String bankC, String groupC, String client, String clientB) throws TimeoutException {
        String requestBody = "<soapenv:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:bin=\"urn:IssuingWS/binding\">\n    <soapenv:Header/>\n    <soapenv:Body>\n        <bin:listCustomerCards soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">\n            <ConnectionInfo xsi:type=\"urn:OperationConnectionInfo\" xmlns:urn=\"urn:issuing_v_01_02_xsd\">\n                <BANK_C xsi:type=\"xsd:string\">{BANK_C}</BANK_C>\n                <GROUPC xsi:type=\"xsd:string\">{GROUP_C}</GROUPC>\n                <EXTERNAL_SESSION_ID xsi:type=\"xsd:string\">{SESSION_ID_PARAM}</EXTERNAL_SESSION_ID>\n            </ConnectionInfo>\n            <Parameters xsi:type=\"urn:RowType_ListCustomerCards_Request\" xmlns:urn=\"urn:issuing_v_01_02_xsd\">\n                <BANK_C xsi:type=\"xsd:string\">{BANK_C}</BANK_C>\n                <CLIENT xsi:type=\"xsd:string\">{CLIENT}</CLIENT>\n                <CLIENT_B xsi:type=\"xsd:string\">{CLIENT_B}</CLIENT_B>\n            </Parameters>\n        </bin:listCustomerCards>\n    </soapenv:Body>\n</soapenv:Envelope>";
        requestBody = requestBody.replaceAll("\\{SESSION_ID_PARAM\\}", "PAYMO" + System.currentTimeMillis() + "listCustomerCards");
        requestBody = requestBody.replaceAll("\\{BANK_C\\}", bankC);
        requestBody = requestBody.replaceAll("\\{GROUP_C\\}", groupC);
        requestBody = requestBody.replaceAll("\\{CLIENT\\}", client);
        requestBody = requestBody.replaceAll("\\{CLIENT_B\\}", clientB);
        ResponseEntity<?> responseEntity = this.manager.requestHumoRest(this.issuingUrl, HumoAction.LIST_CUSTOMER_CARDS, requestBody);
        if (responseEntity.getStatusCode() != HttpStatus.OK) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        } else {
            try {
                List<ListCustomerCard> cards = ListCustomerCardMapper.mapToListCustomerCards(responseEntity.getBody().toString());
                return ResponseEntity.ok(cards);
            } catch (ParserConfigurationException var8) {
                logger.error(var8.getMessage());
            } catch (IOException var9) {
                logger.error(var9.getMessage());
            } catch (SAXException var10) {
                logger.error(var10.getMessage());
            }

            return ResponseEntity.ok(Collections.EMPTY_LIST);
        }
    }

    public ResponseEntity<Integer> queryCardInfoCheckPinFlag(String pan) throws TimeoutException {
        String bankCode = CardUtil.getBankCode(pan);
        String groupCode = CardUtil.getGroupCode(pan);
        String requestBody = "<soapenv:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:bin=\"urn:IssuingWS/binding\">\n    <soapenv:Header/>\n    <soapenv:Body>\n        <bin:queryCardInfo soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">\n            <ConnectionInfo xsi:type=\"urn:OperationConnectionInfo\" xmlns:urn=\"urn:issuing_v_01_02_xsd\">\n                <BANK_C xsi:type=\"xsd:string\">{BANK_C}</BANK_C>\n                <GROUPC xsi:type=\"xsd:string\">{GROUP_C}</GROUPC>\n                <EXTERNAL_SESSION_ID xsi:type=\"xsd:string\">{SESSION_ID_PARAM}</EXTERNAL_SESSION_ID>\n            </ConnectionInfo>\n            <Parameters xsi:type=\"urn:RowType_QueryCardInfo_Request\" xmlns:urn=\"urn:issuing_v_01_02_xsd\">\n                <CARD xsi:type=\"xsd:string\">{CARD}</CARD>\n                <BANK_C xsi:type=\"xsd:string\">{BANK_C}</BANK_C>\n                <GROUPC xsi:type=\"xsd:string\">{GROUP_C}</GROUPC>\n            </Parameters>\n        </bin:queryCardInfo>\n    </soapenv:Body>\n</soapenv:Envelope>";
        requestBody = requestBody.replaceAll("\\{SESSION_ID_PARAM\\}", "PAYMO" + System.currentTimeMillis() + "queryCardInfo");
        requestBody = requestBody.replaceAll("\\{BANK_C\\}", bankCode);
        requestBody = requestBody.replaceAll("\\{GROUP_C\\}", groupCode);
        requestBody = requestBody.replaceAll("\\{CARD\\}", pan);
        ResponseEntity<?> responseEntity = this.manager.requestHumoRest(this.issuingUrl, HumoAction.QUERY_CARD_INFO, requestBody);
        if (responseEntity.getStatusCode() != HttpStatus.OK) {
            return ResponseEntity.ok(0);
        } else {
            Integer pinFlag = 0;

            try {
                pinFlag = QueryCardInfoMapper.extractPinFlag(responseEntity.getBody().toString());
            } catch (ParserConfigurationException var8) {
                logger.error(var8.getMessage());
            } catch (IOException var9) {
                logger.error(var9.getMessage());
            } catch (SAXException var10) {
                logger.error(var10.getMessage());
            } catch (XPathExpressionException var11) {
                logger.error(var11.getMessage());
            }

            return ResponseEntity.ok(pinFlag);
        }
    }

    public ResponseEntity<?> history(String token, LocalDateTime startDate, LocalDateTime endDate) throws TimeoutException {
        Optional<Card> card = this.cardService.getCardByToken(token);
        String pan = CardUtil.decode(((Card)card.get()).getEncPan());
        if (card.isPresent() && pan != null && !pan.isEmpty() && pan.startsWith("9860")) {
            DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
            String requestBody = "<soapenv:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:bin=\"urn:IssuingWS/binding\">\n    <soapenv:Header/>\n    <soapenv:Body>\n        <bin:queryTransactionHistory soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">\n            <ConnectionInfo xsi:type=\"urn:OperationConnectionInfo\" xmlns:urn=\"urn:issuing_v_01_02_xsd\">\n                <BANK_C xsi:type=\"xsd:string\">{BANK_C}</BANK_C>\n                <GROUPC xsi:type=\"xsd:string\">{GROUP_C}</GROUPC>\n                <EXTERNAL_SESSION_ID xsi:type=\"xsd:string\">{SESSION_ID_PARAM}</EXTERNAL_SESSION_ID>\n            </ConnectionInfo>\n            <Parameters xsi:type=\"urn:RowType_TransactionHist_Request\" xmlns:urn=\"urn:issuing_v_01_02_xsd\">\n                <CARD xsi:type=\"xsd:string\">{CARD}</CARD>\n                <BEGIN_DATE xsi:type=\"xsd:dateTime\">{BEGIN_DATE}</BEGIN_DATE>\n                <END_DATE xsi:type=\"xsd:dateTime\">{END_DATE}</END_DATE>\n                <BANK_C xsi:type=\"xsd:string\">{BANK_C}</BANK_C>\n                <GROUPC xsi:type=\"xsd:string\">{GROUP_C}</GROUPC>\n                <LOCKING_FLAG xsi:type=\"xsd:string\">{LOCKING_FLAG}</LOCKING_FLAG>\n            </Parameters>\n        </bin:queryTransactionHistory>\n    </soapenv:Body>\n</soapenv:Envelope>";
            requestBody = requestBody.replaceAll("\\{SESSION_ID_PARAM\\}", "PAYMO" + System.currentTimeMillis() + "history");
            requestBody = requestBody.replaceAll("\\{CARD}", pan);
            requestBody = requestBody.replaceAll("\\{GROUP_C}", CardUtil.getGroupCode(pan));
            requestBody = requestBody.replaceAll("\\{BANK_C}", CardUtil.getBankCode(pan));
            requestBody = requestBody.replaceAll("\\{LOCKING_FLAG}", "1");
            requestBody = requestBody.replaceAll("\\{BEGIN_DATE}", startDate.truncatedTo(ChronoUnit.SECONDS).format(formatter));
            requestBody = requestBody.replaceAll("\\{END_DATE}", endDate.truncatedTo(ChronoUnit.SECONDS).format(formatter));
            ResponseEntity<?> responseEntity = this.manager.requestHumoRest(this.issuingUrl, HumoAction.HISTORY, requestBody);
            if (responseEntity.getStatusCode() != HttpStatus.OK) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body((Object)null);
            } else {
                List responseDtos;
                try {
                    String response = responseEntity.getBody().toString();
                    if (response != null && response.length() > 0) {
                        response = "<Body>" + response.substring(response.indexOf("</ns1:queryTransactionHistoryResponse>") + 38, response.indexOf("</soapenv:Body>")) + "</Body>";
                    }

                    responseDtos = CommonMapper.xmlToHistoryResponseDto(response);
                } catch (IOException var11) {
                    var11.printStackTrace();
                    logger.error(var11.getMessage());
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body((Object)null);
                }

                return ResponseEntity.ok(responseDtos);
            }
        } else {
            return ResponseEntity.badRequest().body((Object)null);
        }
    }

    public Boolean exceedsPinTry(String pan) throws TimeoutException {
        String requestBody = "<soapenv:Envelope    xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"    xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"    xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"    xmlns:bin=\"urn:IssuingWS/binding\">\n    <soapenv:Header/>\n    <soapenv:Body>\n        <bin:getCardPinTryCounter soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">\n            <ConnectionInfo xsi:type=\"urn:OperationConnectionInfo\" xmlns:urn=\"urn:issuing_v_01_02_xsd\">\n                <BANK_C xsi:type=\"xsd:string\">{BANK_C}</BANK_C>\n                <GROUPC xsi:type=\"xsd:string\">{GROUP_C}</GROUPC>\n                <EXTERNAL_SESSION_ID xsi:type=\"xsd:string\">{SESSION_ID_PARAM}</EXTERNAL_SESSION_ID>\n            </ConnectionInfo>\n            <Parameters xsi:type=\"urn:RowType_GetCardPinTryCounter_Request\" xmlns:urn=\"urn:issuing_v_01_02_xsd\">\n                <CARD xsi:type=\"xsd:string\">{PAN}</CARD>\n            </Parameters>\n        </bin:getCardPinTryCounter>\n    </soapenv:Body>\n</soapenv:Envelope>";
        requestBody = requestBody.replaceAll("\\{PAN}", pan);
        requestBody = requestBody.replaceAll("\\{SESSION_ID_PARAM\\}", "PAYMO" + System.currentTimeMillis() + "pintry");
        requestBody = requestBody.replaceAll("\\{GROUP_C}", CardUtil.getGroupCode(pan));
        requestBody = requestBody.replaceAll("\\{BANK_C}", CardUtil.getBankCode(pan));
        ResponseEntity<?> responseEntity = this.manager.requestHumoRest(this.issuingUrl, HumoAction.getCardPinTryCounter, requestBody);
        if (responseEntity.getStatusCode() != HttpStatus.OK) {
            return Boolean.FALSE;
        } else {
            Boolean exceeds = Boolean.FALSE;

            try {
                exceeds = QueryTryCountMapper.exceedsTry(responseEntity.getBody().toString());
            } catch (ParserConfigurationException var6) {
                var6.printStackTrace();
            } catch (IOException var7) {
                var7.printStackTrace();
            } catch (SAXException var8) {
                var8.printStackTrace();
            } catch (XPathExpressionException var9) {
                var9.printStackTrace();
            }

            return exceeds;
        }
    }
}
