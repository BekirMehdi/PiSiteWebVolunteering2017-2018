package com.example.dell_pc.volunteering;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.dell_pc.volunteering.adaptors.EventAdapter;
import com.example.dell_pc.volunteering.models.Event;

import android.widget.RatingBar;
import android.widget.Toast;


import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;



public class MainActivity extends AppCompatActivity {
    public String url = "http://10.0.2.2:18080/volunteering-web/rest/Event";
    ListView lvEvents;
    List<Event> listEvents = new ArrayList<>();
    public static final String KEY_POSITION = "KeyPosition";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       // RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar);


    /*private OnRatingBarChangeListener onRatingChangedListener(final ViewHolder holder, final int position)
    {
        return new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean b)
            {

                EventAdapter item = getIte(position);
                int roundoff_rating = (int)Math.round(rating);
                ratingBar.setRating(roundoff_rating);
                item.setrating(String.valueOf(roundoff_rating));

            }
        };*/

        final Button button = findViewById(R.id.btAjoutEvent);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AjoutEventActivity.class);
                startActivity(intent);
            }
        });
new GetBanks().execute();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MapsActivity.class);

                startActivity(intent);
            }
        });


        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, (String) null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        int count = 0;
                        while (count < response.length()) {
                            try {
                                JSONObject jsonObject = response.getJSONObject(count);
                                Event article = new
                                        Event(jsonObject.getString("nameEvent"), jsonObject.getString("typeEvent"), jsonObject.getString("dateEvent"), jsonObject.getString("imgPath"));
                                listEvents.add(article);
                                count++;


                            }  //end try
                            catch (JSONException e) {
                                Toast.makeText(MainActivity.this, "error !!", Toast.LENGTH_SHORT).show();

                                e.printStackTrace();
                            }
                        }
                        lvEvents = (ListView) findViewById(R.id.lv_event);
                        EventAdapter adapter = new EventAdapter(MainActivity.this, R.layout.item_event, listEvents);
                        lvEvents.setAdapter(adapter);

                        lvEvents.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                Intent intent = new Intent(MainActivity.this, EventDetailActivity.class);
                                intent.putExtra(KEY_POSITION, position);
                                startActivity(intent);
                            }
                        });

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        error.printStackTrace();
                    }
                });

        Mysingleton.getmInstance(MainActivity.this).addToREquestQue(jsonArrayRequest);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private class GetBanks extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //Any code that must be executed before making the hhtp request service call must be declared here
        }


        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            //This code is executed just after the doInBackground finishes executing


        }
    }
}