package com.nekodev.paulina.sadowska.simplemoviebrowser.model.movieDB;

/**
 * Created by Paulina Sadowska on 25.03.2017.
 */

public class Movie {

    private String title;
    private String backdrop_path;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBackdropPath() {
        return backdrop_path;
    }

    public void setBackdropPath(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }
}
