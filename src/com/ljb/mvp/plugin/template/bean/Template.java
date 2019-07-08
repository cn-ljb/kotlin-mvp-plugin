package com.ljb.mvp.plugin.template.bean;

import java.io.File;

public class Template {

    private String dir;
    private String fileName;
    private String content;
    private File file;

    public File getFile() {
        if (file == null) file = new File(dir, fileName);
        return file;
    }

    public Template(String dir, String fileName, String content) {
        this.dir = dir;
        this.fileName = fileName;
        this.content = content;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
