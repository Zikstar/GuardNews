package com.example.zikstar.guardnews;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class QueryUtils {



    private QueryUtils(){
        //empty constructor on purpose
    }


    public static List<News> extractNews(String url){

        String JsonResponse = "";
        try {
             JsonResponse = makeHTTPRequest(url);
        } catch (IOException e) {
            Log.e("logTag","Error in making http request and getting JsonResponse" );
        }


        return ExtractJson(JsonResponse);


    }



    private static String makeHTTPRequest(String url) throws IOException {

        URL newUrl = null;

        try {
             newUrl = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        //first I need an instance of URLconnection to openConnection the url into and perform the
        //networking operations on.
        //Then I need an instance of the inputStream to read data from the URLconnection into
        HttpURLConnection urlConn = null;
        InputStream inputStream = null;
        String jsonReceived = "";

        try{
            if (newUrl != null) {
                urlConn =(HttpURLConnection) newUrl.openConnection();
                urlConn.setReadTimeout(10000 /*milliseconds*/);
                urlConn.setConnectTimeout(15000 /*milliseconds*/);
                urlConn.setRequestMethod("GET");
                urlConn.connect();


                if(urlConn.getResponseCode() == 200){
                    inputStream = urlConn.getInputStream();
                    jsonReceived = readFromStream(inputStream);

                }else{
                    Log.e("logTag", "This is the error HTTP response code " + urlConn.getResponseCode());
                }
            }

        }catch (IOException e){
            e.printStackTrace();
        }finally{

            if(urlConn != null){ urlConn.disconnect();}
            if(inputStream != null){inputStream.close();}

        }



    return jsonReceived;
    }

    private static String readFromStream(InputStream inputStream) throws IOException{

        StringBuilder stringBuilder = new StringBuilder();

        if(inputStream != null){

            InputStreamReader inputReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader bufferedReader = new BufferedReader(inputReader);
            String line = bufferedReader.readLine();

            while(line != null){
                //append the read line to the stringBuilder
                stringBuilder = stringBuilder.append(line);
                //after which, please read another line from the bufferedReader
                line = bufferedReader.readLine();
            }

        }
        return  stringBuilder.toString();
    }



    private static ArrayList<News> ExtractJson(String JsonResponse){

        ArrayList<News> allNewsObjects = new ArrayList<>();

        try {
            JSONObject allData = new JSONObject(JsonResponse);
            JSONObject response = allData.optJSONObject("response");
            JSONArray results = response.optJSONArray("results");

            Log.i("mandem", " "+results.length());

            for(int i = 0; i < results.length(); i++){

                JSONObject object = results.getJSONObject(i);

                String imageUrl = null;
                String headline = object.getString("webTitle");
                String sectionName = object.getString("sectionName");
                String newsUrl = object.getString("webUrl");
                String date = object.getString("webPublicationDate");
                JSONObject fields = object.optJSONObject("fields");
                if(fields != null){
                    imageUrl = fields.optString("thumbnail");
                }


                News newsObject = new News(headline, date, newsUrl, sectionName, imageUrl);


                Log.i("mandem", "headline " +headline+ "\ndate " +date +"\nsectionName " + sectionName);

               allNewsObjects.add(newsObject);


            }




        } catch (JSONException e) {
            e.printStackTrace();
        }

    return allNewsObjects;
    }



}
