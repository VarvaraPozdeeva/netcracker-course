package com.netcracker.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.netcracker.client.OrdersService;
import com.netcracker.server.parser.ParseFromJSON;
import com.netcracker.shared.Order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class OrdersServiceImpl extends RemoteServiceServlet implements OrdersService {

    private List<Order> orders = new ArrayList<>(Arrays.asList(new ParseFromJSON().parseOrder()));
    Order[] o = new Order[]{};
    private Order[] ordersArray = orders.toArray(o);
    private Integer index = 0 ;
    private int lastCount;

    @Override
    public Order[] getAllOrders() {
        Order[] o = new Order[]{};
        ordersArray = orders.toArray(o);
        return ordersArray;
    }

    @Override
    public Order getOrderById(String id) {
        return orders.get(Integer.parseInt(id));
    }

    @Override
    public String setOrder(Order order) {
        orders.add(orders.size(), order);
        ordersArray = orders.toArray(ordersArray);
        return "Order Added" ;
    }

    @Override
    public Integer getCountOfOrder() {

        return orders.get(orders.size()-1).getId();
    }

    @Override
    public String updateOrderById(Order order) {
        int i =0;
        for(; i<orders.size(); i++){
            if(orders.get(i).getId().equals(order.getId())){
               break;
            }
        }
        orders.remove(i);
        orders.add(i, order);
        ordersArray = orders.toArray(ordersArray);
        return order.getId().toString();
    }


    @Override
    public String deleteOrder(Integer id) {
        Order order = null;
        for(Order o: orders){
            if(o.getId().equals(id))
                order = o;
        }
        orders.remove(order);
        getNextData(0);
        return "Order deleted";
    }

    @Override
    public Order[] sortedByName() {
        orders.sort((o1, o2) -> {
            if(o1.getClient().getFirstName().compareTo(o2.getClient().getFirstName()) > 0)
            return 0;
            else return -1;
        });
        ordersArray = orders.toArray(ordersArray);
        return  getNextData(0);
    }

    @Override
    public Order[] sortedByLastName() {
        orders.sort((o1, o2) -> {
            if(o1.getClient().getLastName().compareTo(o2.getClient().getLastName()) > 0)
                return 0;
            else return -1;
        });
        ordersArray = orders.toArray(ordersArray);
        return  getNextData(0);
    }

    @Override
    public Order[] sortedByMiddleName() {
        orders.sort(new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                if(o1.getClient().getMiddleName().compareTo(o2.getClient().getMiddleName()) > 0)
                    return 0;
                else return -1;
            }
        });
        ordersArray = orders.toArray(ordersArray);
        return  getNextData(0);
    }

    @Override
    public Order[] sortedByData() {
        orders.sort((o1, o2) -> {
            if(o1.getId().compareTo(o2.getId()) > 0)
                return 0;
            else return -1;
        });
        ordersArray = orders.toArray(ordersArray);

        return  getNextData(0);
    }

    @Override
    public Order[] getNextData(int num) {
        Integer count = 5;
        Order[] res = new Order[count];
        if(num == 0){
            index =0;
            lastCount =0;
            if(ordersArray.length < count){
                return ordersArray;
            }
            for(int i = index; i< count; i++){
                res[i-index] = ordersArray[i];
            }
            index += count;
            return res;
        }
        else if(num == -1){
            if(index > 0){
                int s ;
                if(lastCount != 0 ){
                    index = index - lastCount;
                    s = lastCount;
                    lastCount=0;
                }
                else {
                    index -= count;
                    s= count;
                }
                for(int i =index; i< index+s; i++){
                    res[i - index] = ordersArray[i];
                }
                return res;
            }
        }
        else {
            int size;
            if(ordersArray.length < (index+ count) && lastCount == 0){
                size = ordersArray.length;
                lastCount = size - index;
                res = new Order[lastCount];
            }
            else {
                size = index + count;
            }
            for(int i = index; i< size; i++){
                res[i - index] = ordersArray[i];
            }
            index = size;
            return res;
        }
        return null;
    }
}
