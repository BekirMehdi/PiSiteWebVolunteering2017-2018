package com.example.dell_pc.volunteering;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by esprit on 25/11/2017.
 */

public class Mysingleton {
    private static Mysingleton mInstance;
    private RequestQueue requestQueue;
    private  static Context mctx;
private Mysingleton(Context context){
    mctx=context;
    requestQueue=getRequestQueue();

}

    public RequestQueue getRequestQueue(){
        if(requestQueue==null){
            requestQueue= Volley.newRequestQueue(mctx.getApplicationContext());

        }return requestQueue;
    }
    public static synchronized Mysingleton getmInstance(Context context){
       if(mInstance==null){
           mInstance=new Mysingleton(context);
       }
       return mInstance;
    }
    public<T>void addToREquestQue(Request<T> request){
        requestQueue.add(request);
    }
}
