package com.netcracker.client;

import com.google.gwt.user.client.ui.*;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;

public class gwt implements EntryPoint {

  private final OrdersServiceAsync ordersService = GWT.create(OrdersService.class);
  private final PlacesServiceAsync placesService = GWT.create(PlacesService.class);


  public void onModuleLoad() {

    final Button showButton = new Button( "Show" );
    final Button addButton = new Button( "Add new order" );
    final AddForm addForm = new AddForm(placesService, ordersService);
    final ShowForm showForm = new ShowForm(ordersService);


    RootPanel.get("sendButton").add(addButton);
    RootPanel.get("showButton").add(showButton);

    RootPanel.get("content").add(showForm);
    addButton.addClickHandler(clickEvent -> {
      RootPanel.get("content").clear();
      RootPanel.get("content").add(addForm);
    });
    showButton.addClickHandler(clickEvent -> {
      RootPanel.get("content").clear();
      showForm.getDataFromServer(0);
      RootPanel.get("content").add(showForm);

    });
  }
}
