package bo.com.cognos.quakeradar.domain;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Result {

    @SerializedName("features")
    private List<Quake> quakes;

    public List<Quake> getQuakes() {
        return quakes;
    }

    public void setQuakes(List<Quake> quakes) {
        this.quakes = quakes;
    }
}
