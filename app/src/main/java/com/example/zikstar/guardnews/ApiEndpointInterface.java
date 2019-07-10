package com.example.zikstar.guardnews;

import com.example.zikstar.guardnews.Models.Edition;
import com.example.zikstar.guardnews.Models.Response23;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiEndpointInterface {
    public static final String BASE_URL = "https://content.guardianapis.com/";
    @GET("football")
    Call<Edition> getFootball(@Query("api-key") String key, @Query("show-fields") String showImages);

    @GET("business")
    Call<Edition> getBusiness(@Query("api-key") String key, @Query("show-fields") String showImages);

    @GET("culture")
    Call<Edition> getCulture(@Query("api-key") String key, @Query("show-fields") String showImages);

    @GET("world")
    Call<Edition> getWorld(@Query("api-key") String key, @Query("show-fields") String showImages);

    @GET("travel")
    Call<Edition> getTravel(@Query("api-key") String key, @Query("show-fields") String showImages);

    @GET("technology")
    Call<Edition> getTechnology(@Query("api-key") String key, @Query("show-fields") String showImages);

    @GET("politics")
    Call<Edition> getPolitics(@Query("api-key") String key, @Query("show-fields") String showImages);

    @GET("music")
    Call<Edition> getMusic(@Query("api-key") String key, @Query("show-fields") String showImages);

    @GET("food")
    Call<Edition> getFood(@Query("api-key") String key, @Query("show-fields") String showImages);



}
