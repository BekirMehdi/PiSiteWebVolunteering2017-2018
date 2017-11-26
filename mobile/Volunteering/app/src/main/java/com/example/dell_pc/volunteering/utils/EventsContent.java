package com.example.dell_pc.volunteering.utils;

import com.example.dell_pc.volunteering.R;
import com.example.dell_pc.volunteering.models.Event;

import java.util.* ;

/**
 * Created by DELL-PC on 19/11/2017.
 */

public class EventsContent {

    public static String[] names ={"mehdi","bekir"};
    public static String[] types = {"dd","dd"};
    public static Integer[] pictures ={R.drawable.image1,R.drawable.image2};
    public static String[] durations ={"50 years","55 years"};

  public static ArrayList<Event> getEvents(){
      ArrayList<Event> events = new ArrayList<>();
      for (int i=0 ;i<2;i++){
        //  events.add(new Event(names[i],types[i],durations[i],pictures[i]));
         // events.add(new Event(names[i],types[i],durations[i],pictures[i]));

      }
      return events;
  }
}
