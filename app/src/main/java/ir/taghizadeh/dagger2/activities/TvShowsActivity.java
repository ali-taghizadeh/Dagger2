package ir.taghizadeh.dagger2.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import ir.taghizadeh.dagger2.R;
import ir.taghizadeh.dagger2.TvShowsApplication;
import ir.taghizadeh.dagger2.di.component.DaggerTvShowsActivityComponent;
import ir.taghizadeh.dagger2.di.component.TvShowsActivityComponent;
import ir.taghizadeh.dagger2.model.TvShows;
import ir.taghizadeh.dagger2.network.TvShowsService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TvShowsActivity extends AppCompatActivity {

    @Inject
    TvShowsService tvShowsService;

    Call<List<TvShows>> listCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TvShowsActivityComponent component = DaggerTvShowsActivityComponent.builder()
                .tvShowsApplicationComponent(TvShowsApplication.get(this).getComponent())
                .build();
        component.inject(this);


        listCall = tvShowsService.getTvShowsList();
        listCall.enqueue(new Callback<List<TvShows>>() {
            @Override
            public void onResponse(@NonNull Call<List<TvShows>> call, @NonNull Response<List<TvShows>> response) {
            }

            @Override
            public void onFailure(@NonNull Call<List<TvShows>> call, @NonNull Throwable t) {
                Log.e("Throwable", t.getMessage());
            }
        });
    }
}
