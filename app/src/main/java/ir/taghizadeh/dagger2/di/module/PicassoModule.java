package ir.taghizadeh.dagger2.di.module;

import android.content.Context;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;
import ir.taghizadeh.dagger2.di.scope.TvShowsApplicationScope;
import okhttp3.OkHttpClient;

@Module(includes = {ContextModule.class, NetworkModule.class})

public class PicassoModule {

    @Provides
    @TvShowsApplicationScope
    public Picasso picasso(Context context, OkHttp3Downloader okHttp3Downloader) {
        return new Picasso.Builder(context)
                .downloader(okHttp3Downloader)
                .build();
    }

    @Provides
    @TvShowsApplicationScope
    public OkHttp3Downloader okHttp3Downloader(OkHttpClient okHttpClient) {
        return new OkHttp3Downloader(okHttpClient);
    }
}
