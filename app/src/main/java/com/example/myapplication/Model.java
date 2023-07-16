package com.example.myapplication;

public class Model {
    public String title;
    public boolean expand = false;

    public Model(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public boolean isExpand() {
        return expand;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setExpand(boolean expand) {
        this.expand = expand;
    }
}
