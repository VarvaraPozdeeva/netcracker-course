package window;

import model.Order;
import model.OrderModel;
import json.ParseFromJSON;
import panels.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application extends JFrame {

    private OrderModel model;
    private List<Order> orders;

    public Application(){
        super("Orders");
        orders = new ArrayList<Order>(Arrays.asList(ParseFromJSON.parseOrder()));
        model = new OrderModel(orders);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponent();
        setPreferredSize(new Dimension(400, 500));
        pack();
        setVisible(true);
    }

    private void initComponent() {
        Font font = new Font("Verdana", Font.PLAIN, 10);
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setFont(font);
        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());

        JPanel add = new AddPanel(orders, model);
        JPanel show = new ShowPanel(model);
        JPanel update = new UpdatePanel(orders, model, ((AddPanel) add).getPlaces());
        JPanel delete = new DeletePanel(orders, model);
        JPanel edit  = new AddPlaces(((AddPanel) add).getComboBox(), ((UpdatePanel) update).getComboBox(), ((AddPanel) add).getPlaces());

        tabbedPane.addTab("Add", add);
        tabbedPane.addTab("Show", show);
        tabbedPane.addTab("Update", update);
        tabbedPane.addTab("Delete", delete);
        tabbedPane.addTab("Edit", edit);

        content.add(tabbedPane, BorderLayout.CENTER);
        getContentPane().add(content);
    }
    public static void main(String[] args) {
        System.out.println();
        javax.swing.SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                new Application();
            }
        });
    }
}


