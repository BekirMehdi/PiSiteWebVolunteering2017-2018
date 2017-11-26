package com.example.dell_pc.volunteering.models;

/**
 * Created by DELL-PC on 19/11/2017.
 */

public class Event {
    private String nameEvent ;
    private String type ;
    private String duration;
    private String imageRes ;
    private String lng ;
    private String  lalt;

    public Event(String nameEvent, String type, String duration, String imageRes) {
        this.nameEvent = nameEvent;
        this.type = type;
        this.duration = duration;
        this.imageRes = imageRes;
    }



    public Event(String nameEvent, String type) {
        this.nameEvent = nameEvent;
        this.type = type;
    }

    public Event(String nameEvent,String lng, String lalt) {
        this.nameEvent = nameEvent;
        this.lng = lng;
        this.lalt = lalt;
    }

    public String getNameEvent() {
        return nameEvent;
    }

    public void setNameEvent(String nameEvent) {
        this.nameEvent = nameEvent;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getImageRes() {
        return imageRes;
    }

    public void setImageRes(String imageRes) {
        this.imageRes = imageRes;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLalt() {
        return lalt;
    }

    public void setLalt(String lalt) {
        this.lalt = lalt;
    }

    @Override
    public String toString() {
        return "Event{" +
                "nameEvent='" + nameEvent + '\'' +
                ", type='" + type + '\'' +
                ", duration=" + duration +
                ", imageRes=" + imageRes +
                '}';
    }
}
