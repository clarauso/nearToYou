package ux.hackathon.reply.it.neartoyou.model;

import java.io.Serializable;

/**
 * Created by c.rauso on 20/03/2016.
 */
public class Recommendation implements Serializable {

    private String name;
    private String description;
    private double latitude;
    private double longitude;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if(description.length() > 300) {
            description = description.substring(0, 300);
        }

        this.description = description;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
