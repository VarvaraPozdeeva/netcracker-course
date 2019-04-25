package com.netcracker.shared;


import java.io.Serializable;
import java.util.ArrayList;


public class Places implements Serializable {
    ArrayList<String> places;
    public void addPlace(String place){
        places.add(place);
    }
    public void removePlace(String place){
        places.remove(place);
    }
    public String get(){return places.toString();}
    public ArrayList<String> getPlaces(){
        return places;
    }

    public Places(){}
    public void setPlaces(ArrayList<String> places) {
        this.places = places;
    }
}
