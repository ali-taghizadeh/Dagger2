package ir.taghizadeh.dagger2.activities.tvShowsActivity;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import ir.taghizadeh.dagger2.R;
import ir.taghizadeh.dagger2.model.TvShows;


public class TvShowsAdapter extends RecyclerView.Adapter<TvShowsListViewHolder> {

    private final List<TvShows> tvShows = new ArrayList<>(0);
    private final Picasso picasso;

    @Inject
    public TvShowsAdapter(Picasso picasso) {
        this.picasso = picasso;
    }

    @NonNull
    @Override
    public TvShowsListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tv_shows, parent, false);
        return new TvShowsListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TvShowsListViewHolder holder, int index) {
        TvShows tvShows = this.tvShows.get(index);
        holder.configureWith(tvShows, picasso);
    }

    public void addCollection(Collection<TvShows> tvShowsCollection) {
        tvShows.clear();
        if(tvShowsCollection != null) {
            tvShows.addAll(tvShowsCollection);
        }
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return tvShows.size();
    }
}
