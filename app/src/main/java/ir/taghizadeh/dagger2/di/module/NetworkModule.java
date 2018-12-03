package ir.taghizadeh.dagger2.di.module;

import android.content.Context;

import java.io.File;

import dagger.Module;
import dagger.Provides;
import ir.taghizadeh.dagger2.di.scope.TvShowsApplicationScope;
import okhttp3.Cache;
import okhttp3.OkHttpClient;

@Module(includes = ContextModule.class)
public class NetworkModule {

    @Provides
    @TvShowsApplicationScope
    public File cacheFile(Context context) {
        return new File(context.getCacheDir(), "cache");
    }

    @Provides
    @TvShowsApplicationScope
    public Cache cache(File cacheFile) {
        return new Cache(cacheFile, 5 * 1000 * 1000);
    }

    @Provides
    @TvShowsApplicationScope
    public OkHttpClient okHttpClient(Cache cache) {
        return new OkHttpClient.Builder()
                .cache(cache)
                .build();
    }
}
