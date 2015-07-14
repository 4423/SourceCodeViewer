package com.lab4423.sourcecodeviewer;

import android.content.res.Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ResourceFile {

    private String path;
    private InputStream inputStream;


    public ResourceFile(String path, Resources resources) throws IOException{
        this.path = path;
        this.inputStream = resources.getAssets().open(path);
    }

    public ResourceFile(File file) throws IOException{
        this.path = file.getPath();
        this.inputStream = new FileInputStream(file);
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }
}
