package com.betwise.bwtest;

import android.Manifest;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import com.betwise.betwisebridge.webview.BetWiseWebview;

public class MainActivity extends AppCompatActivity {

    private String[] PERMISSIONS_STORAGE = new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE};
    BetWiseWebview webview;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webview = findViewById(R.id.bw_wv);
        //1 - mainNet | 2 - testNet
        webview.initWallet(2);
        webview.loadUrl("https://test-app.betwise888.com/#/index/sports");
        // Apply for permission
        ActivityCompat.requestPermissions(this, PERMISSIONS_STORAGE, 0);
    }
}
