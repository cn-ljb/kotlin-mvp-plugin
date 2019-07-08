package com.ljb.mvp.plugin.utils;

import com.intellij.openapi.project.Project;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class PackageManager {

    public static String getAppPackageName(Project project) {
        String packageName = "";
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(project.getBasePath() + "/App/src/main/AndroidManifest.xml");
            NodeList nodeList = doc.getElementsByTagName("manifest");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                Element element = (Element) node;
                packageName = element.getAttribute("package");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return packageName;
    }

    public static String getPathPackageName(String appPackageName, String path) {
        String pathPackageName = "";
        String replacePath = path.replace(File.separator, ".");
        if (!replacePath.contains(appPackageName)) {
            return pathPackageName;
        }
        return replacePath.substring(replacePath.indexOf(appPackageName));
    }

}
