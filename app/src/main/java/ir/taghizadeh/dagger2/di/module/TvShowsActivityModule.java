package ir.taghizadeh.dagger2.di.module;

import dagger.Module;
import dagger.Provides;
import ir.taghizadeh.dagger2.activities.TvShowsActivity;
import ir.taghizadeh.dagger2.di.scope.TvShowsActivityScope;

@Module
public class TvShowsActivityModule {

    private final TvShowsActivity tvShowsActivity;

    public TvShowsActivityModule(TvShowsActivity tvShowsActivity) {
        this.tvShowsActivity = tvShowsActivity;
    }

    @Provides
    @TvShowsActivityScope
    public TvShowsActivity tvShowsActivity() {
        return tvShowsActivity;
    }
}
