package ir.taghizadeh.dagger2;

import android.app.Activity;
import android.app.Application;

import ir.taghizadeh.dagger2.di.component.DaggerTvShowsApplicationComponent;
import ir.taghizadeh.dagger2.di.component.TvShowsApplicationComponent;
import ir.taghizadeh.dagger2.di.module.ContextModule;

public class TvShowsApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        TvShowsApplicationComponent component = DaggerTvShowsApplicationComponent.builder()
                .contextModule(new ContextModule(this))
                .build();
    }
}