package com.uam.scrolling;

import java.util.ArrayList;

/**
 * Created by Iforce on 7/12/2017.
 */

public class CustomPojo {
    //POJO class consists of get method and set method
    private String name;
    private String time,content;
    private float progress;
    private ArrayList<CustomPojo> customPojo =new ArrayList<>();

    public CustomPojo() {
        this.progress = 0;
    }

    public CustomPojo(String name, String time, String content, float progress) {
        this.name = name;
        this.time = time;
        this.content = content;
        this.progress = progress;
    }

    public float getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    //getting content value
    public String getContent(){return content;}
    //setting content value
    public void setContent(String content){this.content=content;}

    public String getTime(){return time;}
    public void setTime(String time){this.time=time;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
