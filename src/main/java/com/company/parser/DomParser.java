package com.company.parser;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Dell on 05.03.2017.
 */
public class DomParser {

    private Document document;
    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public void parse(String xmlPath) {

        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            document = documentBuilder.parse(
                    new File("C:\\Users\\Dell\\IdeaProjects\\WorkTime\\src\\main\\resources\\file.xml"));

            System.out.println(document.getDocumentElement().getChildNodes().getLength());
            System.out.println("Root element: " + document.getDocumentElement().getNodeName());

            if (document.hasChildNodes()) {
                print(document.getChildNodes());
            }

            saveXML("C:\\Users\\Dell\\IdeaProjects\\WorkTime\\src\\main\\resources\\addDate.xml");
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            System.out.println("Oops something was wrong");
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }

    private void print(NodeList nodeList) {

        for (int i = 0; i < nodeList.getLength(); i++) {

            Node tempNode = nodeList.item(i);

            if (tempNode.getNodeType() == Node.ELEMENT_NODE) {

                System.out.println("Node \"" + tempNode.getNodeName() + "\"");
                System.out.println("Node Value = " + tempNode.getTextContent());

                if (tempNode.getNodeName().equals("person")) {
                    if (tempNode.hasAttributes()) {
                        NamedNodeMap nodeMap = tempNode.getAttributes();

                        for (int c = 0; c < nodeMap.getLength(); c++) {

                            Node node = nodeList.item(c);
                            System.out.println("attribute \"" + node.getNodeName() + "\"=" + node.getNodeValue());

                        }
                    }

                    addDate(tempNode);
                }

                if (tempNode.getNodeName().equals("city")) {
                    tempNode.getParentNode().removeChild(tempNode);
                }

                if (tempNode.hasChildNodes()) {
                    print(tempNode.getChildNodes());
                }

                System.out.println();
            }
        }
    }

    private void addDate(Node node) {
        Node dateNode = document.createElement("date");
        dateNode.appendChild(document.createTextNode(dateFormat.format(new Date())));
        node.appendChild(dateNode);
    }

    private void saveXML(String path) {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File(path));

            transformer.transform(source, result);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            System.out.println("Oops saving failed");
        }

    }
}
