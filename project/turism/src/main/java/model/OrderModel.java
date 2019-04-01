package model;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class OrderModel extends AbstractTableModel {

    private List<Order> orders;
    private boolean editable;

    public OrderModel(List<Order> orders, boolean editable) {
        this.orders = orders;
        this.editable = editable;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

            Order tmp = orders.get(rowIndex);
            switch (columnIndex) {
                case 1:
                    tmp.getClient().setFirstName(aValue.toString());
                    break;
                case 2:
                    tmp.getClient().setMiddleName(aValue.toString());
                    break;
                case 3:
                    tmp.getClient().setLastName(aValue.toString());
                    break;
                case 4:
                    tmp.getClient().setNumber(aValue.toString());
                    break;
                case 5:
                    tmp.getPlace().setDestination(aValue.toString());
                    break;
                case 6:
                    tmp.getPlace().setDate(aValue.toString());
                    break;
                case 7:
                    tmp.getPlace().setCoutDays((int) aValue);
                    break;
            }
    }

    public void removeRow(int rowIndex) {
        orders.remove(rowIndex);
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

    public List<Order> getOrders(){
        return orders;
    }
    @Override
    public boolean isCellEditable(int row, int column) {
        return editable;
    }
}
