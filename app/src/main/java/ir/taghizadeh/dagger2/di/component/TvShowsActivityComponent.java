package ir.taghizadeh.dagger2.di.component;

import dagger.Component;
import ir.taghizadeh.dagger2.activities.TvShowsActivity;
import ir.taghizadeh.dagger2.di.module.TvShowsActivityModule;
import ir.taghizadeh.dagger2.di.scope.TvShowsActivityScope;

@TvShowsActivityScope
@Component(modules = TvShowsActivityModule.class, dependencies = TvShowsApplicationComponent.class)
public interface TvShowsActivityComponent {
    void inject(TvShowsActivity tvShowsActivity);
}
