package com.netcracker.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.netcracker.client.PlacesService;
import com.netcracker.server.parser.ParseFromJSON;


public class PlacesServerImpl extends RemoteServiceServlet  implements PlacesService {

    @Override
    public String[] getPlaces() {
        return new ParseFromJSON().parsePlace();
    }

    @Override
    public String getPlace(String id) {
        String[] places = new ParseFromJSON().parsePlace();
        return places[Integer.parseInt(id)];
    }

    @Override
    public String setPlace(String place) {
        return null;
    }
}
