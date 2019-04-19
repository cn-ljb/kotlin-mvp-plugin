package com.ljb.mvp.plugin.utils;

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

}
