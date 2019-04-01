package panels;

import model.*;
import json.ParseToJSON;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;

public class AddPanel extends JPanel {

    private List<Order> orders;
    private OrderModel model;
    private JPanel addField;
    private JTextArea status;
    private JTextField textFirstName;
    private JTextField textLastName;
    private JTextField textMidleName;
    private JFormattedTextField ftfPhone;
    private JFormattedTextField ftfDate;
    private JComboBox comboBox;
    private ButtonGroup groupDay;
    private Places places;

    public JComboBox getComboBox() {
        return comboBox;
    }




    public AddPanel(List<Order> orders, OrderModel model, Places places){

        this.orders = orders;
        this.model = model;
        this.places = places;
        setLayout(new BorderLayout());
        initComponent();
    }
    private void initComponent() {

        addField = new JPanel(new GridLayout(7, 1, 10, 20));
        initField();
        status = new JTextArea("Enter information");
        status.setEditable(false);
        status.setRows(2);
        add(status, BorderLayout.NORTH);
        add(addField, BorderLayout.CENTER);
        initButtonAddCancel();
    }
    private String addOrder(String fn, String mn, String ln, String phone, String date, ButtonGroup gr, JComboBox cb) {

        String s = AdditionalFunc.validateParam(fn, mn, ln, phone, date);
        System.out.println(orders);
        if (s.equals("")) {
            Order order = new Order();
            Client client = new Client();
            Place place = new Place();

            place.setCoutDays(AdditionalFunc.getCountDay(groupDay));
            place.setDate(date);
            place.setDestination(cb.getSelectedItem().toString());

            client.setFirstName(fn);
            client.setLastName(ln);
            client.setMiddleName(mn);
            client.setNumber(phone);

            order.setClient(client);
            order.setPlace(place);
            order.setId(orders.get(orders.size() - 1).getId() + 1);
            orders.add(order);
            ParseToJSON.toJSONOrder(orders);
            model.fireTableDataChanged();
            clearField();
            status.setForeground(Color.GREEN);
            return "Order added. Enter next data";
        }
        else {
            status.setForeground(Color.RED);
            return s;
        }
    }
    private JTextField createField(String name){

        JPanel panel = new JPanel(new GridLayout(1,2));
        JLabel label = new JLabel(name);
        label.setHorizontalAlignment(JLabel.CENTER);
        JTextField field = new JTextField(15);
        panel.add(label);
        panel.add(field);
        addField.add(panel);
        return  field;

    }
    private void initButtonAddCancel(){
        JPanel but = new JPanel(new BorderLayout());
        JPanel button = new JPanel(new GridLayout(1,4, 20, 20));
        JButton ok = new JButton("Add");
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                status.setText(addOrder(textFirstName.getText(), textMidleName.getText(), textLastName.getText(),
                        ftfPhone.getText(), ftfDate.getText(), groupDay, comboBox));

            }
        });
        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearField();
            }
        });
        button.add(ok);
        button.add(cancel);
        but.add(button, BorderLayout.SOUTH);
        add(but, BorderLayout.SOUTH);
    }
    private void clearField(){
        textMidleName.setText("");
        textLastName.setText("");
        textFirstName.setText("");
        ftfDate.setText("00.00.0000");
        ftfPhone.setText("+0-000-000-00-00");
        status.setForeground(Color.BLACK);
        status.setText("Enter data");
    }
    private void initField() {

        JPanel destination = new JPanel(new GridLayout(1,2));
        JLabel labeldestination = new JLabel("Destination");
        labeldestination.setHorizontalAlignment(JLabel.CENTER);

        comboBox = new JComboBox(places.getPlaces().toArray());
        destination.add(labeldestination);
        destination.add(comboBox);

        JPanel countDay =  new JPanel(new GridLayout(1,2));
        JLabel labelcountDay = new JLabel("Count day");
        labelcountDay.setHorizontalAlignment(JLabel.CENTER);
        groupDay = new ButtonGroup();
        JRadioButton sevenDay = new JRadioButton("7", true);
        groupDay.add(sevenDay);
        JRadioButton tenDay = new JRadioButton("10", false);
        groupDay.add(tenDay);
        JRadioButton fourteenDay = new JRadioButton("14", false);
        groupDay.add(fourteenDay);
        countDay.setBorder(BorderFactory.createLoweredBevelBorder());
        countDay.add(labelcountDay);
        countDay.add(sevenDay);
        countDay.add(tenDay);
        countDay.add(fourteenDay);


        textFirstName = createField("First Name");
        textMidleName = createField("Middle Name");
        textLastName = createField("Last Name");
        ftfPhone = createFormField("+#-###-###-##-##", "Phone Number");
        addField.add(destination);
        ftfDate = createFormField("##.##.####", "Data");
        addField.add(countDay);
        addField.setBorder(BorderFactory.createLineBorder(Color.lightGray));
    }
    private JFormattedTextField createFormField(String maska, String name) {

        JPanel panel = new JPanel(new GridLayout(1,2));
        JPanel panel1 = new JPanel(new GridLayout(1,2));
        JLabel label = new JLabel(name);
        label.setHorizontalAlignment(JLabel.CENTER);
        MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter(maska);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        formatter.setPlaceholderCharacter('0');
        JFormattedTextField field =  new JFormattedTextField(formatter);
        field.setColumns(16);
        panel1.add(label);
        panel1.add(field);
        panel.add(panel1, BorderLayout.WEST);
        addField.add(panel);

        return field;
    }
}
