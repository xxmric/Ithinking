package com.example.ithinking.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.ithinking.R;

/**
 * Created by Administrator on 2016/3/17.
 */
public class Fragment5 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_5,null); //加载布局页面
    }
}
