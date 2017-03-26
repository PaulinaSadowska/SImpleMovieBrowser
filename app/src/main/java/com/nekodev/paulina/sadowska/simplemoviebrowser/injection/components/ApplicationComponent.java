package com.nekodev.paulina.sadowska.simplemoviebrowser.injection.components;

import android.app.Application;

import com.nekodev.paulina.sadowska.simplemoviebrowser.injection.module.ApplicationModule;
import com.nekodev.paulina.sadowska.simplemoviebrowser.view.activity.MovieListActivity;
import com.nekodev.paulina.sadowska.simplemoviebrowser.viewmodel.MoviesViewModel;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Paulina Sadowska on 25.03.2017.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(MovieListActivity movieListActivity);

    Application application();

    MoviesViewModel moviesViewModel();
}

