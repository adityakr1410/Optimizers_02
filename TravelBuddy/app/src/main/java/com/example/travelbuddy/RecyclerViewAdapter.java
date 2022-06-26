package com.example.travelbuddy;

public class RecyclerViewAdapter {
    Integer photo;
    String chardham;

    public RecyclerViewAdapter(Integer photo, String chardham){
        this.chardham=chardham;
        this.photo=photo;
    }

    public Integer getPhoto(){
        return photo;
    }

    public String getChardham() {
        return chardham;
    }
}
