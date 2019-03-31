package model;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Places {
    ArrayList<String> places;
    public void addPlace(String place){
        places.add(place);
    }
    public void removePlace(String place){
        places.remove(place);
    }
}
