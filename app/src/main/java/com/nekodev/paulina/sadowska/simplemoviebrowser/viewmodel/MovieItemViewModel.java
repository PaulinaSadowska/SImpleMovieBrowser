package com.nekodev.paulina.sadowska.simplemoviebrowser.viewmodel;

import com.nekodev.paulina.sadowska.simplemoviebrowser.model.Movie;

/**
 * Created by Paulina Sadowska on 25.03.2017.
 */

public class MovieItemViewModel {

    public static final String IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500/";


    private String title;
    private String imagePath;

    public MovieItemViewModel(Movie movie) {
        this.title = movie.getTitle();
        this.imagePath = IMAGE_BASE_URL + movie.getBackdropPath();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
