package com.betwise.bwtest;

import android.Manifest;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import com.betwise.betwisebridge.webview.BetWiseWebview;
import com.jaeger.library.StatusBarUtil;

public class MainActivity extends AppCompatActivity {

    private String[] PERMISSIONS_STORAGE = new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE};
    BetWiseWebview webview;
    private LoadingDialog dialog=null;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
       // requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dialog=new LoadingDialog(this,R.style.DialogFullscreen);
        dialog.show();
        webview = findViewById(R.id.bw_wv);
        //1 - mainNet | 2 - testNet
        webview.initWallet(2);
        webview.loadUrl("https://m.betwise888.com/#/index/sports");
       //("https://test-app.betwise888.com/#/index/sports");
        // Apply for permission
        webview.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                if (progress == 100) {
                    //加载完成
                    dialog.dismiss();
                }
            }
        });
        StatusBarUtil.setColor(this, Color.parseColor("#191A27"),0);
        ActivityCompat.requestPermissions(this, PERMISSIONS_STORAGE, 0);
    }
}
