package com.example.koen.snow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText userinput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userinput = (EditText) findViewById(R.id.userinput);
    }

    public void seeSpots (View view){
        Intent Spots = new Intent(this, Spots_activity.class);
        startActivity(Spots);
    }

    public void search(View view){
        String input = userinput.getText().toString();

        if (input.isEmpty()){
            Toast.makeText(this, "Please enter a city", Toast.LENGTH_LONG).show();
        }
        else{
            input = input.replace(" ", "+");
            new SnowAsynctasks(MainActivity.this, input).execute();
            // tod0: new resultasynctasks(mainactivity.this, input).execute();
        }
    }



}
