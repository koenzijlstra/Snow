package com.example.koen.snow;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;


public class SnowAsynctasks extends AsyncTask {

    private static Context context;
    private String input;
    String city;
    String test;

    public SnowAsynctasks(Context c, String search) {
        input = search;
        context = c;
    }

    @Override
    protected void onPreExecute (){
        super.onPreExecute();
        Toast.makeText(context, "Searching", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected Void doInBackground(Object[] params) {
        try{
            JSONObject fulljson = Httphelper.readJsonFromUrl(input);
            JSONObject data = fulljson.getJSONObject("data");
            JSONArray request = data.getJSONArray("request");
            JSONObject req = request.getJSONObject(0);
            city = req.getString("query");
            test = fulljson.toString();


        } catch (JSONException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);

        Log.d("test", test);

        Intent gotoinfo = new Intent(context, Snowheight_activity.class);
        gotoinfo.putExtra("city", city);
        gotoinfo.putExtra("test", test);
        context.startActivity(gotoinfo);

        // info meegeven
        // naar activity -> context.startActivity(gotoinfo)
    }
}
