package com.example.zikstar.guardnews.Fragments;


import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 */
public class TravelFragment extends FootballFragment {


    public TravelFragment() {
        // Required empty public constructor
    }


    private static final String GUARDIANURL2 = "https://content.guardianapis.com/travel?api-key=test&show-fields=thumbnail&page-size=35";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return getView(inflater, container, savedInstanceState,8);
    }
}
