package com.netcracker.server.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netcracker.shared.Order;
import com.netcracker.shared.Places;

import java.io.*;
import java.util.List;

public class ParseToJSON {

    static ObjectMapper mapper = new ObjectMapper();


    public  void toJSONOrders(List<Order> orders){

        try {
            FileOutputStream fos = new FileOutputStream("/target/orders.json");
            mapper.writeValue(fos, orders);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  void toJSONPlaces(Places place){
        try {
            FileOutputStream fos = new FileOutputStream("/placeList.json");
            mapper.writeValue(fos, place);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
