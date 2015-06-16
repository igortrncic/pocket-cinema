package com.trncic.igor.pocketcinema.model;

import java.io.Serializable;

/**
 *
 adult: false,
 backdrop_path: "/jxPeRkfOoWs6gFybOa8C4xrHLrm.jpg",
 genre_ids: [
 53,
 28,
 12
 ],
 id: 76341,
 original_language: "en",
 original_title: "Mad Max: Fury Road",
 overview: "An apocalyptic story set in the furthest reaches of our planet, in a stark desert landscape where humanity is broken, and most everyone is crazed fighting for the necessities of life. Within this world exist two rebels on the run who just might be able to restore order. There's Max, a man of action and a man of few words, who seeks peace of mind following the loss of his wife and child in the aftermath of the chaos. And Furiosa, a woman of action and a woman who believes her path to survival may be achieved if she can make it across the desert back to her childhood homeland.",
 release_date: "2015-05-15",
 poster_path: "/kqjL17yufvn9OVLyXYpvtyrFfak.jpg",
 popularity: 31.391691,
 title: "Mad Max: Fury Road",
 video: false,
 vote_average: 8,
 vote_count: 691
 * Created by igortrncic on 6/10/15.
 */
public class Movie implements Serializable{
    public static final String IMAGES_BASE_URL = "http://image.tmdb.org/t/p/";

    public static final String IMAGES_SIZE_185 = "w185/";
    public static final String IMAGES_SIZE_342 = "w342/";
    public static final String IMAGES_SIZE_500 = "w500/";
    public static final String IMAGES_SIZE_780 = "w780/";
    public static final String ORIGINAL = "original/";

    public int id;
    public String title;
    public String poster_path;
    public String backdrop_path;
    public String original_title;
    public String overview;
    public String release_date;
    public String vote_average;


    public String getPosterPath(String... size){
        return size.length != 0 ? IMAGES_BASE_URL + size[0] + poster_path :  IMAGES_BASE_URL + IMAGES_SIZE_342 + poster_path;
    }

    public String getBackdropPath(String... size){
        return size.length != 0 ? IMAGES_BASE_URL + size[0] + backdrop_path :  IMAGES_BASE_URL + IMAGES_SIZE_780 + backdrop_path;
    }
}
