package com.ljb.mvp.plugin.utils;

import com.intellij.ide.IdeView;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.LangDataKeys;
import com.intellij.psi.PsiDirectory;

import java.io.*;

public class FileUtils {


    public static void writeToFile(String content, String dir, String className) {
        File floder = new File(dir);
        if (!floder.exists()) {
            floder.mkdirs();
        }
        try {
            File file = new File(dir + "/" + className);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String fillTemplateContent(String content, String moduleName, String packageName, String date) {
        if (content.contains("$moduleName_")) {
            content = content.replace("$moduleName_", moduleName);
        }
        if (content.contains("$packageName_")) {
            content = content.replace("$packageName_", packageName);
        }
        if (content.contains("$author_")) {
            content = content.replace("$author_", "Kotlin MVP Plugin");
        }
        if (content.contains("$date_")) {
            content = content.replace("$date_", date);
        }
        if (content.contains("$des_")) {
            content = content.replace("$des_", "input description");
        }
        return content;
    }


    public static String readTemplateFile(InputStream inputStream) {
        String content = "";
        try {
            content = new String(readStream(inputStream));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }


    private static byte[] readStream(InputStream inputStream) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = -1;
        try {
            while ((len = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            outputStream.close();
            inputStream.close();
        }
        return outputStream.toByteArray();
    }

    /**
     * 当前鼠标光标所在位置
     */
    public static String getCursorPath(AnActionEvent event) {
        String cursorPath = "";
        IdeView ideView = event.getRequiredData(LangDataKeys.IDE_VIEW);
        PsiDirectory directory = ideView.getOrChooseDirectory();
        if (directory != null) {
            cursorPath = directory.toString();
            if (cursorPath.startsWith("PsiDirectory:")) {
                cursorPath = cursorPath.substring("PsiDirectory:".length());
            }
        }
        return cursorPath;
    }

    public static String checkPath(String path) {
        //考虑开发者习惯在act目录和fragment创建类，进行目录矫正
        if (path.contains("view") && (path.endsWith("act") || path.endsWith("fragment"))) {
            int viewPathIndex = path.indexOf(File.separator + "view");
            path = path.substring(0, viewPathIndex);
        }
        return path;
    }
}
