package com.example.zikstar.guardnews.Fragments;


import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.zikstar.guardnews.Models.Result;

import com.example.zikstar.guardnews.newGuardAdapter;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class BusinessFragment extends FootballFragment{


    public BusinessFragment() {
        // Required empty public constructor
    }

    newGuardAdapter mainAdapter;
    private ProgressBar progress;
    SwipeRefreshLayout pullToRefresh;
    private List<Result> news;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return getView(inflater, container, savedInstanceState,2);

    }
}
