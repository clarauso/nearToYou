package ux.hackathon.reply.it.neartoyou;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import ux.hackathon.reply.it.neartoyou.model.Recommendation;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Recommendation activeRecommendation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        String activityTitle = "";
        String activityDescription = "";
        activeRecommendation = null;

        try {
            activeRecommendation = (Recommendation) getIntent().getSerializableExtra("SelectedRecommendation");
            activityTitle = activeRecommendation.getName();
            activityDescription = activeRecommendation.getDescription();
        } catch(Exception e) {
            Log.e("Ratings Activity", e.getMessage());
        }

        // title
        TextView title = (TextView)findViewById(R.id.placeName);
        title.setText(activityTitle);

        // description
        TextView description = (TextView)findViewById(R.id.placeDescription);
        description.setText(activityDescription);

        // submit button
        Button submit = (Button)findViewById(R.id.submitButton);
        submit.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Toast.makeText(getApplicationContext(), "Rating submitted!", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        if(activeRecommendation != null) {
            // add the recommendation marker
            LatLng recommandationMarker = new LatLng(activeRecommendation.getLatitude(), activeRecommendation.getLongitude());
            mMap.addMarker(new MarkerOptions().position(recommandationMarker).title(activeRecommendation.getName()));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(recommandationMarker));
        }

        /*
        if (map != null && bc != null) {
            map.animateCamera(CameraUpdateFactory.newLatLngBounds(bc.build(), 100));
        }
        */


    }
}
