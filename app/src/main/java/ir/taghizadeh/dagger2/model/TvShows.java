package ir.taghizadeh.dagger2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TvShows {
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("genres")
    @Expose
    public List<String> genres = null;
    @SerializedName("status")
    @Expose
    public String status;
    @SerializedName("rating")
    @Expose
    public ShowRating rating;
    @SerializedName("image")
    @Expose
    public ShowImage image;
    @SerializedName("summary")
    @Expose
    public String summary;


}
