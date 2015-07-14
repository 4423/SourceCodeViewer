package com.lab4423.sourcecodeviewer;

import android.util.Log;

import java.io.IOException;

public class PageBuilder {

    private Packet packet;
    private ResourceFile template;
    private String style = "shThemeDefault.css";

    public void setStyle(String style) {
        this.style = style;
    }


    public PageBuilder(Packet packet, ResourceFile template) {
        if(packet == null) {
            throw new IllegalArgumentException();
        }
        this.packet = packet;
        this.template = template;
    }


    /**
     * HTMLファイルを生成します。
     * @return SyntaxHighliterの指定がされたHTMLファイル
     */
    public String build() {
        try {
            return FileUtils.readAll(this.template.getInputStream())
                    .replace("###js###", this.packet.getBursh().getJavaScriptFile())
                    .replace("###css###", this.style)
                    .replace("###file_name###", this.packet.getFile().getPath())
                    .replace("###brush_alias###", this.packet.getBursh().getAlias())
                    .replace("###content###", FileUtils.readAll(this.packet.getFile().getInputStream()));
        }
        catch (IOException ex) {
            Log.v("", "ファイルアクセスに失敗しました。");
            return null;
        }
    }
}