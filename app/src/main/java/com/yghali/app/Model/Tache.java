package com.yghali.app.Model;

import java.util.ArrayList;
import java.util.List;

public class Tache {
    private String name;
    private int id;
    private String time;
    public static ArrayList<Tache> listtache = new ArrayList<>();

    public Tache(int id,String name, String description,  String time) {
        this.name = name;
        this.id = id;
        this.time = time;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;

    public Tache(int id,String name,  String time) {
        this.name = name;
        this.id = id;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }



    public Tache(String name, String time) {
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
