package com.manericotf.flickster.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.manericotf.flickster.R;
import com.manericotf.flickster.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Manericot F on 7/17/2016.
 */
public class MovieArrayAdapter extends ArrayAdapter<Movie> {

        public MovieArrayAdapter(Context context, List<Movie> movies){
            super(context, android.R.layout.simple_list_item_1, movies);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            //get the data item for position
            Movie movie = getItem(position);

            //checkthe existing view being reused
            if (convertView == null){
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(R.layout.item_movie, parent, false);
            }

            //find the image view
            ImageView ivImage = (ImageView) convertView.findViewById(R.id.ivMovieImage);
            //clear out image from convertView
            ivImage.setImageResource(0);

            TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
            TextView tvOverview = (TextView) convertView.findViewById(R.id.tvOverview);

            //popular data
            tvTitle.setText(movie.getOriginalTitle());
            tvOverview.setText(movie.getOverview());

            Picasso.with(getContext()).load(movie.getPosterPath()).placeholder(R.drawable.tpap);
            /*
            int orientation = getContext().getResources().getConfiguration().orientation;
            if (orientation == Configuration.ORIENTATION_PORTRAIT) {



            } else if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
                Picasso.with(getContext()).load(movie.getPosterPath()).into(ivImage);
            }

                */
            //return the view
            return convertView;
        }
}

