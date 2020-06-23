package com.betwise.bwtest;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class LaunchFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         Handler handler=new Handler();
         handler.postDelayed(new Runnable() {
             @Override
             public void run() {
                 Intent intent=new Intent(getContext(), MainActivity.class);
                 getActivity().startActivity(intent);
                 getActivity().finish();
             }
         },1000);
        return inflater.inflate(R.layout.activity_launch, null, false);
    }
}
