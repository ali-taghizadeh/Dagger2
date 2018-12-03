package ir.taghizadeh.dagger2.network;

import java.util.List;

import ir.taghizadeh.dagger2.model.TvShows;
import retrofit2.Call;
import retrofit2.http.GET;

public interface TvShowsService {

    @GET("shows")
    Call<List<TvShows>> getTvShowsList();
}
