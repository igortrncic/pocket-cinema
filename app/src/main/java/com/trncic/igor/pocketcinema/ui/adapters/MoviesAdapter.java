package com.trncic.igor.pocketcinema.ui.adapters;

import android.content.Context;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.trncic.igor.pocketcinema.R;
import com.trncic.igor.pocketcinema.model.Movie;

import java.util.List;

/**
 * Created by igortrncic on 6/10/15.
 */
public class MoviesAdapter extends BaseAdapter {
    private Context mContext;
    private List<Movie> mMovies;

    public MoviesAdapter(Context context, List<Movie> movies) {
        mMovies = movies;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mMovies.size();
    }

    @Override
    public Object getItem(int position) {
        return mMovies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        Movie movie = mMovies.get(position);

        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            imageView.setAdjustViewBounds(true);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }else {
            imageView = (ImageView) convertView;
        }

        Picasso.with(mContext).load(movie.getPosterPath()).into(imageView);
        return imageView;
    }

    public void setData(List<Movie> movies){
        mMovies = movies;
        notifyDataSetChanged();
    }
}
