package com.example.zikstar.guardnews;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;


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
            headlineTextView.setText(currentNews.getHeadline());
            dateTextView.setText(currentNews.getTime());
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

}
