package com.example.zikstar.guardnews.Models;

import com.example.zikstar.guardnews.News;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

public class NewsResults {
//    public class BoxOfficeMovieResponse {
//
//        List<Movie> movies;
//
//        // public constructor is necessary for collections
//        public BoxOfficeMovieResponse() {
//            movies = new ArrayList<Movie>();
//        }


    List<News> results;

    public NewsResults(){
        results = new ArrayList<News>();
    }


    public static NewsResults parseJSON(String response) {
        String ISO_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZ";
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat(ISO_FORMAT);
        Gson gson = gsonBuilder.create();

        NewsResults newsResults = gson.fromJson(response, NewsResults.class);
        return newsResults;
    }

}
