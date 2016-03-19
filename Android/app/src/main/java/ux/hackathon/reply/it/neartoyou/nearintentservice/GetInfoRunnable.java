package ux.hackathon.reply.it.neartoyou.nearintentservice;

import android.app.NotificationManager;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import ux.hackathon.reply.it.neartoyou.R;

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
            nearNotification();
        } catch (SecurityException e) {
            Log.e("NEAR TO YOU RUNNABLE", e.getMessage());
        }
    }

    private void nearNotification() {
        Log.d("NEAR TO YOU RUNNABLE", "Creazione di una nuova notifica");
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(getApplicationContext())
                .setSmallIcon(R.drawable.globe)
                .setContentTitle("NearToYou")
                .setContentText("I've found new interesting places for you!");

        int mNotificationId = 001;

        NotificationManager mNotifyMgr = (NotificationManager)getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);

        mNotifyMgr.notify(mNotificationId, mBuilder.build());
    }
}
