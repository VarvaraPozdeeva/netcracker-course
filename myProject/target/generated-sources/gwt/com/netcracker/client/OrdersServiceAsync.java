package com.netcracker.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface OrdersServiceAsync
{

    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.netcracker.client.OrdersService
     */
    void getAllOrders( AsyncCallback<com.netcracker.shared.Order[]> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.netcracker.client.OrdersService
     */
    void getOrderById( java.lang.String id, AsyncCallback<com.netcracker.shared.Order> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.netcracker.client.OrdersService
     */
    void setOrder( com.netcracker.shared.Order order, AsyncCallback<java.lang.String> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.netcracker.client.OrdersService
     */
    void getCountOfOrder( AsyncCallback<java.lang.Integer> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.netcracker.client.OrdersService
     */
    void updateOrderById( com.netcracker.shared.Order order, AsyncCallback<java.lang.String> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.netcracker.client.OrdersService
     */
    void deleteOrder( java.lang.Integer id, AsyncCallback<java.lang.String> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.netcracker.client.OrdersService
     */
    void sortedByName( AsyncCallback<com.netcracker.shared.Order[]> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.netcracker.client.OrdersService
     */
    void sortedByLastName( AsyncCallback<com.netcracker.shared.Order[]> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.netcracker.client.OrdersService
     */
    void sortedByMiddleName( AsyncCallback<com.netcracker.shared.Order[]> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.netcracker.client.OrdersService
     */
    void sortedByData( AsyncCallback<com.netcracker.shared.Order[]> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.netcracker.client.OrdersService
     */
    void getNextData( int index, AsyncCallback<com.netcracker.shared.Order[]> callback );


    /**
     * Utility class to get the RPC Async interface from client-side code
     */
    public static final class Util 
    { 
        private static OrdersServiceAsync instance;

        public static final OrdersServiceAsync getInstance()
        {
            if ( instance == null )
            {
                instance = (OrdersServiceAsync) GWT.create( OrdersService.class );
            }
            return instance;
        }

        private Util()
        {
            // Utility class should not be instantiated
        }
    }
}
