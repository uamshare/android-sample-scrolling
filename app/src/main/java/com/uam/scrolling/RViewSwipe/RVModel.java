package com.uam.scrolling.RViewSwipe;


/**
 * Created by Iforce on 7/14/2017.
 */

public class RVModel {
    private String name;
    private String time,content;
    private float progress;

    public RVModel() {
        this.progress = 0;
    }

    public RVModel(String name, String time, String content, float progress) {
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
    public String getContent(){return content;}
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
