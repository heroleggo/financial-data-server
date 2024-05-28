package com.heroleggo.financial.core.base;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

@Component
public class XMLUnmarshaller {
    @Value("${xml.path}")
    private String path;

    @Value("${xml.filename}")
    private String filename;

    public List<DartCompanyMetadata> unmarshall() {
        ArrayList<DartCompanyMetadata> result = new ArrayList<>();
        String filePath = path + filename;

        try {
            File inputXMLFile = new File(filePath);

            Document document = getDocument(inputXMLFile);

            document.getDocumentElement().normalize();

            NodeList nodeList = document.getElementsByTagName("list");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    DartCompanyMetadata data = parseData(element);

                    result.add(data);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        return result;
    }

    private Document getDocument(File file) throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

        return documentBuilder.parse(file);
    }

    private DartCompanyMetadata parseData(Element element) {
        String corporationCode = element.getElementsByTagName("corp_code").item(0).getTextContent();
        String corporationName = element.getElementsByTagName("corp_name").item(0).getTextContent();
        String stockCode = element.getElementsByTagName("stock_code").item(0).getTextContent();
        String stringDate = element.getElementsByTagName("modify_date").item(0).getTextContent();
        Date modifiedAt = toDate(stringDate);

        return DartCompanyMetadata.of(corporationCode, corporationName, stockCode, modifiedAt);
    }

    private Date toDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate localDate = LocalDate.parse(date, formatter);

        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
}
