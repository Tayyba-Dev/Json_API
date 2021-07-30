package com.tayyba_dev.api;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    String jsonurl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jsonurl="{\"info\":{\"name\":\"Tayyba\",\"age\":24,\"job\":[{\"id\":1,\"title\":\"Android developer\"},{\"id\":2,\"title\":\"Android developer\"}]}}";



        try {
            JSONObject  jsonObject = new JSONObject(jsonurl);
            JSONObject json=jsonObject.getJSONObject("info");
            String name=json.getString("name");
            int age=json.getInt("age");
            JSONArray jsonArray=jsonObject.getJSONArray("job");
            for (int i=0;i<jsonArray.length();i++)
            {
                json=jsonArray.getJSONObject(i);

                int id=json.getInt("id");
                String title= json.getString("title");

                Toast.makeText(MainActivity.this,name+age+"id :"+id+"\n Title :"+title,Toast.LENGTH_LONG).show();

                Log.d("jsonpath","id :"+id+"\n title :"+title);
            }



        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}