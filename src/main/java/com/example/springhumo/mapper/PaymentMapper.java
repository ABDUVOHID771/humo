package com.example.springhumo.mapper;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class PaymentMapper {
    public PaymentMapper() {
    }

    public static String extractStatusFromGetPayment(String response) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        ByteArrayInputStream input = new ByteArrayInputStream(response.getBytes("UTF-8"));
        Document doc = documentBuilder.parse(input);
        XPath xPath = XPathFactory.newInstance().newXPath();
        String expression = "//status";
        Node node = (Node)xPath.compile(expression).evaluate(doc, XPathConstants.NODE);
        String status = node.getTextContent();
        return status;
    }
}
