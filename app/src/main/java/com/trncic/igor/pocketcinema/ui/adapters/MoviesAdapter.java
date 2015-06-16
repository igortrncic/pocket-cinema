package com.trncic.igor.pocketcinema.ui.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

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
    private static int mImageWidth;
    private static int mImageHeight;


    public MoviesAdapter(Context context, List<Movie> movies) {
        mMovies = movies;
        mContext = context;
        mImageWidth = (int)mContext.getResources().getDimension(R.dimen.grid_image_width);
        mImageHeight = (int) mContext.getResources().getDimension(R.dimen.grid_image_height);
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
        }else {
            imageView = (ImageView) convertView;
        }

        Picasso.with(mContext)
                .load(movie.getPosterPath())
                .resize(mImageWidth, mImageHeight)
                .centerCrop()
                .into(imageView);
        return imageView;
    }

    public void setData(List<Movie> movies){
        mMovies = movies;
        notifyDataSetChanged();
    }
}
