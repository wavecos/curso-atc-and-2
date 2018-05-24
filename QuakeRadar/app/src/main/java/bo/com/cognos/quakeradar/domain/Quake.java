package bo.com.cognos.quakeradar.domain;

import java.util.Date;

public class Quake {

    private Float magnitude;
    private String place;
    private Date date;
    private String url;
    private Boolean isTsunami;
    private String type;
    private Double latitude;
    private Double longitude;

    public Float getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(Float magnitude) {
        this.magnitude = magnitude;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getTsunami() {
        return isTsunami;
    }

    public void setTsunami(Boolean tsunami) {
        isTsunami = tsunami;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
