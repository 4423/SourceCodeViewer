package com.lab4423.sourcecodeviewer;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class FileUtils {

    public static String readAll(InputStream src) throws IOException {
        return readAllCore(new BufferedReader(new InputStreamReader(src)));
    }

    private static String readAllCore(BufferedReader br) throws IOException{
        try {
            StringBuffer sb = new StringBuffer();
            int c;
            while ((c = br.read()) != -1) {
                sb.append((char) c);
            }
            return sb.toString();
        }
        finally {
            br.close();
        }
    }

    public static void write(String str, ResourceFile dest) throws IOException {
        OutputStream fos = new FileOutputStream(dest.getPath());
        fos.write(str.getBytes());
    }

    public static String getExtension(String file) {
        if (file != null) {
            int pos = file.lastIndexOf(".");
            if (pos != -1) {
                return file.substring(pos + 1);
            }
        }
        return null;
    }

    public static String getExtension(ResourceFile file) {
        return getExtension(file.getPath());
    }
}