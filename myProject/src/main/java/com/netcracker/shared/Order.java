package com.netcracker.shared;

import java.io.Serializable;

public class Order implements Serializable {
    private int id;
    private Client client;
    private Place place;

    public Order(){}

    public void setId(int id) {
        this.id = id;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public Integer getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public Place getPlace() {
        return place;
    }
}
