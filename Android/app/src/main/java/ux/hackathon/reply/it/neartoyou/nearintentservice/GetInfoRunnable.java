package ux.hackathon.reply.it.neartoyou.nearintentservice;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;

import static android.location.LocationManager.GPS_PROVIDER;
import static com.facebook.FacebookSdk.getApplicationContext;

/**
 * Created by c.rauso on 19/03/2016.
 */
public class GetInfoRunnable implements Runnable {
    @Override
    public void run() {
        Log.d("NEAR TO YOU RUNNABLE", "This is a Runnable");
        String locationProvider = GPS_PROVIDER;
        LocationManager locationManager = (LocationManager) getApplicationContext().getSystemService(Context.LOCATION_SERVICE);
        try {
            Location lastKnownLocation = locationManager.getLastKnownLocation(locationProvider);
            Log.d("NEAR TO YOU RUNNABLE", (Double.toString(lastKnownLocation.getLatitude()) + " " + Double.toString(lastKnownLocation.getLongitude())));
        } catch (SecurityException e) {
            Log.e("NEAR TO YOU RUNNABLE", e.getMessage());
        }
    }
}
