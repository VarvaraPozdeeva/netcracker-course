package com.netcracker.shared;

import java.io.Serializable;

public class Place implements Serializable {
    private String destination;
    private String date;
    private Integer coutDays;

    public Place(String destination, String date, int coutDays) {
        this.destination = destination;
        this.date = date;
        this.coutDays = coutDays;
    }
    public Place(){

    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setCoutDays(Integer coutDays) {
        this.coutDays = coutDays;
    }

    public String getDestination() {
        return destination;
    }

    public String getDate() {
        return date;
    }

    public Integer getCoutDays() {
        return coutDays;
    }
}
