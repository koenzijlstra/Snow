package com.example.koen.snow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Snowheight_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snowheight);

        Bundle extras = getIntent().getExtras();
        String city = extras.getString("city");
        String test = extras.getString("test");
        TextView title = (TextView) findViewById(R.id.query);
        title.setText(city);
    }

    public void seeSpots (View view){
        Intent Spots = new Intent(this, Spots_activity.class);
        startActivity(Spots);
    }

}
