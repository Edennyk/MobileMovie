package com.example.Movie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MoreInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_info);


        TextView webSite = (TextView) findViewById(R.id.tvWeb);
        webSite.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://store.cineplex.com/?utm_medium=ads&utm_source=SEM&utm_campaign=brand&utm_term=cpx-store&gclid=Cj0KCQjwm9D0BRCMARIsAIfvfIZAGotL_D-3NhT72VM-Fohvs8g_AJIdVYaWOlB73Gu60JGds5IYv1YaApn6EALw_wcB&gclsrc=aw.ds"));
                startActivity(intent);}});

        TextView mapLocation = (TextView) findViewById(R.id.tvLocation);
        mapLocation.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MoreInfoActivity.this, LocationActivity.class);
                startActivity(intent);
            }
        });


        Button email = (Button) findViewById(R.id.btnsendEmail);
        email.setOnClickListener(new TextView.OnClickListener() {
            public void onClick(View view) {
                Intent email = new Intent(Intent.ACTION_SEND);
                email.setType("plain/text");
                String[] address = {"email@address.com"};
                email.putExtra(Intent.EXTRA_EMAIL, address);
                email.putExtra(Intent.EXTRA_SUBJECT, "test@test");
                email.putExtra(Intent.EXTRA_TEXT, "How can I help you? ");
                startActivity(email);}});
        }
    }