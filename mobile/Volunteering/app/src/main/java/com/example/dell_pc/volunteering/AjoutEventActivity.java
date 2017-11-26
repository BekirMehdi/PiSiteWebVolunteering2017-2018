package com.example.dell_pc.volunteering;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class AjoutEventActivity extends AppCompatActivity {
    private String mJSONURLString = "http://10.0.2.2:18080/volunteering-web/rest/Event";

    final String storeName = "xyz";
    final String couponType = "sale";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_event);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });




        Map<String,String> params = new HashMap<>();
        params.put("nameEvent",storeName);
        params.put("typeEvent",couponType);

        JsonObjectRequest jsonRequest = new JsonObjectRequest (Request.Method.POST, mJSONURLString,new JSONObject(params),
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {


                        Context context = getApplicationContext();
                        CharSequence text ="inscription reussite , votre compte sera activé dans une certaine délai";

                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {


                        Context context = getApplicationContext();


                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, error.getMessage(), duration);
                        toast.show();
                    }
                })

        {

            @Override
            public Map<String, String> getHeaders()  {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json");
                return headers;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonRequest);


    }

}
