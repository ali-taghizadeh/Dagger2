package ir.taghizadeh.dagger2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ShowImage {
    @SerializedName("medium")
    @Expose
    public String medium;
    @SerializedName("original")
    @Expose
    public String original;
}
