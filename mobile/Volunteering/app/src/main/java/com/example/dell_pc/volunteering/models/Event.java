package com.example.dell_pc.volunteering.models;

/**
 * Created by DELL-PC on 19/11/2017.
 */

public class Event {
    private String nameEvent ;
    private String type ;
    private String duration;
    private int imageRes ;

    public Event(String nameEvent, String type, String duration, int imageRes) {
        this.nameEvent = nameEvent;
        this.type = type;
        this.duration = duration;
        this.imageRes = imageRes;
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

    public int getImageRes() {
        return imageRes;
    }

    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
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
