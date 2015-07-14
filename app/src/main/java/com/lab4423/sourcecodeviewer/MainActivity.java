package com.lab4423.sourcecodeviewer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

import java.io.File;
import java.io.IOException;


public class MainActivity extends ActionBarActivity {

    private WebView webView;
    private ResourceFile template;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.settings();

        //Intent始動の起動かどうか
        if (Intent.ACTION_VIEW.equals(this.getIntent().getAction())) {
            this.onLaunchedFromLauncher(this.getIntent());
        }
        else {
            this.onLaunched();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private void settings() {
        try {
            this.template = new ResourceFile("Resources/template.html", getResources());
        }
        catch (IOException ex) {
            Log.v("", this.getString(R.string.io_exception_message));
        }

        //settings WebView
        this.webView = (WebView)this.findViewById(R.id.webView);
        this.webView.getSettings().setJavaScriptEnabled(true);
    }

    private void onLaunchedFromLauncher(Intent intent) {
        //現時点では内部メモリにのみ対応（＆機種依存の可能性あり）
        String url = intent.getDataString().replace("file:///storage/emulated/0", "/sdcard");
        ResourceFile src = null;
        try {
            src = new ResourceFile(new File(url));
        }
        catch (IOException ex) {
            Log.v("", this.getString(R.string.io_exception_message));
            return;
        }
        this.loadWebView(src);
    }

    private void onLaunched() {
        ResourceFile src = null;
        try {
            src = new ResourceFile("Documents/csharp.cs", getResources());
        }
        catch (IOException ex) {
            Log.v("", this.getString(R.string.io_exception_message));
            return;
        }
        this.loadWebView(src);
    }

    private void loadWebView(ResourceFile file) {
        Packet packet = new Packet(file, new Brush(FileUtils.getExtension(file)));
        PageBuilder pb = new PageBuilder(packet, template);
        this.webView.loadDataWithBaseURL("file:///android_asset/", pb.build(), "text/html", "UTF-8", null);
    }
}
