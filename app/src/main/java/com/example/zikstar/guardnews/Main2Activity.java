package com.example.zikstar.guardnews;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.zikstar.guardnews.Models.Edition;
import com.example.zikstar.guardnews.Models.Response23;
import com.example.zikstar.guardnews.Models.Result;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Main2Activity extends AppCompatActivity {
    ListView newsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        newsListView = (ListView) findViewById(R.id.list3);
        //getfootball();
    }

    private void getfootball() {

        String apiKey = "fa42ecfe-4fbc-4ac6-bad1-ba42e710c56c";





        Retrofit retrofit = new Retrofit.Builder()

                .baseUrl(ApiEndpointInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        ApiEndpointInterface api = retrofit.create(ApiEndpointInterface.class);

        Call<Edition> call = api.getFootball("test","thumbnail");

        call.enqueue(new Callback<Edition> () {
            @Override
            public void onResponse(Call<Edition> call, Response<Edition> response) {

                Edition MasterResponse = response.body();
                if(MasterResponse ==null){
                    return;
                }

                Response23 response23 = MasterResponse.getResponse();

                List<Result> footballList  =response23.getResults();
                if(footballList ==null ){
                    return;
                }

                //Creating an String array for the ListView
                String[] headlines = new String[footballList.size()];

                //looping through all the heroes and inserting the names inside the string array

                for (int i = 0; i < footballList.size(); i++) {
                    headlines[i] = footballList.get(i).getWebTitle();
                }


                //displaying the string array into listview
                newsListView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, headlines));
            }

            @Override
            public void onFailure(Call<Edition> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                Log.i("show me", t.getMessage());
            }



        });
    }

}


