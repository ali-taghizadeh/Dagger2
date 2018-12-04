package ir.taghizadeh.dagger2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ShowRating {
    @SerializedName("average")
    @Expose
    public Double average;
}
