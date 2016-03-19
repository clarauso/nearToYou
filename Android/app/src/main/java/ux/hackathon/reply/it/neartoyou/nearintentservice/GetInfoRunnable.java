package ux.hackathon.reply.it.neartoyou.nearintentservice;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.util.Log;

import ux.hackathon.reply.it.neartoyou.R;
import ux.hackathon.reply.it.neartoyou.RecommendationsActivity;

import static android.location.LocationManager.GPS_PROVIDER;
import static com.facebook.FacebookSdk.getApplicationContext;

/**
 * Created by c.rauso on 19/03/2016.
 */
public class GetInfoRunnable implements Runnable {

    Intent notificationIntent = new Intent(getApplicationContext(), RecommendationsActivity.class);

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
        // sets the Intent to open a RecommendationsActivity
        Log.d("NEAR TO YOU RUNNABLE", "Creazione di una nuova notifica");
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(getApplicationContext());
        stackBuilder.addParentStack(RecommendationsActivity.class);
        stackBuilder.addNextIntent(notificationIntent);
        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        // builds the notification
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(getApplicationContext())
                .setSmallIcon(R.drawable.globe)
                .setContentTitle("NearToYou")
                .setContentText("I've found new interesting places for you!")
                .setContentIntent(resultPendingIntent);

        // add the new notification to the NotificationManager
        int mNotificationId = 001;
        NotificationManager mNotifyMgr = (NotificationManager)getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);

        // show the notification
        mNotifyMgr.notify(mNotificationId, mBuilder.build());
    }
}
