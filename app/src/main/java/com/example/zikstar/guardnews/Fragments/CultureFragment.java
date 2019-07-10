package com.example.zikstar.guardnews.Fragments;


import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.zikstar.guardnews.Models.Result;
import com.example.zikstar.guardnews.newGuardAdapter;

import java.util.List;

import static com.example.zikstar.guardnews.MainActivity.LOG_TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class CultureFragment extends FootballFragment {

    public CultureFragment(){

    }

    newGuardAdapter mainAdapter;
    private ProgressBar progress;
    SwipeRefreshLayout pullToRefresh;
    private List<Result> news;


    long t1 = System.nanoTime();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root =  getView(inflater, container, savedInstanceState,3);

        long t2 = System.nanoTime();
        long duration =(t2 - t1)/1000000;

        Log.i(LOG_TAG ,"culture duration: "+ duration);
        return root;

    }





}
