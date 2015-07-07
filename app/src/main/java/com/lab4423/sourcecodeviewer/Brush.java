package com.lab4423.sourcecodeviewer;

public class Brush {

    private BrushType type;
    private String javaScriptFile;
    private String alias;


    public Brush(String extension) {
        switch (extension.toLowerCase()) {
            //TODO　拡張子が不明なものはコメントアウトしてある
            /*case "as3":
                this.alias = "as3";
                this.javaScriptFile = "shBrushAS3.js";
                this.type = BrushType.ActionScript3;
                break;*/
            case "sh":
                this.alias = "shell";
                this.javaScriptFile = "shBrushBash.js";
                this.type = BrushType.Shell;
                break;
            /*case "":
                this.alias = "coldfusion";
                this.javaScriptFile = "shBrushColdFusion.js";
                this.type = BrushType.ColdFusion;
                break;*/
            case "c" :
            case "cpp" :
                this.alias = "cpp";
                this.javaScriptFile = "shBrushCpp.js";
                this.type = BrushType.Cpp;
                break;
            case "cs":
                this.alias = "c-sharp";
                this.javaScriptFile = "shBrushCSharp.js";
                this.type = BrushType.CSharp;
                break;
            case "css":
                this.alias = "css";
                this.javaScriptFile = "shBrushCss.js";
                this.type = BrushType.CSS;
                break;
            case "pas":
                this.alias = "delphi";
                this.javaScriptFile = "shBrushDelphi.js";
                this.type = BrushType.Delphi;
                break;
            case "diff":
                this.alias = "diff";
                this.javaScriptFile = "shBrushDiff.js";
                break;
            case "erl":
                this.alias = "erlang";
                this.javaScriptFile = "shBrushErlang.js";
                this.type = BrushType.Erlang;
                break;
            /*case "":
                this.alias = "groovy";
                this.javaScriptFile = "shBrushGroovy.js";
                this.type = BrushType.Groovy;
                break;*/
            case "java":
                this.alias = "java";
                this.javaScriptFile = "shBrushJava.js";
                this.type = BrushType.Java;
                break;
            case "fx":
                this.alias = "javafx";
                this.javaScriptFile = "shBrushJavaFX.js";
                this.type = BrushType.JavaFX;
                break;
            case "js":
                this.alias = "js";
                this.javaScriptFile = "shBrushJScript.js";
                this.type = BrushType.JavaScript;
                break;
            case "pl":
                this.alias = "perl";
                this.javaScriptFile = "shBrushPerl.js";
                this.type = BrushType.Perl;
                break;
            case "php":
                this.alias = "php";
                this.javaScriptFile = "shBrushPhp.js";
                this.type = BrushType.PHP;
                break;
            case "ps1":
                this.alias = "ps";
                this.javaScriptFile = "shBrushPowerShell.js";
                this.type = BrushType.PowerShell;
                break;
            case "py":
                this.alias = "py";
                this.javaScriptFile = "shBrushPython.js";
                this.type = BrushType.Python;
                break;
            case "rb":
                this.alias = "ruby";
                this.javaScriptFile = "shBrushRuby.js";
                this.type = BrushType.Ruby;
                break;
            case "scala":
                this.alias = "scala";
                this.javaScriptFile = "shBrushScala.js";
                this.type = BrushType.Scala;
                break;
            case "sql":
                this.alias = "sql";
                this.javaScriptFile = "shBrushSql.js";
                this.type = BrushType.SQL;
                break;
            case "vb":
                this.alias = "vb";
                this.javaScriptFile = "shBrushVb.js";
                this.type = BrushType.VisualBasic;
                break;
            case "xml":
            case "xaml":
            case "html":
            case "xhtml":
            case "xslt":
                this.alias = "xml";
                this.javaScriptFile = "shBrushXml.js";
                this.type = BrushType.XML;
                break;
            default:
                this.alias = "plain";
                this.javaScriptFile = "shBrushPlain.js";
                this.type = BrushType.PlainText;
                break;
        }
    }


    public String getJavaScriptFile() {
        return this.javaScriptFile;
    }

    public BrushType getBrushType() {
        return this.type;
    }

    public String getAlias() {
        return this.alias;
    }
}