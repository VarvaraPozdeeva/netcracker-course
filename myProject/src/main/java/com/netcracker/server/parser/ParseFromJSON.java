package com.netcracker.server.parser;

import com.netcracker.shared.Order;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStreamReader;

public class ParseFromJSON {

    private static ObjectMapper mapper = new ObjectMapper();

    public Order[] parseOrder() {
        {
            try {
                InputStreamReader reader = new InputStreamReader(
                        this.getClass().getResourceAsStream("/orders.json"));

                return mapper.readValue(reader, Order[].class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    public  String[] parsePlace(){

        try {
            InputStreamReader reader = new InputStreamReader(
                    this.getClass().getResourceAsStream("/placeList.json"));

            return mapper.readValue(reader, String[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
