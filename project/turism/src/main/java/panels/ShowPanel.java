package panels;

import json.ParseToJSON;
import model.Order;
import model.OrderModel;
import model.Places;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowPanel extends JPanel {

    private JTable table;
    private  JScrollPane jScrollPane;
    private OrderModel model;
    private JButton update;
    private JButton delete;
    private JTextArea status;
    private Places places;

    public ShowPanel(OrderModel model, Places places){

        this.model = model;
        this.places = places;
        setLayout(new BorderLayout());
        intiComponent();
    }
    private void intiComponent() {
        table = new JTable(model);
        setColumnsWidth(table);
        jScrollPane=new JScrollPane(table);

        JPanel but = new JPanel(new GridLayout(2,1));
        JPanel butPanel = new JPanel(new GridLayout(1,2, 10,10));
        status = new JTextArea();
        status.setText("Select row and enter new data or delete");
        but.add(status);
        update = new JButton("Update");
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Order o = model.getOrders().get(table.getSelectedRow());
                String s = AdditionalFunc.validateParam(o.getClient().getFirstName(), o.getClient().getMiddleName(),
                        o.getClient().getLastName(), o.getClient().getNumber(), o.getPlace().getDate());
                if (!(places.getPlaces().contains(o.getPlace().getDestination()))) {
                    s+="Please enter correct destination";
                }

                if(s.equals("")) {
                    status.setForeground(Color.BLACK);
                    status.setText("Update data on "+table.getSelectedRow()+" row");
                    ParseToJSON.toJSONOrder(model.getOrders());
                }
                else{
                    status.setForeground(Color.RED);
                    status.setText(s);
                }
            }
        });
        delete = new JButton("Delete");
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.removeRow(table.getSelectedRow());
                ParseToJSON.toJSONOrder(model.getOrders());
                status.setForeground(Color.BLACK);
                status.setText("Row deleted");

            }
        });
        butPanel.add(update);
        butPanel.setForeground(Color.lightGray);

        butPanel.add(delete);
        but.add(butPanel);
        add(but, BorderLayout.NORTH);
        add(jScrollPane, BorderLayout.CENTER);
    }
    private static void setColumnsWidth(JTable table) {
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        JTableHeader tableHeader = table.getTableHeader();
        for (int i = 0; i < table.getColumnCount(); i++) {
            TableColumn column = table.getColumnModel().getColumn(i);
            int prefWidth = Math.round((float) tableHeader.getFontMetrics(tableHeader.getFont()).
                    getStringBounds(tableHeader.getTable().getColumnName(i),tableHeader.getGraphics()).getWidth());
            column.setPreferredWidth(prefWidth + 10);
        }
    }
}
