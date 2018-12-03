package ir.taghizadeh.dagger2.activities.tvShowsActivity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import ir.taghizadeh.dagger2.R;
import ir.taghizadeh.dagger2.TvShowsApplication;
import ir.taghizadeh.dagger2.di.component.DaggerTvShowsActivityComponent;
import ir.taghizadeh.dagger2.di.component.TvShowsActivityComponent;
import ir.taghizadeh.dagger2.di.module.TvShowsActivityModule;
import ir.taghizadeh.dagger2.model.TvShows;
import ir.taghizadeh.dagger2.network.TvShowsService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TvShowsActivity extends AppCompatActivity {

    @Inject
    TvShowsService tvShowsService;
    @Inject
    TvShowsAdapter tvShowsAdapter;

    Call<List<TvShows>> listCall;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        attachUI();
        injectComponent();
        loadData();
        }

    private void attachUI() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
    }

    private void injectComponent() {
        TvShowsActivityComponent component = DaggerTvShowsActivityComponent.builder()
                .tvShowsApplicationComponent(TvShowsApplication.get(this).getComponent())
                .build();
        component.inject(this);
    }

    private void loadData() {
        listCall = tvShowsService.getTvShowsList();
        listCall.enqueue(new Callback<List<TvShows>>() {
            @Override
            public void onResponse(@NonNull Call<List<TvShows>> call, @NonNull Response<List<TvShows>> response) {
                tvShowsAdapter.addCollection(response.body());
                recyclerView.setAdapter(tvShowsAdapter);
            }

            @Override
            public void onFailure(@NonNull Call<List<TvShows>> call, @NonNull Throwable t) {
                Log.e("Throwable", t.getMessage());
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(listCall != null) {
            listCall.cancel();
        }
    }
}
