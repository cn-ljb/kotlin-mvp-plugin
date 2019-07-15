package com.ljb.mvp.plugin.utils;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import org.apache.http.util.TextUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class PackageManager {

    public static String getModuleName(String ideaPath) {
        if (TextUtils.isEmpty(ideaPath) && !ideaPath.contains("src")) return "";
        int endIndex = ideaPath.indexOf(File.separator + "src");
        int startIndex = -1;
        char[] chars = ideaPath.toCharArray();
        for (int i = endIndex - 1; i >= 0; i--) {
            if (String.valueOf(chars[i]).equals(File.separator)) {
                startIndex = i;
                break;
            }
        }
        if (startIndex == -1) return "";
        return ideaPath.substring(startIndex + 1, endIndex);
    }

    public static String getAppPackageName(Project project, String moduleName) {
        if (TextUtils.isEmpty(moduleName)) return "";
        String packageName = "";
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(project.getBasePath() + "/" + moduleName + "/src/main/AndroidManifest.xml");
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

    public static String getPathPackageName(String path) {
        String pathPackageName = "";
        String srcJavaDir = "src" + File.separator + "main" + File.separator + "java" + File.separator;
        String srcDir = "src" + File.separator;
        if (path.contains(srcJavaDir)) {
            String replacePath = path.replace(File.separator, ".");
            pathPackageName = replacePath.substring(replacePath.indexOf("src") + srcJavaDir.length());
        } else if (path.contains(srcDir)) {
            String replacePath = path.replace(File.separator, ".");
            pathPackageName = replacePath.substring(replacePath.indexOf("src") + srcDir.length());
        }
        return pathPackageName;
    }

}
