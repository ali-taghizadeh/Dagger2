package ir.taghizadeh.dagger2.di.module;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import ir.taghizadeh.dagger2.di.scope.TvShowsApplicationScope;

@Module
public class ContextModule {

    private final Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @Provides
    @TvShowsApplicationScope
    public Context context() {
        return context;
    }
}
