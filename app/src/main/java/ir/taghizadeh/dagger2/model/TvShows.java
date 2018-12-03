package ir.taghizadeh.dagger2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TvShows {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("genres")
    @Expose
    private List<String> genres = null;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("rating")
    @Expose
    private ShowRating rating;
    @SerializedName("image")
    @Expose
    private ShowImage image;
    @SerializedName("summary")
    @Expose
    private String summary;
}
