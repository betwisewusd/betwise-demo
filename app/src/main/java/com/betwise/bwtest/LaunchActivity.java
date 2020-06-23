package com.betwise.bwtest;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.jaeger.library.StatusBarUtil;

public class LaunchActivity extends AppCompatActivity {

    @SuppressLint("ResourceType")
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        StatusBarUtil.setColor(this, Color.parseColor("#191A27"),0);
        LaunchFragment launchFragment=new LaunchFragment();
        FragmentManager manager=this.getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.add(R.id.fl_launch,launchFragment);
        transaction.commitAllowingStateLoss();
    }
}
