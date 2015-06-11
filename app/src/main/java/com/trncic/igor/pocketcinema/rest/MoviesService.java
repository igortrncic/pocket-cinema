package com.trncic.igor.pocketcinema.rest;

import com.trncic.igor.pocketcinema.model.BaseModel;
import com.trncic.igor.pocketcinema.model.Movie;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by igortrncic on 6/10/15.
 */
public interface MoviesService {

    // http://api.themoviedb.org/3/discover/movie?sort_by=popularity.desc&api_key=[YOUR API KEY]

    @GET("/discover/movie")
    void discoverMovies(@Query("sort_by") String sort_by, Callback<BaseModel> callback);

    @GET("/discover/{user}/repos")
    Movie getMovieDetails(@Path("user") String user);
}
