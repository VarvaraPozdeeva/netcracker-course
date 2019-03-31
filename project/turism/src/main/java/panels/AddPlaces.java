package panels;

import json.ParseToJSON;
import model.Places;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPlaces extends JPanel {

    private JComboBox cbAdd;
    private JComboBox cbUp;
    private Places places;
    private JTextArea statusAdd;
    private JTextArea statusDel;
    JTextField newPlace;
    JTextField delPlace;


    public AddPlaces(JComboBox cbA, JComboBox cbU, Places places){
        setLayout(new GridLayout(2,1));
        this.cbAdd = cbA;
        this.cbUp = cbU;
        this.places = places;
        initComponent();
    }

    private void initComponent() {
        JPanel add = new JPanel(new BorderLayout());
        JPanel del = new JPanel(new BorderLayout());

        JPanel contAdd = new JPanel();
        newPlace = new JTextField();
        newPlace.setColumns(15);
        JButton butAdd = new JButton("Add place");
        butAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editAdd(newPlace.getText());
            }
        });
        contAdd.add(newPlace);
        contAdd.add(butAdd);

        statusAdd = new JTextArea("Enter new place");
        statusAdd.setRows(2);
        add.add(statusAdd, BorderLayout.NORTH);
        add.add(contAdd);

        JPanel contDel = new JPanel();
        delPlace = new JTextField();
        delPlace.setColumns(15);
        JButton butDel = new JButton("Delete place");
        butDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editDel(delPlace.getText());
            }
        });
        contDel.add(delPlace);
        contDel.add(butDel);

        statusDel = new JTextArea("Enter a place to delete");
        statusDel.setRows(2);
        del.add(statusDel, BorderLayout.NORTH);
        del.add(contDel);

        add(add);
        add(del);
    }

    private void editDel(String s) {
        if(s.equals("")){
            statusDel.setForeground(Color.RED);
            statusDel.setText("Enter place");
        }
        else {
            for(String pl: places.getPlaces()){
                if(pl.equals(s)){
                    cbAdd.removeItem(s);
                    cbUp.removeItem(s);
                    statusDel.setForeground(Color.GREEN);
                    statusDel.setText(s + " deleted");
                    delPlace.setText("");
                    places.removePlace(s);
                    ParseToJSON.toJSONPlaces(places);
                    return;
                }
            }
            statusDel.setForeground(Color.RED);
            statusDel.setText(s + " does not exist. Try again");
            delPlace.setText("");
        }
    }

    private void editAdd(String s) {
        if(s.equals("")){
            statusAdd.setForeground(Color.RED);
            statusAdd.setText("Enter place");
        }
        else {
            for(String place: places.getPlaces()){
                if(place.equals(s)){
                    statusAdd.setForeground(Color.RED);
                    statusAdd.setText("This place is already on the list.");
                    return;
                }
            }
            cbAdd.addItem(s);
            cbUp.addItem(s);
            places.addPlace(s);
            ParseToJSON.toJSONPlaces(places);
            statusAdd.setForeground(Color.GREEN);
            statusAdd.setText(s + " added");
            newPlace.setText("");
        }
    }
}
