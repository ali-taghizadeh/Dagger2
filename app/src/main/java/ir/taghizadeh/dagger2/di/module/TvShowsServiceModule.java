package ir.taghizadeh.dagger2.di.module;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dagger.Module;
import dagger.Provides;
import ir.taghizadeh.dagger2.di.scope.TvShowsApplicationScope;
import ir.taghizadeh.dagger2.network.TvShowsService;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = NetworkModule.class)
public class TvShowsServiceModule {

    @Provides
    @TvShowsApplicationScope
    public TvShowsService tvShowsService(Retrofit retrofit) {
        return retrofit.create(TvShowsService.class);
    }

    @Provides
    @TvShowsApplicationScope
    public Gson gson() {
        return new GsonBuilder().create();
    }

    @Provides
    @TvShowsApplicationScope
    public Retrofit retrofit(OkHttpClient okHttpClient, Gson gson) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .baseUrl("http://api.tvmaze.com/")
                .build();
    }

}
