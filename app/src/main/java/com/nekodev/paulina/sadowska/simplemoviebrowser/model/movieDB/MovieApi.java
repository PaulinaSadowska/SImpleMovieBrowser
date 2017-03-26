package com.nekodev.paulina.sadowska.simplemoviebrowser.model.movieDB;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Paulina Sadowska on 25.03.2017.
 */

public interface MovieApi {

    String ENDPOINT = "https://api.themoviedb.org/";

    @GET("3/movie/top_rated?language=pl-PL&page=1")
    Observable<Movies> getMovies();
}
