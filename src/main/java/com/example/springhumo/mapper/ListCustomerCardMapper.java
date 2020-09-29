package com.example.springhumo.mapper;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import com.example.springhumo.model.dto.humo.response.ListCustomerCard;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ListCustomerCardMapper {
    private static Logger logger = LogManager.getLogger(ListCustomerCardMapper.class);

    public ListCustomerCardMapper() {
    }

    public static List<ListCustomerCard> mapToListCustomerCards(String response) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        ByteArrayInputStream input = new ByteArrayInputStream(response.getBytes("UTF-8"));
        Document doc = documentBuilder.parse(input);

        try {
            List<String> metaIds = extractMetaData(doc);
            Map<String, List<String>> cardAttributeReferenceIds = extractCardAttributeReferences(doc, metaIds);
            List<ListCustomerCard> cards = generateCardMapList(doc, cardAttributeReferenceIds);
            return cards;
        } catch (XPathExpressionException var8) {
            logger.error(var8.getMessage());
            return Collections.emptyList();
        }
    }

    private static List<String> extractMetaData(Document doc) throws XPathExpressionException {
        XPath xPath = XPathFactory.newInstance().newXPath();
        String expression = "//row";
        NodeList nodeList = (NodeList)xPath.compile(expression).evaluate(doc, XPathConstants.NODESET);
        List<String> ids = new ArrayList();

        for(int i = 0; i < nodeList.getLength(); ++i) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == 1) {
                Element element = (Element)node;
                String id = element.getAttribute("href");
                if (id != null) {
                    id = id.replaceAll("#", "");
                    ids.add(id);
                }
            }
        }

        return ids;
    }

    private static Map<String, List<String>> extractCardAttributeReferences(Document doc, List<String> ids) throws XPathExpressionException {
        Map<String, List<String>> cardAttributeReferenceIds = new HashMap();
        Iterator var3 = ids.iterator();

        while(var3.hasNext()) {
            String id = (String)var3.next();
            List<String> attributeIds = new ArrayList();
            XPath xPath = XPathFactory.newInstance().newXPath();
            String expression = "//multiRef[@id='" + id + "']/item";
            NodeList node = (NodeList)xPath.compile(expression).evaluate(doc, XPathConstants.NODESET);

            for(int i = 0; i < node.getLength(); ++i) {
                Element element = (Element)node.item(i);
                String attributeId = element.getAttribute("href");
                if (attributeId != null) {
                    attributeId = attributeId.replaceAll("#", "");
                    attributeIds.add(attributeId);
                }
            }

            cardAttributeReferenceIds.put(id, attributeIds);
        }

        return cardAttributeReferenceIds;
    }

    private static List<ListCustomerCard> generateCardMapList(Document doc, Map<String, List<String>> cardAttributeReferences) throws XPathExpressionException {
        List<ListCustomerCard> cards = new ArrayList();
        Iterator var3 = cardAttributeReferences.keySet().iterator();

        while(var3.hasNext()) {
            String key = (String)var3.next();
            List<String> references = (List)cardAttributeReferences.get(key);
            Map<String, String> card = new HashMap();
            Iterator var7 = references.iterator();

            while(var7.hasNext()) {
                String reference = (String)var7.next();
                Map<String, String> valueAndName = extractMultiRefValueAndName(doc, reference);
                card.putAll(valueAndName);
            }

            cards.add(new ListCustomerCard(card));
        }

        return cards;
    }

    private static Map<String, String> extractMultiRefValueAndName(Document doc, String multiRefId) throws XPathExpressionException {
        XPath xPath = XPathFactory.newInstance().newXPath();
        String expression = "//multiRef[@id='" + multiRefId + "']/name";
        Node nameNode = (Node)xPath.compile(expression).evaluate(doc, XPathConstants.NODE);
        expression = "//multiRef[@id='" + multiRefId + "']/value";
        Node valueNode = (Node)xPath.compile(expression).evaluate(doc, XPathConstants.NODE);
        Map<String, String> map = new HashMap();
        map.put(nameNode.getFirstChild().getNodeValue(), valueNode.getFirstChild().getNodeValue());
        return map;
    }
}
