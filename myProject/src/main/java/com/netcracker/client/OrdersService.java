package com.netcracker.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.netcracker.shared.Order;

@RemoteServiceRelativePath("orders")
public interface OrdersService extends RemoteService {
    Order[] getAllOrders();
    Order getOrderById(String id);
    String setOrder(Order order);
    Integer getCountOfOrder();
    String updateOrderById(Order order);
    String deleteOrder(Integer id);
    Order[] sortedByName();
    Order[] sortedByLastName();
    Order[] sortedByMiddleName();
    Order[] sortedByData();
    Order[] getNextData(int index);

}
