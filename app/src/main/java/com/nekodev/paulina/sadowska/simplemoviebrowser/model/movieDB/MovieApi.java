package com.nekodev.paulina.sadowska.simplemoviebrowser.model.movieDB;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Paulina Sadowska on 25.03.2017.
 */

public interface MovieApi {

    String ENDPOINT = "https://api.themoviedb.org/";

    @GET("3/movie/top_rated")
    Observable<Movies> getMovies(@Query("page") int pageNumber);
}
