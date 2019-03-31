package panels;

import model.Order;
import model.OrderModel;
import json.ParseToJSON;
import model.Places;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;

public class UpdatePanel extends JPanel {

    private JTextField id;
    private JTextArea status;
    private JTextField textFirstName;
    private JTextField textLastName;
    private JTextField textMiddleName;
    private JFormattedTextField ftfPhone;
    private JFormattedTextField ftfDate;
    private JComboBox comboBox;
    private ButtonGroup groupDay;
    private Order order;
    private JPanel content;

    private OrderModel model;
    private List<Order> orders;
    private Places places;

    public JComboBox getComboBox() {
        return comboBox;
    }

    public UpdatePanel(List<Order> orders, OrderModel model, Places places){

        this.orders = orders;
        this.model = model;
        this.places = places;
        setLayout(new BorderLayout());
        initComponent();
    }
    private void initComponent() {

        JPanel updateEnter = new JPanel(new GridLayout(1, 3, 20, 20));
        content = new JPanel(new GridLayout(8, 1, 10, 20));
        JLabel textId = new JLabel("Id");
        id = new JTextField(5);
        textId.setHorizontalAlignment(JLabel.CENTER);
        JButton enterId = new JButton("Search");
        status = new JTextArea("Enter order ID to update");
        enterId.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                order = AdditionalFunc.searchOrderById(id.getText(), orders);
                if(order != null){
                    createUpdateForm();
                }
                else{
                    status.setForeground(Color.RED);
                    status.setText("Order with this ID does not exist. Try again");
                }
            }
        });
        status.setEditable(false);
        status.setRows(2);
        add(status, BorderLayout.NORTH);
        updateEnter.add(textId);
        updateEnter.add(id);
        updateEnter.add(enterId);
        content.add(updateEnter);
        add(content, BorderLayout.CENTER);
        initField();

    }
    private void initField() {

        textFirstName = createField("First Name");
        textMiddleName = createField("Middle Name");
        textLastName = createField("Last Name");
        ftfPhone = createFormField("+#-###-###-##-##","Phone number" );
        ftfDate = createFormField("##.##.####", "Date");

        JPanel pDis = new JPanel(new GridLayout(1,2));
        JLabel lDis = new JLabel("Distination");
        lDis.setHorizontalAlignment(JLabel.CENTER);

        comboBox = new JComboBox(places.getPlaces().toArray());

        pDis.add(lDis);
        pDis.add(comboBox);
        content.add(pDis);

        JPanel pG = new JPanel(new GridLayout(1,2));
        groupDay = new ButtonGroup();
        JLabel lGb = new JLabel("Count day");
        lGb.setHorizontalAlignment(JLabel.CENTER);
        JRadioButton sevenDay = new JRadioButton("7", true);
        groupDay.add(sevenDay);
        JRadioButton tenDay = new JRadioButton("10", false);
        groupDay.add(tenDay);
        JRadioButton fourteenDay = new JRadioButton("14", false);
        groupDay.add(fourteenDay);
        JButton button = new JButton("Update");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                status.setText(updateOrder(textFirstName.getText(), textMiddleName.getText(), textLastName.getText(),
                        ftfPhone.getText(), ftfDate.getText(), groupDay, comboBox));
            }
        });

        pG.setBorder(BorderFactory.createLoweredBevelBorder());
        pG.add(lGb);
        pG.add(sevenDay);
        pG.add(tenDay);
        pG.add(fourteenDay);
        content.add(pG);
        add(button, BorderLayout.SOUTH);
    }
    private JTextField createField(String name){
        JPanel panel = new JPanel(new GridLayout(1,2));
        JLabel lable = new JLabel(name);
        JTextField field = new JTextField();
        field.setColumns(15);
        lable.setHorizontalAlignment(JLabel.CENTER);
        panel.add(lable);
        panel.add(field);
        content.add(panel);
        return  field;
    }
    private JFormattedTextField createFormField(String maska,String name) {

        JPanel panel = new JPanel(new GridLayout(1,2));
        JLabel lable = new JLabel(name);
        lable.setHorizontalAlignment(JLabel.CENTER);
        MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter(maska);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        formatter.setPlaceholderCharacter('0');
        JFormattedTextField field =  new JFormattedTextField(formatter);
        panel.add(lable);
        panel.add(field);
        content.add(panel);

        return field;
    }
    private void createUpdateForm() {
        status.setForeground(Color.BLACK);
        status.setText("Enter new data");
        textFirstName.setText(order.getClient().getFirstName());
        textMiddleName.setText(order.getClient().getMiddleName());
        textLastName.setText(order.getClient().getLastName());
        ftfPhone.setText(order.getClient().getNumber());
        comboBox.setSelectedItem(order.getPlace().getDestination());
        ftfDate.setText(order.getPlace().getDate());

    }
    private String updateOrder(String fn, String mn, String ln, String phone, String date, ButtonGroup gr, JComboBox cb) {

        String s = AdditionalFunc.validateParam(fn, mn, ln, phone, date);
        if (s.equals("")) {
            order.getClient().setFirstName(fn);
            order.getClient().setLastName(ln);
            order.getClient().setMiddleName(mn);
            order.getClient().setNumber(phone);

            order.getPlace().setCoutDays(AdditionalFunc.getCountDay(gr));
            order.getPlace().setDate(date);
            order.getPlace().setDestination(cb.getSelectedItem().toString());

            ParseToJSON.toJSONOrder(orders);
            model.fireTableDataChanged();
            clearField();
            status.setForeground(Color.GREEN);
            return "Order " +order.getId()+ " updated. Enter next ID";
        }
        else {
            status.setForeground(Color.RED);
            return s;
        }
    }
    private void clearField() {
        id.setText("");
        textMiddleName.setText("");
        textLastName.setText("");
        textFirstName.setText("");
        ftfDate.setText("00.00.0000");
        ftfPhone.setText("+0-000-000-00-00");
    }
}
