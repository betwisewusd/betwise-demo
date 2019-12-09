package com.betwise.bwtest;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.betwise.betwisebridge.plugin.WalletPlugins;
import com.betwise.betwisebridge.webview.BetWiseWebview;
import com.github.lzyzsd.jsbridge.CallBackFunction;

public class MainActivity extends AppCompatActivity {
    BetWiseWebview webview;
    Context mContext;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webview = findViewById(R.id.bw_wv);
        webview.initWallet(2);

        mContext = this;
        String args = "{\"helpStr\":\"eight grain wine scrap recipe image undo rent very imitate decide jump\",\"password\":\"123456\"}";
        WalletPlugins.Companion.notifyAppCheckMnemonics(args, new CallBackFunction(){
            @Override
            public void onCallBack(String data) {
                WalletPlugins.Companion.notifyAppSaveWallet(mContext, data, new CallBackFunction(){
                    @Override
                    public void onCallBack(String data) {
                        load();
                    }
                });

            }
        });
    }

    private void load(){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                webview.loadUrl("https://dev-h5.wiccdev.org/game/index.html#/dice");
            }
        });
    }
}
