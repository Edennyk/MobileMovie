package com.example.Movie;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DialogActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_custom_layout);

        final Spinner dateSpinner = (Spinner) findViewById(R.id.spinnerDatePicker);
        final Spinner timeSpinner = (Spinner) findViewById(R.id.spinnerTimePicker);

        ArrayAdapter<CharSequence> dateAdapter = ArrayAdapter.createFromResource(this, R.array.dates, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> timeAdapter = ArrayAdapter.createFromResource(this, R.array.times, android.R.layout.simple_spinner_item);

        dateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        timeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        dateSpinner.setAdapter(dateAdapter);
        timeSpinner.setAdapter(timeAdapter);


        ImageView moviePoster = (ImageView) findViewById(R.id.moviePoster);
        TextView titleDialog = (TextView) findViewById(R.id.titleDialog);
        TextView runTime = (TextView) findViewById(R.id.runTime);
        Intent intent = getIntent();

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            int resId = bundle.getInt("poster");
            moviePoster.setImageResource(resId);
        }

        String title = intent.getStringExtra("title");
        titleDialog.setText(title);
        titleDialog.setTextSize(18);

        String runT = intent.getStringExtra("runtime");
        runTime.setText(runT);
        runTime.setTextSize(16);

        Button btn = (Button) findViewById(R.id.bookTicket);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView bookedTitle = (TextView) findViewById(R.id.bookTitle);
                Intent intent = getIntent();
                String title = intent.getStringExtra("title");
                bookedTitle.setText(title);
                bookedTitle.setTextSize(18);

                TextView bookedDate = (TextView) findViewById(R.id.bookDate);
                Spinner dateSpinner = (Spinner) findViewById(R.id.spinnerDatePicker);
                bookedDate.setText(dateSpinner.getSelectedItem().toString());

                TextView bookedTime = (TextView) findViewById(R.id.bookTime);
                Spinner timeSpinner = (Spinner) findViewById(R.id.spinnerTimePicker);
                bookedTime.setText(timeSpinner.getSelectedItem().toString());
            }
        });

        Button btnInfo = (Button) findViewById(R.id.helpInfo);
        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moreInformation = new Intent(DialogActivity.this, MoreInfoActivity.class);
                startActivity(moreInformation);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) { }

}
