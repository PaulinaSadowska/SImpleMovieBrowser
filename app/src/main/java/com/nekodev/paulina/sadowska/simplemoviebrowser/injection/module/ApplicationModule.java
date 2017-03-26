package com.nekodev.paulina.sadowska.simplemoviebrowser.injection.module;

import android.app.Application;

import com.nekodev.paulina.sadowska.simplemoviebrowser.viewmodel.MoviesViewModel;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Paulina Sadowska on 25.03.2017.
 */

@Module
public class ApplicationModule {
    protected final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @Singleton
    MoviesViewModel provideMoviesViewModel() {
        return new MoviesViewModel(mApplication);
    }

}