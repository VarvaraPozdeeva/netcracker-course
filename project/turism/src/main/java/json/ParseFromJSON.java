package json;

import model.Order;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Places;

import java.io.File;
import java.io.IOException;

public class ParseFromJSON {

    static ObjectMapper mapper = new ObjectMapper();

    public static Order[] parseOrder() {
        {

            try {
                return mapper.readValue(new File(".\\src\\main\\resources\\orders.json"), Order[].class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    public static Places parsePlace(){

        try {

            return mapper.readValue(new File(".\\src\\main\\resources\\places.json"), Places.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
