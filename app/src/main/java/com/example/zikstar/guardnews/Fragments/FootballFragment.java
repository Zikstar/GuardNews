package com.example.zikstar.guardnews.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zikstar.guardnews.ApiEndpointInterface;
import com.example.zikstar.guardnews.Models.Edition;
import com.example.zikstar.guardnews.Models.Response23;
import com.example.zikstar.guardnews.Models.Result;
import com.example.zikstar.guardnews.R;
import com.example.zikstar.guardnews.newGuardAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.zikstar.guardnews.MainActivity.LOG_TAG;


public class FootballFragment extends Fragment{

    private static final String GUARDIANURL = "https://content.guardianapis.com/football?api-key=test&show-fields=thumbnail&page-size=35";
    newGuardAdapter mainAdapter;
    private ProgressBar progress;
    SwipeRefreshLayout pullToRefresh;
    private List<Result> news;







    public FootballFragment() {
        // Required empty public constructor
    }




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View rootview = inflater.inflate(R.layout.fragment_football, container, false);
//
//        progress = (ProgressBar) rootview.findViewById(R.id.loading_spinner);
//        pullToRefresh = (SwipeRefreshLayout) rootview.findViewById(R.id.pullToRefresh);
//        final TextView empty = (TextView) rootview.findViewById(R.id.emptyState);
//
//
//        ListView newsListView = (ListView)rootview.findViewById(R.id.list);
//
//        mainAdapter = new newGuardAdapter(getContext(),0);
//
//        Retrofit retrofit = new Retrofit.Builder()
//
//                .baseUrl(ApiEndpointInterface.BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
//                .build();
//
//
//        final ApiEndpointInterface api = retrofit.create(ApiEndpointInterface.class);
//
//
//
//
//        newsListView.setAdapter(mainAdapter);
//
//        newsListView.setEmptyView(empty);
//
//
//
//
//        ConnectivityManager cm =
//                (ConnectivityManager) getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
//
//        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
//        final boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();
//
//
//
//
//        if(isConnected){
//
//            Call<Edition> call = api.getFootball("test","thumbnail");
//
//            call.enqueue(new Callback<Edition>() {
//                @Override
//                public void onResponse(Call<Edition> call, Response<Edition> response) {
//
//                    Edition MasterResponse = response.body();
//                    if (MasterResponse == null) {
//                        return;
//                    }
//
//                    Response23 response23 = MasterResponse.getResponse();
//
//                    news = response23.getResults();
//                }
//
//                @Override
//                public void onFailure(Call<Edition> call, Throwable t) {
//                    Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
//                    Log.i("show me", t.getMessage());
//                }
//            });
//
//            if(news != null && !news.isEmpty()){
//
//                mainAdapter.addAll(news);
//            }
//
//            //not sure of the code after this comment in load finished
//            progress.setVisibility(View.GONE);
//
//        } else{
//
//            progress.setVisibility(View.GONE);
//            empty.setText("No Internet Connection");
//        }
//        pullToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//
//                Log.i("tellme","I am refreshing");
//                Call<Edition> call = api.getFootball("test","thumbnail");
//                mainAdapter.notifyDataSetChanged();
//                pullToRefresh.setRefreshing(false);
//
//                if(!isConnected){
//                    progress.setVisibility(View.GONE);
//                    empty.setText("No Internet Connection");
//                }
//
//            }
//        });
//        newsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                Result currentNews = mainAdapter.getItem(position);
//                Uri newsUri = Uri.parse(currentNews.getWebUrl());
//                Intent intent = new Intent(Intent.ACTION_VIEW, newsUri);
//                startActivity(intent);
//            }
//        });




        return getView(inflater,container,savedInstanceState,1);


    }

    public View getView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState, int id){
        View rootview = inflater.inflate(R.layout.fragment_football, container, false);

        progress = (ProgressBar) rootview.findViewById(R.id.loading_spinner);
        pullToRefresh = (SwipeRefreshLayout) rootview.findViewById(R.id.pullToRefresh);
        final TextView empty = (TextView) rootview.findViewById(R.id.emptyState);


        ListView newsListView = (ListView)rootview.findViewById(R.id.list);

        mainAdapter = new newGuardAdapter(getContext(),0);

        long t1 = System.nanoTime();
        Retrofit retrofit = new Retrofit.Builder()

                .baseUrl(ApiEndpointInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();


        final ApiEndpointInterface api = retrofit.create(ApiEndpointInterface.class);
        Call<Edition> mCall = null;
        switch(id){
            case 0:
                mCall = api.getWorld("test","thumbnail");
                break;

            case 1:
                mCall = api.getFootball("test","thumbnail");
                break;

            case 2:
                mCall = api.getBusiness("test","thumbnail");
                break;

            case 3:
                mCall = api.getCulture("test","thumbnail");
                break;

            case 4:
                mCall = api.getFood("test","thumbnail");
                break;
            case 5:
                mCall = api.getMusic("test","thumbnail");
                break;
            case 6:
                mCall = api.getPolitics("test","thumbnail");
                break;
            case 7:
                mCall = api.getTechnology("test","thumbnail");
                break;
            case 8:
                mCall = api.getTravel("test","thumbnail");
                break;



        }
        long t2 = System.nanoTime();
        long duration =(t2 - t1)/1000000;
        Log.i(LOG_TAG,"retrofit duration: "+ duration);


        newsListView.setAdapter(mainAdapter);

        newsListView.setEmptyView(empty);


        ConnectivityManager cm =
                (ConnectivityManager) getContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        final boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();




        if(isConnected){

            long t3 = System.nanoTime();
            mCall.enqueue(new Callback<Edition>() {
                @Override
                public void onResponse(Call<Edition> call, Response<Edition> response) {

                    Edition MasterResponse = response.body();
                    if (MasterResponse == null) {
                        return;
                    }

                    //Response23 response23 = MasterResponse.getResponse();

                    news = MasterResponse.getResponse().getResults();
                }

                @Override
                public void onFailure(Call<Edition> call, Throwable t) {
                    Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                    Log.i("show me", t.getMessage());
                }
            });

            long t4 = System.nanoTime();
            duration =(t4 - t3)/1000000;
            Log.i(LOG_TAG,"call duration: "+ duration);


            long t5 = System.nanoTime();
            if(news != null && !news.isEmpty()){

                mainAdapter.addAll(news);
                //not sure of the code after this comment in load finished
                progress.setVisibility(View.GONE);
            }

            long t6 = System.nanoTime();
            duration =(t6 - t5)/1000000;
            Log.i(LOG_TAG,"loading adapter duration: "+ duration);


        } else{

            progress.setVisibility(View.GONE);
            empty.setText("No Internet Connection");
        }
        pullToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                Log.i("tellme","I am refreshing");
                Call<Edition> call = api.getFootball("test","thumbnail");
                mainAdapter.notifyDataSetChanged();
                pullToRefresh.setRefreshing(false);

                if(!isConnected){
                    progress.setVisibility(View.GONE);
                    empty.setText("No Internet Connection");
                }

            }
        });
        newsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Result currentNews = mainAdapter.getItem(position);
                Uri newsUri = Uri.parse(currentNews.getWebUrl());
                Intent intent = new Intent(Intent.ACTION_VIEW, newsUri);
                startActivity(intent);
            }
        });




        return rootview;

    }




}
