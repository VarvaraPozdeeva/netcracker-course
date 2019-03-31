package json;

import model.Order;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Places;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ParseToJSON {

    static ObjectMapper mapper = new ObjectMapper();

    public static void toJSONOrder(List<Order> orders){

        try {
            mapper.writeValue(new File(".\\src\\main\\resources\\orders.json"), orders);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void toJSONPlaces(Places place){
        try {
            mapper.writeValue(new File(".\\src\\main\\resources\\places.json"), place);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
