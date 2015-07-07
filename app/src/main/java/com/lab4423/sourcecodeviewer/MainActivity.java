package com.lab4423.sourcecodeviewer;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

import java.io.IOException;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setWebView();
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


    private void setWebView() {
        ResourceFile template = null;
        ResourceFile src = null;
        try {
            template = new ResourceFile("Resources/template.html", getResources());
            src = new ResourceFile("Documents/csharp.cs", getResources());
        }
        catch (IOException ex){}

        Packet packet = new Packet(src, new Brush(FileUtils.getExtension(src)));
        PageBuilder pb = new PageBuilder(packet, template);

        WebView webView = (WebView)findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadDataWithBaseURL("file:///android_asset/", pb.build(), "text/html", "UTF-8", null);
    }
}
