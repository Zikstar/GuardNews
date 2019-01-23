package com.example.zikstar.guardnews;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;

import com.example.zikstar.guardnews.News;
import com.example.zikstar.guardnews.QueryUtils;

import java.util.List;

public class NewsLoader extends AsyncTaskLoader<List<News>>{

    private String mUrl;

    public NewsLoader(Context context, String url){
    super(context);
    mUrl = url;

    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }


    @Nullable
    @Override
    public List<News> loadInBackground() {
        return QueryUtils.extractNews(mUrl);
    }
}
