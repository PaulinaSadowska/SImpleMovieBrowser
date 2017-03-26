package com.nekodev.paulina.sadowska.simplemoviebrowser.viewmodel;

import android.content.Context;

import com.nekodev.paulina.sadowska.simplemoviebrowser.MovieApplication;
import com.nekodev.paulina.sadowska.simplemoviebrowser.injection.components.DaggerMoviesViewModelComponent;
import com.nekodev.paulina.sadowska.simplemoviebrowser.model.movieDB.MovieApi;
import com.nekodev.paulina.sadowska.simplemoviebrowser.model.movieDB.Movies;

import java.util.List;

import javax.inject.Inject;

import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.subjects.PublishSubject;

/**
 * Created by Paulina Sadowska on 25.03.2017.
 */

public class MoviesViewModel {

    @Inject
    protected MovieApi mMovieApi;
    @Inject
    protected Scheduler mSubscribeScheduler;

    public PublishSubject<List<MovieItemViewModel>> moviesStream = PublishSubject.create();

    public MoviesViewModel(Context context) {
        injectDependencies(context);
    }

    /* This constructor is provided so we can set up a DataManager with mocks from unit test.
     * At the moment this is not possible to do with Dagger because the Gradle APT plugin doesn't
     * work for the unit test variant, plus Dagger 2 doesn't provide a nice way of overriding
     * modules */
    public MoviesViewModel(MovieApi movieApi,
                           Scheduler subscribeScheduler) {
        mMovieApi = movieApi;
        mSubscribeScheduler = subscribeScheduler;
    }

    protected void injectDependencies(Context context) {
        DaggerMoviesViewModelComponent.builder()
                .applicationComponent(MovieApplication.get(context).getComponent())
                .build()
                .inject(this);
    }

    public void loadMovies() {
        mMovieApi.getMovies()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(mSubscribeScheduler)
                .map(Movies::getMovies)
                .flatMapIterable(movies -> movies)
                .map(MovieItemViewModel::new)
                .toList()
                .subscribe(moviesStream::onNext, moviesStream::onError);
    }
}