package com.trncic.igor.pocketcinema.ui;

import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.graphics.Palette;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;
import com.trncic.igor.pocketcinema.R;
import com.trncic.igor.pocketcinema.model.Movie;
import com.trncic.igor.pocketcinema.picassoutils.PaletteTransformation;

public class DetailsActivity extends AppCompatActivity {
    public static final String MOVIE = "movie";

    private Movie mMovie;

    private TextView mOriginalTitle;
    private ImageView mBackgroundImage;
    private ImageView mPosterImage;
    private TextView mOverview;
    private TextView mReleaseDate;
    private TextView mVoteAverage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        mMovie = (Movie) getIntent().getSerializableExtra(MOVIE);

        ActionBar ab = getSupportActionBar();
        ab.setTitle(R.string.details);
        ab.setSubtitle(mMovie.title);

        mOriginalTitle = (TextView) findViewById(R.id.original_title);
        mBackgroundImage = (ImageView) findViewById(R.id.background_image);
        mPosterImage = (ImageView) findViewById(R.id.poster_image);
        mOverview = (TextView) findViewById(R.id.overview);
        mReleaseDate = (TextView) findViewById(R.id.release_date);
        mVoteAverage = (TextView) findViewById(R.id.vote_average);

        mOriginalTitle.setText(mMovie.title);
        mOverview.setText(mMovie.overview);
        mReleaseDate.setText(mMovie.release_date);
        mVoteAverage.setText(mMovie.vote_average);

        mBackgroundImage.setColorFilter(getResources().getColor(R.color.black_45), PorterDuff.Mode.DARKEN);

        Picasso.with(this)
                .load(mMovie.getBackdropPath(Movie.ORIGINAL))
                .placeholder(getResources().getDrawable(R.drawable.image_foreground))
                .into(mBackgroundImage);

        //This code is copied from blog of Jake Wharton
        //http://jakewharton.com/coercing-picasso-to-play-with-palette/
        Picasso.with(this)
                .load(mMovie.getPosterPath(Movie.IMAGES_SIZE_342))
                .transform(PaletteTransformation.instance())
                .into(mPosterImage, new Callback.EmptyCallback() {
                    @Override public void onSuccess() {
                        Bitmap bitmap = ((BitmapDrawable) mPosterImage.getDrawable()).getBitmap();
                        Palette palette = PaletteTransformation.getPalette(bitmap);
                        mVoteAverage.setTextColor(palette.getLightVibrantColor(R.color.average_vote));
                    }
                });
    }
}
