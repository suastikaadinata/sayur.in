package com.example.aryasa.drawersayur;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;

public class Chart extends AppCompatActivity {

    private Button btPlacesAPI;
    private TextView tvPlaceAPI;
    private int PLACE_PICKER_REQUEST = 1;

    Button button4;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chart_layout);


        button4 = (Button) findViewById(R.id.button4);
        tvPlaceAPI = (TextView) findViewById(R.id.textView_alamat);

        btPlacesAPI = (Button) findViewById(R.id.buttonpick);
        btPlacesAPI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
                try {
                    startActivityForResult(builder.build(Chart.this), PLACE_PICKER_REQUEST);
                } catch (GooglePlayServicesRepairableException e) {
                    e.printStackTrace();
                } catch (GooglePlayServicesNotAvailableException e) {
                    e.printStackTrace();
                }
            }
        });


        button4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                intent = new Intent(Chart.this, Process.class);
                finish();
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PLACE_PICKER_REQUEST) {
            if (resultCode == RESULT_OK) {
                Place place = PlacePicker.getPlace(data, this);
                String toastMsg = String.format(
                        "%s "
                        , place.getAddress());
                tvPlaceAPI.setText(toastMsg);
            }
        }
    }
}
