package com.trncic.igor.pocketcinema.ui;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.trncic.igor.pocketcinema.R;
import com.trncic.igor.pocketcinema.model.Movie;

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

        Picasso.with(this)
                .load(mMovie.getPosterPath(Movie.IMAGES_SIZE_342))
                .into(mPosterImage);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
