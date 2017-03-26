package com.nekodev.paulina.sadowska.simplemoviebrowser;

import android.app.Application;
import android.content.Context;

import com.nekodev.paulina.sadowska.simplemoviebrowser.injection.components.ApplicationComponent;
import com.nekodev.paulina.sadowska.simplemoviebrowser.injection.components.DaggerApplicationComponent;
import com.nekodev.paulina.sadowska.simplemoviebrowser.injection.module.ApplicationModule;

/**
 * Created by Paulina Sadowska on 25.03.2017.
 */

public class MovieApplication extends Application {

    ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public static MovieApplication get(Context context) {
        return (MovieApplication) context.getApplicationContext();
    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }

    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }
}
