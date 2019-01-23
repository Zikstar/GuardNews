package com.example.zikstar.guardnews;

public class News {
    private String mHeadline;
    private String mTime;
    private String mNewsUrl;
    private String mSectionName;
    private String mImageUrl;



    public News(String headline, String time, String url, String section, String imgUrl){
        mHeadline = headline;
        mTime = time;
        mNewsUrl = url;
        mSectionName = section;
        mImageUrl = imgUrl;

    }


    public String getHeadline(){
        return mHeadline;
    }
    public String getTime(){
        return mTime;
    }

    public String getNewsUrl(){
        return mNewsUrl;
    }

    public String getSectionName(){
        return mSectionName;
    }

    public String getImageUrl(){
        return mImageUrl;
    }



}
