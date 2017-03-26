package com.nekodev.paulina.sadowska.simplemoviebrowser.model.movieDB;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Paulina Sadowska on 25.03.2017.
 */

public class Movies {

    @SerializedName("results")
    private List<Movie> movies;

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
