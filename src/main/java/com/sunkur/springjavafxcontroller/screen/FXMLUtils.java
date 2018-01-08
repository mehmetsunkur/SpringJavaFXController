/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sunkur.springjavafxcontroller.screen;

import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/**
 *
 * @author Mehmet Sunkur <mehmetsunkur@gmail.com>
 */
public class FXMLUtils {
    public static Class getControllerClass(String fxmlPath) {

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder;
            builder = factory.newDocumentBuilder();
            URL location = FXMLUtils.class.getResource(fxmlPath);
            Document document = builder.parse(location.openStream());
            NamedNodeMap attributes = document.getDocumentElement().getAttributes();
            String fxControllerClassName=null;
            for (int i = 0; i < attributes.getLength(); i++) {
                Node item = attributes.item(i);
                if(item.getNodeName().equals(FXMLLoader.FX_NAMESPACE_PREFIX+":"+FXMLLoader.CONTROLLER_KEYWORD)){
                    fxControllerClassName = item.getNodeValue();
                }
            }
            if(fxControllerClassName!=null)
                return ClassLoader.getSystemClassLoader().loadClass(fxControllerClassName);
        } catch (ParserConfigurationException | SAXException | IOException | ClassNotFoundException ex) {
            Logger.getLogger(ScreensContoller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
