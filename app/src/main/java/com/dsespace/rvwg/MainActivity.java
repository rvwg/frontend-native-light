package com.dsespace.rvwg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    //needed to use the goBack()-Method
    private WebView rvwg_home;

    //enable goBack()-Method
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // Check if the key event was the Back button and if there's history
        if ((keyCode == KeyEvent.KEYCODE_BACK) && rvwg_home.canGoBack()) {
            rvwg_home.goBack();
            return true;
        }
        // If it wasn't the Back key or there's no web page history, bubble up to the default
        // system behavior (probably exit the activity)
        return super.onKeyDown(keyCode, event);
    }

    //start webview onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //load the webview
        rvwg_home = (WebView) findViewById(R.id.webview); //edited the original syntax from google to prevent from crashing by killing the whole activity
        rvwg_home.loadUrl("http://hp.rvwg-web.de/index.php?id=209");

        //make it possible to run JavaScript
        WebSettings webSettings = rvwg_home.getSettings();
        webSettings.setJavaScriptEnabled(true);

        //make opening links inside the webview possible
        rvwg_home.setWebViewClient(new WebViewClient());

        //clear cache to prevent the webview from not getting the newest content
        rvwg_home.clearCache(true);
    }
}