package com.netcracker.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface PlacesServiceAsync
{

    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.netcracker.client.PlacesService
     */
    void getPlaces( AsyncCallback<java.lang.String[]> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.netcracker.client.PlacesService
     */
    void getPlace( java.lang.String id, AsyncCallback<java.lang.String> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.netcracker.client.PlacesService
     */
    void setPlace( java.lang.String place, AsyncCallback<java.lang.String> callback );


    /**
     * Utility class to get the RPC Async interface from client-side code
     */
    public static final class Util 
    { 
        private static PlacesServiceAsync instance;

        public static final PlacesServiceAsync getInstance()
        {
            if ( instance == null )
            {
                instance = (PlacesServiceAsync) GWT.create( PlacesService.class );
            }
            return instance;
        }

        private Util()
        {
            // Utility class should not be instantiated
        }
    }
}
