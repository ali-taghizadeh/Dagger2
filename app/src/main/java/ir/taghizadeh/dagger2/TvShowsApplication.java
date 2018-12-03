package ir.taghizadeh.dagger2;

import android.app.Activity;
import android.app.Application;

import ir.taghizadeh.dagger2.di.component.DaggerTvShowsApplicationComponent;
import ir.taghizadeh.dagger2.di.component.TvShowsApplicationComponent;
import ir.taghizadeh.dagger2.di.module.ContextModule;

public class TvShowsApplication extends Application {

    private TvShowsApplicationComponent component;

    public static TvShowsApplication get(Activity activity) {
        return (TvShowsApplication) activity.getApplication();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerTvShowsApplicationComponent.builder()
                .contextModule(new ContextModule(this))
                .build();
    }

    public TvShowsApplicationComponent getComponent() {
        return component;
    }

}