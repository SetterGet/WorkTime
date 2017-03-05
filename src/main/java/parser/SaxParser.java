package parser;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by Dell on 05.03.2017.
 */
public class SaxParser {
    public void parse(String xmlPath) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            saxParser.parse(xmlPath, new SaxHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private  class SaxHandler extends DefaultHandler {
        String content = null;

        public void startElement (String url, String localName, String qName,
                                  Attributes attributes) throws SAXException {
            switch (qName) {
                case "person" : {
                    System.out.println("id=" + attributes.getValue("id"));
                    System.out.println("type=" + attributes.getValue("type"));
                    break;
                }
            }
        }

        public void endElement(String url, SAXException localName,
                               String qName) throws SAXException {
            switch (qName) {
                case "city": {
                    System.out.println(qName + ":" + content);
                    break;
                }
                case "name": {
                    System.out.println(qName + ":" + content);
                    break;
                }
            }
        }

        public void characters(char []ch, int start, int length) throws SAXException {
            content = String.copyValueOf(ch, start, length).trim();
        }
    }
}
