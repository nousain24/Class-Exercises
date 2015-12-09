package com.example.chengen.crowdsafetyalerts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.io.InputStream;

public class Loading extends Activity{
    private boolean backbtnPress;
    private static final int duration = 100000;
    private Handler myHandler;
    private WebView webviewActionView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        setContentView(R.layout.activity_loading);
        myHandler = new Handler();
        InputStream stream = null;
        try {
            stream = getAssets().open("C:\\Users\\Chengen\\Desktop\\Img\\crowdsafeloading.GIF");
        } catch (Exception e) {
            e.printStackTrace();
        }

        webviewActionView = (WebView) findViewById(R.id.webView);
        webviewActionView.setWebViewClient(new MyWebViewClient());
        webviewActionView.getSettings().setJavaScriptEnabled(true);

        GifWebView view = new GifWebView(this, stream);
        webviewActionView.addView(view);
        myHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
                if (!backbtnPress) {
                    Intent intent = new Intent(Loading.this, MainActivity.class);
                    Loading.this.startActivity(intent);
                }
            }
        },duration);
    }


    private class MyWebViewClient extends WebViewClient {
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    @Override
    public void onBackPressed() {
        backbtnPress = true;
        super.onBackPressed();
    }
}
