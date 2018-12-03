package ir.taghizadeh.dagger2.activities.tvShowsActivity;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;
import ir.taghizadeh.dagger2.R;
import ir.taghizadeh.dagger2.model.TvShows;

public class TvShowsListViewHolder extends RecyclerView.ViewHolder {

    private ImageView imageView;

    public TvShowsListViewHolder(View itemView) {
        super(itemView);
        this.imageView = itemView.findViewById(R.id.imageView);
    }

    public void configureWith(TvShows tvShows, Picasso picasso) {
        picasso.load(tvShows.image.original)
                .placeholder(R.drawable.ic_launcher_background)
                .into(imageView);
    }

}
