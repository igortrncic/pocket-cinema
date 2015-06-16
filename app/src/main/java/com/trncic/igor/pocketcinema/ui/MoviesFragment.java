package com.trncic.igor.pocketcinema.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ListAdapter;

import com.trncic.igor.pocketcinema.R;
import com.trncic.igor.pocketcinema.model.BaseModel;
import com.trncic.igor.pocketcinema.model.Movie;
import com.trncic.igor.pocketcinema.rest.RestClient;
import com.trncic.igor.pocketcinema.ui.adapters.MoviesAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * A placeholder fragment containing a simple view.
 */
public class MoviesFragment extends Fragment implements AdapterView.OnItemClickListener{

    private GridView mGridView;
    private MoviesAdapter mAdapter;

    public MoviesFragment() {
        super();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_movies, container, false);

        // Set the adapter
        mGridView = (GridView) view.findViewById(R.id.gridview);

        mAdapter = new MoviesAdapter(getActivity(), new ArrayList<Movie>());
        mGridView.setAdapter(mAdapter);

        mGridView.setOnItemClickListener(this);
        discoverMovies();

        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Movie movie = (Movie) mAdapter.getItem(position);

        Intent intent = new Intent(getActivity(), DetailsActivity.class);
        intent.putExtra(DetailsActivity.MOVIE, movie);
        startActivity(intent);
    }

    private void discoverMovies(){

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String sortOptionsPref = sharedPref.getString(SettingsActivity.KEY_PREF_SORT_OPTIONS, "");

        RestClient.get().discoverMovies(sortOptionsPref, new Callback<BaseModel>() {
            @Override
            public void success(BaseModel baseModel, Response response) {
                mAdapter.setData(baseModel.results);
            }

            @Override
            public void failure(RetrofitError error) {
                String asas = "asdasd";
            }
        });
    }
}
