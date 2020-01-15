package com.example.doraemon.ui;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.doraemon.Collection.PlayerConf;
import com.example.doraemon.R;
import com.google.android.gms.common.api.ApiException;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.PhotoMetadata;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.FetchPhotoRequest;
import com.google.android.libraries.places.api.net.FetchPlaceRequest;
import com.google.android.libraries.places.api.net.PlacesClient;

import java.util.Arrays;
import java.util.List;

public class Anywhere_Door extends AppCompatActivity {
    TextView textView;
    ImageView imageView;
    private EditText PlaceID;
    Button button;
    String place_id;
    PlacesClient placesClient;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_anywhere_door);
        PlaceID = findViewById(R.id.place_id);
        textView = findViewById(R.id.text_home_1);
        imageView = findViewById(R.id.image_view_1);
        Places.initialize(this, PlayerConf.API_KEY);
        placesClient = Places.createClient(this);

        button = findViewById(R.id.button_2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchdata();
            }
        });

    }

    private void fetchdata() {
        List<Place.Field> placeFields = Arrays.asList(Place.Field.ID, Place.Field.NAME, Place.Field.PHOTO_METADATAS, Place.Field.ADDRESS,Place.Field.LAT_LNG,Place.Field.PHONE_NUMBER,Place.Field.PLUS_CODE);

        FetchPlaceRequest request = FetchPlaceRequest.newInstance(PlaceID.getText().toString().trim(), placeFields);

        placesClient.fetchPlace(request).addOnSuccessListener((response) -> {
            Place place = response.getPlace();
            String content = "";
            content += place.getAddress() + "\n";
            content += "Latitude: " + place.getLatLng().latitude + "," + "Longitude: " + place.getLatLng().longitude + "\n";
            textView.setText(content);

            PhotoMetadata photoMetadata = place.getPhotoMetadatas().get(0);

            // Get the attribution text.
            String attributions = photoMetadata.getAttributions();

            // Create a FetchPhotoRequest.
            FetchPhotoRequest photoRequest = FetchPhotoRequest.builder(photoMetadata) // Optional.
                    .setMaxHeight(300)
                    .setMaxWidth(300)
                    .build();

            placesClient.fetchPhoto(photoRequest).addOnSuccessListener((fetchPhotoResponse) -> {
                Bitmap bitmap = fetchPhotoResponse.getBitmap();
                imageView.setImageBitmap(bitmap);

            }).addOnFailureListener((exception) -> {
                if (exception instanceof ApiException) {
                    ApiException apiException = (ApiException) exception;
                    int statusCode = apiException.getStatusCode();
                    // Handle error with given status code.
                    Toast.makeText(this, "Place not found: " + exception.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        });

    }
}