package com.example.zikstar.guardnews;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import androidx.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import androidx.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class GuardNewsAdapter extends ArrayAdapter<News> {

    public GuardNewsAdapter(Context context){

        super(context, 0,0);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;

        //check if convertView is null, if it is the inflate the view in the list_item xml file,
        //with it's root as parent, and atthToRoot is false
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }


        //get the current item in the array list you want to display in this list_item block
        News currentNews = getItem(position);


        TextView sectionTextView = listItemView.findViewById(R.id.sectionTextView);
        TextView headlineTextView = listItemView.findViewById(R.id.headlineTextView);
        TextView dateTextView = listItemView.findViewById(R.id.dateTextView);
        ImageView imageView = listItemView.findViewById(R.id.imageView);

        if (currentNews != null) {

            String apiTime = currentNews.getTime();
            String date = "no date";
            String time = "";
            if(apiTime.contains("T")){
                String[] parts = apiTime.split("T");
                 date = parts[0];
                 time = parts[1];

            }
            String dateFormatted = formatDate(date);
            //This time is gmt time you still need to work on it , to
            //give the time in the app's timezone
            String timeFormatted = formatTime(time);


            headlineTextView.setText(currentNews.getHeadline());
            dateTextView.setText(dateFormatted+". "+ timeFormatted);
            sectionTextView.setText(currentNews.getSectionName());

            //circle transform is not really necessary
            Picasso.with(this.getContext())
                    .load(currentNews.getImageUrl())
                    .centerCrop()
                    .transform(new CircleTransform(50,0))
                    .fit()
                    .into(imageView);
            //new DownloadImageTask(imageView).execute(currentNews.getImageUrl());
        }


    return listItemView;

    }

    //The Guardian API provides the image only as a String URL, so
    //we use an asynctask as an inner class in this adapter

    private static class DownloadImageTask extends AsyncTask<String,Void, Bitmap>  {

        private ImageView bmImageView;


        private DownloadImageTask(ImageView imageView){
            bmImageView = imageView;
        }

        @Override
        protected Bitmap doInBackground(String... urls) {

            String ImageUrl= urls[0];
            URL image = null;
            Bitmap bmp = null;

            try {
                if(ImageUrl != null){
                    image = new URL(ImageUrl);
                }
                else{return null;}

            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            try {
                if (image != null) {
                    InputStream inputStream = image.openStream();
                    bmp = BitmapFactory.decodeStream(inputStream);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


            return bmp;
        }


        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            bmImageView.setImageBitmap(bitmap);
        }
    }


    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(String date) {





        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-mm-dd");
        Date finalForm = null;
        try {
             finalForm = format1.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(finalForm);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(String date) {
//
//        SimpleDateFormat input = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
//        input.setTimeZone(TimeZone.getTimeZone("UTC"));
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");


        SimpleDateFormat format1 = new SimpleDateFormat("HH:mm:ss");
        Date finalForm = null;
        try {
            finalForm = format1.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }



        return timeFormat.format(finalForm);

    }

}
