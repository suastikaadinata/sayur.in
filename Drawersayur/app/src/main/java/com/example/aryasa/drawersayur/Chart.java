package com.example.aryasa.drawersayur;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Chart extends AppCompatActivity {

    private Button btPlacesAPI;
    private TextView tvPlaceAPI;
    private int PLACE_PICKER_REQUEST = 1;
    Button button4;
    Intent intent;
    Button btndatepicker;
    Calendar cal,cal1;
    long maxDate;
    Date date;
    private int temp = 0;
    TextView txtdatepicker;
    private SimpleDateFormat dateFormatter;
    Spinner Spinnerjam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chart_layout);

        String[] number = new String[]{
                "06.00 WIB",
                "07.00 WIB",
                "08.00 WIB",
                "09.00 WIB",
                "10.00 WIB"
        };

        cal = Calendar.getInstance();
        cal1 = Calendar.getInstance();

        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);

        btndatepicker = (Button) findViewById(R.id.buttondatepicker);
        button4 = (Button) findViewById(R.id.button4);
        tvPlaceAPI = (TextView) findViewById(R.id.textView_alamat);
        txtdatepicker = (TextView) findViewById(R.id.textView_hari);
        btPlacesAPI = (Button) findViewById(R.id.buttonpick);

        Spinnerjam = (Spinner) findViewById(R.id.spinner_jam);
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
                this,R.layout.spinner_item,number );

        spinnerArrayAdapter.setDropDownViewResource(R.layout.spinner_item);

        Spinnerjam.setAdapter(spinnerArrayAdapter);


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

        btndatepicker.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                DatePickerDialog dialog = new DatePickerDialog(Chart.this, new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
                        // TODO Auto-generated method stub
                        Calendar newDate = Calendar.getInstance();
                        newDate.set( arg1,arg2,arg3 );
                        txtdatepicker.setText(dateFormatter.format(newDate.getTime()));
                    }
                }, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));
                dialog.getDatePicker().setMinDate(System.currentTimeMillis()+24*60*60*1000);
                if(temp == 0) {
                    cal1.add(Calendar.DAY_OF_MONTH, 3);
                    temp = 1 ;
                }
                dialog.getDatePicker().setMaxDate(cal1.getTimeInMillis());
                dialog.show();
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
