package com.netcracker.client;

import com.google.gwt.cell.client.TextInputCell;
import com.google.gwt.user.cellview.client.*;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SingleSelectionModel;
import com.netcracker.shared.Order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShowForm extends Composite {
    private OrdersServiceAsync ordersService;
    private CellTable<Order> table;
    private List<Order> orders;
    private TextArea status;
    private ListDataProvider<Order> ordersList;
    private SingleSelectionModel<Object> selectionModel;
    private Button delete;

    private Button sortedFName;
    private Button sortedLName;
    private Button sortedMName;
    private Button sortedId;
    private Button next;
    private Button early;



    public ShowForm(OrdersServiceAsync os){

        VerticalPanel panel = new VerticalPanel();
        ordersService=os;
        orders = new ArrayList<>();
        ordersList = new ListDataProvider<>();
        HorizontalPanel buttonPanel = new HorizontalPanel();
        buttonPanel.setSpacing(10);

        Label sortL = new Label("Sorted by:");
        sortL.setStyleName("myText");
        sortedFName = new Button("FirstName");
        sortedLName = new Button("LastName");
        sortedMName = new Button("MiddleName");
        sortedId = new Button("Id");

        delete = new Button("Delete");
        next = new Button("Next");
        early = new Button("Early");

        status = new TextArea();

        getDataFromServer(0);
        ordersList.setList(orders);


        delete.addClickHandler(clickEvent -> removeOrder());
        sortedFName.addClickHandler(clickEvent -> ordersService.sortedByName(new AsyncCallback<Order[]>() {
            @Override
            public void onFailure(Throwable throwable) {
                status.setText("Can`t sort");
            }

            @Override
            public void onSuccess(Order[] o) {
                orders = Arrays.asList(o);
                ordersList.setList(orders);
                table.redraw();
            }
        }));
        sortedLName.addClickHandler(clickEvent -> ordersService.sortedByLastName(new AsyncCallback<Order[]>() {
            @Override
            public void onFailure(Throwable throwable) {
                status.setText("Can`t sort");
            }

            @Override
            public void onSuccess(Order[] o) {
                orders = Arrays.asList(o);
                ordersList.setList(orders);
                table.redraw();
            }
        }));
        sortedMName.addClickHandler(clickEvent -> ordersService.sortedByMiddleName(new AsyncCallback<Order[]>() {
            @Override
            public void onFailure(Throwable throwable) {
                status.setText("Can`t sort");
            }

            @Override
            public void onSuccess(Order[] o) {
                orders = Arrays.asList(o);
                ordersList.setList(orders);
                table.redraw();
            }
        }));
        sortedId.addClickHandler(clickEvent -> ordersService.sortedByData(new AsyncCallback<Order[]>() {
            @Override
            public void onFailure(Throwable throwable) {
                status.setText("Can`t sort");
            }

            @Override
            public void onSuccess(Order[] o) {
                orders = Arrays.asList(o);
                ordersList.setList(orders);
                table.redraw();
            }
        }));
        next.addClickHandler(clickEvent -> getDataFromServer(1));
        early.addClickHandler(clickEvent -> getDataFromServer(-1));

        buttonPanel.add(delete);
        buttonPanel.add(early);
        buttonPanel.add(next);
        buttonPanel.add(sortL);
        buttonPanel.add(sortedFName);
        buttonPanel.add(sortedLName);
        buttonPanel.add(sortedMName);
        buttonPanel.add(sortedId);
        panel.add(buttonPanel);

        createTable();
        panel.add(table);

        HorizontalPanel statusPanel = new HorizontalPanel();
        Label statusLabel = new Label("Info");
        statusLabel.setStyleName("myText");
        statusPanel.add(statusLabel);
        statusPanel.add(status);

        panel.add(statusPanel);
        initWidget(panel);
    }


    private void removeOrder() {
        Order o = (Order) selectionModel.getSelectedObject();
        ordersService.deleteOrder(o.getId(), new AsyncCallback<String>() {
            @Override
            public void onFailure(Throwable throwable) {
                status.setText("Can`t delete");
            }

            @Override
            public void onSuccess(String s) {
                status.setText(s + " " +  o.getClient().getFirstName());
                getDataFromServer(2);
            }
        });
    }

    public void getDataFromServer(int num){
        ordersService.getNextData(num,new AsyncCallback<Order[]>() {
            @Override
            public void onFailure(Throwable throwable) {
                status.setText("Server error");
            }

            @Override
            public void onSuccess(Order[] ord) {
                status.setText("");
                orders = Arrays.asList(ord);
                table.setRowCount(orders.size(), true);
                table.setRowData(0, orders);
            }
        });
    }
    private void createTable(){

        table = new CellTable<>();
        table.setKeyboardSelectionPolicy(HasKeyboardSelectionPolicy.KeyboardSelectionPolicy.ENABLED);
        ordersList.addDataDisplay(table);

        TextColumn<Order> id = new TextColumn<Order>() {
            @Override
            public String getValue(Order order) {
                return order.getId().toString();
            }
        };
        table.addColumn(id, "Id");

        TextInputCell fNameCell = new TextInputCell();
        Column<Order, String> fNameCol = new Column<Order, String>(fNameCell) {
            @Override
            public String getValue(Order order) {
                return order.getClient().getFirstName();
            }
        };
        table.addColumn(fNameCol, "FirstName");
        fNameCol.setFieldUpdater((i, order, s) -> {
            order.getClient().setFirstName(s);
            saveChange(order);
            table.redraw();
        });

        TextInputCell mNameCell = new TextInputCell();
        Column<Order, String> mNameCol = new Column<Order, String>(mNameCell) {
            @Override
            public String getValue(Order order) {
                return order.getClient().getMiddleName();
            }
        };
        table.addColumn(mNameCol, "MiddleName");
        mNameCol.setFieldUpdater((i, order, s) -> {
            order.getClient().setMiddleName(s);
            saveChange(order);
            table.redraw();
        });

        TextInputCell lNameCell = new TextInputCell();
        Column<Order, String> lNameCol = new Column<Order, String>(lNameCell) {
            @Override
            public String getValue(Order order) {
                return order.getClient().getLastName();
            }
        };
        table.addColumn(lNameCol, "LastName");
        lNameCol.setFieldUpdater((i, order, s) -> {
            order.getClient().setLastName(s);
            saveChange(order);
            table.redraw();
        });

        TextInputCell phoneCell = new TextInputCell();
        Column<Order, String> phone = new Column<Order, String>(phoneCell) {
            @Override
            public String getValue(Order order) {
                return order.getClient().getNumber();
            }
        };
        table.addColumn(phone, "Phone");
        phone.setFieldUpdater((i, order, s) -> {
            order.getClient().setNumber(s);
            saveChange(order);
            table.redraw();
        });


        TextInputCell dataCel = new TextInputCell();
        Column<Order, String> data = new Column<Order, String>(dataCel) {
            @Override
            public String getValue(Order order) {
                return order.getPlace().getDate();
            }
        };
        data.setFieldUpdater((i, order, s) -> {
            order.getPlace().setDate(s);
            saveChange(order);
            table.redraw();
        });
        table.addColumn(data, "Date");

        TextInputCell placeCell = new TextInputCell();
        Column<Order, String> place = new Column<Order, String>(placeCell) {
            @Override
            public String getValue(Order order) {
                return order.getPlace().getDestination();
            }
        };
        place.setFieldUpdater((i, order, s) -> {
            order.getPlace().setDestination(s);
            saveChange(order);
            table.redraw();
        });
        table.addColumn(place, "Place");

        TextInputCell contCell = new TextInputCell();
        Column<Order, String> countDay = new Column<Order, String>(contCell) {
            @Override
            public String getValue(Order order) {
                return order.getPlace().getCoutDays().toString();
            }
        };
        countDay.setFieldUpdater((i, order, s) -> {
            order.getPlace().setCoutDays(Integer.parseInt(s));
            saveChange(order);
            table.redraw();
        });
        table.addColumn(countDay, "CountDay");
        table.setWidth("100%", true);
        table.setColumnWidth(id, "50px");
        table.setStyleName("myTable");
        selectionModel = new SingleSelectionModel<>();
        table.setSelectionModel(selectionModel);

    }
    private void saveChange(Order order){

            ordersService.updateOrderById(order, new AsyncCallback<String>() {
                @Override
                public void onFailure(Throwable throwable) {
                    status.setText("Can`t update");
                }

                @Override
                public void onSuccess(String s) {
                    status.setText("Update  " + s );
                    table.redraw();
                }
            });
    }

}
