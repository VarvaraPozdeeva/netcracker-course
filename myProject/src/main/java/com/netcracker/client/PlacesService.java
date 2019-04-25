package com.netcracker.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("places")
public interface PlacesService extends RemoteService {
    String[] getPlaces();
    String getPlace (String id);
    String setPlace(String place);
}
