package com.nekodev.paulina.sadowska.simplemoviebrowser.injection.components;

import com.nekodev.paulina.sadowska.simplemoviebrowser.injection.module.MoviesViewModelModule;
import com.nekodev.paulina.sadowska.simplemoviebrowser.injection.scope.PerMoviesViewModel;
import com.nekodev.paulina.sadowska.simplemoviebrowser.viewmodel.MoviesViewModel;

import dagger.Component;

/**
 * Created by Paulina Sadowska on 25.03.2017.
 */

@PerMoviesViewModel
@Component(dependencies = ApplicationComponent.class, modules = MoviesViewModelModule.class)
public interface MoviesViewModelComponent {
    void inject(MoviesViewModel moviesViewModel);
}
