package model;

import lombok.Data;

@Data
public class Order {
    private long id;
    private Client client;
    private Place place;
}
