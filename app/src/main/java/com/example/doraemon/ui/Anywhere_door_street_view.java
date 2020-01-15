package com.example.doraemon.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.doraemon.R;
import com.google.android.gms.maps.OnStreetViewPanoramaReadyCallback;
import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.SupportStreetViewPanoramaFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Anywhere_door_street_view extends AppCompatActivity implements OnStreetViewPanoramaReadyCallback {
    private StreetViewPanorama streetViewPanorama;
    private boolean Location = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anywhere_door_street_view);
        SupportStreetViewPanoramaFragment supportStreetViewPanoramaFragment = (SupportStreetViewPanoramaFragment)getSupportFragmentManager()
                .findFragmentById(R.id.street_view);
        supportStreetViewPanoramaFragment.getStreetViewPanoramaAsync(this);
        FloatingActionButton floatingActionButton = findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Location=!Location;
                onStreetViewPanoramaReady(streetViewPanorama);
            }
        });
    }

    @Override
    public void onStreetViewPanoramaReady(StreetViewPanorama streetViewPanorama) {
        if(Location) {
            streetViewPanorama.setPosition(new LatLng(51.52887,-0.1726073));
        }

        streetViewPanorama.setStreetNamesEnabled(true);
        streetViewPanorama.setPanningGesturesEnabled(true);
        streetViewPanorama.setZoomGesturesEnabled(true);
        streetViewPanorama.setUserNavigationEnabled(true);
        streetViewPanorama.animateTo(
                new StreetViewPanoramaCamera.Builder().orientation(new StreetViewPanoramaOrientation(20,20))
                        .zoom(streetViewPanorama.getPanoramaCamera().zoom).build(),2000
        );
            streetViewPanorama.setOnStreetViewPanoramaCameraChangeListener(panaromachangelistener);
    }
    private StreetViewPanorama.OnStreetViewPanoramaCameraChangeListener panaromachangelistener = new StreetViewPanorama.OnStreetViewPanoramaCameraChangeListener() {
        @Override
        public void onStreetViewPanoramaCameraChange(StreetViewPanoramaCamera streetViewPanoramaCamera) {
            Toast.makeText(Anywhere_door_street_view.this,"LocationUpdated",Toast.LENGTH_SHORT).
                    show();
        }
    };

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
    super.onPointerCaptureChanged(true);
    }
}
