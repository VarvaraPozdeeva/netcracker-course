package panels;

import model.Order;
import model.OrderModel;
import json.ParseToJSON;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class DeletePanel extends JPanel {

    private JTextField idDel;
    private JTextArea statusDel;
    private OrderModel model;
    private List<Order> orders;

    public DeletePanel(List<Order> orders, OrderModel model){
        this.orders = orders;
        this.model = model;
        setLayout(new BorderLayout());
        initComponent();
    }
    private void initComponent() {

        JLabel textIdDel = new JLabel("Id");
        textIdDel.setHorizontalAlignment(JLabel.CENTER);
        JPanel delContent = new JPanel(new GridLayout(12,1));
        JPanel del = new JPanel(new GridLayout(1, 3, 20, 20));
        idDel = new JTextField(5);
        JButton enterIdDel = new JButton("Delete");
        del.add(textIdDel);
        del.add(idDel);
        statusDel = new JTextArea("Enter order ID to delete");
        statusDel.setRows(2);
        enterIdDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteOrder();
            }
        });
        add(statusDel, BorderLayout.NORTH);
        del.add(enterIdDel);
        delContent.add(del);
        add(delContent, BorderLayout.CENTER);

    }
    private void deleteOrder() {
        Order ord = AdditionalFunc.searchOrderById(idDel.getText(), orders);
        if(ord!= null){
            orders.remove(ord);
            ParseToJSON.toJSONOrder(orders);
            statusDel.setForeground(Color.GREEN);
            statusDel.setText("Order " +idDel.getText()+ " deleted");
            idDel.setText("");
            model.fireTableDataChanged();
        }
        else{
            statusDel.setForeground(Color.RED);
            statusDel.setText("Order with this ID does not exist. Try again");
        }
    }
}
