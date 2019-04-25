package com.netcracker.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import com.netcracker.shared.FieldVerifier;
import com.netcracker.shared.Client;
import com.netcracker.shared.Order;
import com.netcracker.shared.Place;

public class AddForm extends Composite {

    private TextBox fName;
    private TextBox mName;
    private TextBox lName;
    private TextBox phone;
    private TextBox data;
    private ListBox placesList;
    private RadioButton sevenDay;
    private RadioButton tenDay ;
    private RadioButton fourteenDay;
    private PlacesServiceAsync placesService;
    private OrdersServiceAsync ordersService;
    private TextArea status;
    private int id =0;

    private Button addButton;
    private Button clearButton ;

    private TextBox createField(String text, Grid mainPanel, int row){
        TextBox textBox  = new TextBox();

        HorizontalPanel panel = new HorizontalPanel();
        panel.setSpacing(10);
        Label label = new Label(text);
        label.setStyleName("myText");
        mainPanel.setWidget(row,0, label);
        mainPanel.setWidget(row,1,textBox);

        return textBox;
    }

    public AddForm(PlacesServiceAsync pl, OrdersServiceAsync os){
        ordersService=os;
        placesService = pl;
        Grid panel = new Grid(9,2);
        panel.setCellSpacing(10);
        ordersService.getCountOfOrder(new AsyncCallback<Integer>() {
            @Override
            public void onFailure(Throwable throwable) {
                status.setText("Can`t get count of orders");
            }

            @Override
            public void onSuccess(Integer count) {
                id = count+1;
            }
        });


        fName = createField("First Name", panel, 1);
        mName = createField("Middle Name", panel,2);
        lName = createField("Last Name", panel,3);
        phone = createField("Phone", panel,4);
        data = createField("Date", panel,5);

        createPlace(panel, 6);
        createCountDay(panel, 7);

        addButton = new Button("Add");
        clearButton = new Button("Clear");
        addButton.addClickHandler(clickEvent -> sendToService());
        clearButton.addClickHandler(clickEvent -> {
            fName.setText("");
            mName.setText("");
            lName.setText("");
            phone.setText("");
            data.setText("");
        });
        panel.setWidget(8,0,addButton);
        panel.setWidget(8,1,clearButton);

        status = new TextArea();
        status.setText("Enter data");
        Label statusL = new Label("Info");
        statusL.setStyleName("myText");
        panel.setWidget(0,1, status);
        panel.setWidget(0,0,statusL);

        initWidget(panel);
    }

    private void createCountDay(Grid panel, int row) {
        HorizontalPanel countDay = new HorizontalPanel();
        countDay.setSpacing(10);
        Label countDayLabel = new Label("Count Day");
        countDayLabel.setStyleName("myText");
        sevenDay = new RadioButton("countDay", "7");
        tenDay = new RadioButton("countDay", "10");
        fourteenDay = new RadioButton("countDay", "14");
        countDay.add(sevenDay);
        countDay.add(tenDay);
        countDay.add(fourteenDay);
        sevenDay.setValue(true);
        countDay.setStyleName("myText");
        panel.setWidget(row,0, countDayLabel);
        panel.setWidget(row,1, countDay);

    }

    private void createPlace(Grid panel, int row) {
        placesList = new ListBox();
        placesService.getPlaces(new AsyncCallback<String[]>() {
            @Override
            public void onFailure(Throwable throwable) {
                status.setText("Can not found places!");
            }

            @Override
            public void onSuccess(String[] places) {
                for(String pl:places){
                    placesList.addItem(pl);
                }
            }
        });
        Label placeLabel = new Label("Place");
        placeLabel.setStyleName("myText");
        placesList.setVisibleItemCount(1);
        panel.setWidget(row,0,placeLabel);
        panel.setWidget(row,1,placesList);
    }

    private void sendToService() {
       String answer =  FieldVerifier.validateParam
               (fName.getText(), mName.getText(), lName.getText(), phone.getText(), data.getText());
       if(answer.equals("")){
           ordersService.setOrder(createOrder(), new AsyncCallback<String>() {
               @Override
               public void onFailure(Throwable throwable) {
                   status.setText("Error on server");
               }

               @Override
               public void onSuccess(String s) {
                   status.setText(s);
               }
           });
       }
       else
       {
           status.setText(answer);
       }
    }
    private Order createOrder(){
        Order order = new Order();
        Client client = new Client();
        Place place = new Place();

        client.setFirstName(fName.getText());
        client.setMiddleName(mName.getText());
        client.setLastName(lName.getText());
        client.setNumber(phone.getText());

        place.setDate(data.getText());
        place.setDestination(placesList.getSelectedItemText());
        if(sevenDay.getValue()){
            place.setCoutDays(7);
        }
        if(fourteenDay.getValue()){
            place.setCoutDays(14);
        }
        if(tenDay.getValue()){
            place.setCoutDays(10);
        }

        order.setClient(client);
        order.setPlace(place);
        order.setId(id++);
        return order;
    }


}
