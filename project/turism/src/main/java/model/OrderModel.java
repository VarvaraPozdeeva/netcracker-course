package model;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class OrderModel extends AbstractTableModel {

    List<Order> orders = new ArrayList<>();

    public OrderModel(List<Order> orders) {
        this.orders = orders;
    }
    public void addOrder(Order o){
        orders.add(o);
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return orders.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Order tmp = orders.get(rowIndex);
        switch (columnIndex){
            case 0: return tmp.getId();
            case 1: return tmp.getClient().getFirstName();
            case 2: return tmp.getClient().getMiddleName();
            case 3: return tmp.getClient().getLastName();
            case 4: return tmp.getClient().getNumber();
            case 5: return tmp.getPlace().getDestination();
            case 6: return tmp.getPlace().getDate();
            case 7: return  tmp.getPlace().getCoutDays();
        }
        return null;
    }
    @Override
    public String getColumnName(int column) {
        switch (column){
            case 0: return "ID";
            case 1: return "First Name";
            case 2: return "Middle Name";
            case 3: return "Last Name";
            case 4: return "Phone                      ";
            case 5: return "Destination";
            case 6: return "Date                  ";
            case 7: return "CountDay";
        }
        return super.getColumnName(column);
    }
}
