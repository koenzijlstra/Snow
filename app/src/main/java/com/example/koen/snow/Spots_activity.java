 package com.example.koen.snow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

 public class Spots_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spots);

        Bundle extras = getIntent().getExtras();
        // String city = extras.getString("city");
        // Toast.makeText(this, city, Toast.LENGTH_LONG).show();

        String[] spots = {"Zell am See", "Gerlos", "Moscow"};
        ArrayAdapter<String> theadapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, spots);
        ListView spotslistview = (ListView) findViewById(R.id.spots);
        spotslistview.setAdapter(theadapter);

        spotslistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          @Override
             public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String clickedspot = String.valueOf(adapterView.getItemAtPosition(position));
                clickedspot = clickedspot.replace(" ", "+");
                new SnowAsynctasks(Spots_activity.this, clickedspot).execute();
                finish();
             }
         });
    }
}


