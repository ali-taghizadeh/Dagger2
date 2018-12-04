package ir.taghizadeh.dagger2.activities.tvShowsActivity;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import ir.taghizadeh.dagger2.R;
import ir.taghizadeh.dagger2.model.TvShows;

public class TvShowsListViewHolder extends RecyclerView.ViewHolder {

    private ImageView image_item_avatar;
    private TextView text_item_name;
    private TextView text_item_genres;
    private TextView text_item_rate;
    private TextView text_item_status;
    private TextView text_item_summary;

    public TvShowsListViewHolder(View itemView) {
        super(itemView);
        this.image_item_avatar = itemView.findViewById(R.id.image_item_avatar);
        this.text_item_name = itemView.findViewById(R.id.text_item_name);
        this.text_item_genres = itemView.findViewById(R.id.text_item_genres);
        this.text_item_rate = itemView.findViewById(R.id.text_item_rate);
        this.text_item_status = itemView.findViewById(R.id.text_item_status);
        this.text_item_summary = itemView.findViewById(R.id.text_item_summary);
    }

    public void configureWith(TvShows tvShows, Picasso picasso) {
        text_item_name.setText(tvShows.name);
        text_item_genres.setText(tvShows.genres.get(0));
        text_item_rate.setText(String.format("Rating : %s", tvShows.rating.average));
        text_item_status.setText(tvShows.status);
        text_item_summary.setText(Html.fromHtml(tvShows.summary));
        picasso.load(tvShows.image.original)
                .placeholder(R.drawable.ic_twotone_movie_24px)
                .into(image_item_avatar);
    }

}
