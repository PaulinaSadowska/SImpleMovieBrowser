package com.nekodev.paulina.sadowska.simplemoviebrowser.injection.module;

import com.nekodev.paulina.sadowska.simplemoviebrowser.injection.scope.PerMoviesViewModel;
import com.nekodev.paulina.sadowska.simplemoviebrowser.model.movieDB.MovieApi;
import com.nekodev.paulina.sadowska.simplemoviebrowser.model.movieDB.RetrofitHelper;

import dagger.Module;
import dagger.Provides;
import rx.Scheduler;
import rx.schedulers.Schedulers;

/**
 * Created by Paulina Sadowska on 25.03.2017.
 */
@Module
public class MoviesViewModelModule {

    public MoviesViewModelModule() {

    }

    @Provides
    @PerMoviesViewModel
    MovieApi provideMovieApi() {
        return new RetrofitHelper().movieApi();
    }

    @Provides
    @PerMoviesViewModel
    Scheduler provideSubscribeScheduler() {
        return Schedulers.io();
    }
}
