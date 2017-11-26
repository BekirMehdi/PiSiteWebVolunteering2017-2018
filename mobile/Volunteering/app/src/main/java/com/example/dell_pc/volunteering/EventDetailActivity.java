package com.example.dell_pc.volunteering;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.dell_pc.volunteering.models.Event;
import com.example.dell_pc.volunteering.utils.EventsContent;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class EventDetailActivity extends AppCompatActivity {
    Context context;
    ImageView imgEvent ;
    TextView tvName,tvType,tvDuration;
    public String url = "http://10.0.2.2:18080/volunteering-web/rest/Event";
    ListView lvEvents;
    List<Event> listEvents = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_event_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        final Button button = findViewById(R.id.button_id);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventDetailActivity.this, MapsActivity.class);

                startActivity(intent);
            }
        });

        imgEvent = (ImageView) findViewById(R.id.imgEventBig);
        tvName = (TextView) findViewById(R.id.tv_event_detail_name);
        tvType = (TextView) findViewById(R.id.tv_event_detail_type);
        tvDuration = (TextView) findViewById(R.id.tv_event_detail_duration);




            JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, (String) null,
                    new Response.Listener<JSONArray>(){
                        @Override
                        public void onResponse(JSONArray response) {
                            int count =0;
                            while(count<response.length()) {
                                try {
                                    JSONObject jsonObject = response.getJSONObject(count);
                                    Event article = new
                                            Event(jsonObject.getString("nameEvent"), jsonObject.getString("typeEvent"), jsonObject.getString("dateEvent"), jsonObject.getString("imgPath"));
                                    listEvents.add(article);
                                    count++;


                                }  //end try
                                catch (JSONException e) {
                                    Toast.makeText(context, "error !!",Toast.LENGTH_SHORT).show();

                                    e.printStackTrace();
                                }
                            }
                            Bundle bundle =getIntent().getExtras();

                            if (bundle!=null) {
                                int position = bundle.getInt(MainActivity.KEY_POSITION);

                                tvName.setText(listEvents.get(position).getNameEvent());
                                tvType.setText(listEvents.get(position).getType());
                                tvDuration.setText(listEvents.get(position).getDuration());

                            }
        }
    },
            new Response.ErrorListener(){
        @Override
        public void onErrorResponse(VolleyError error) {

            error.printStackTrace();
        }
    });

        Mysingleton.getmInstance(context).addToREquestQue(jsonArrayRequest);






    }
}
