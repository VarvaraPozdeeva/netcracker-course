package panels;

import model.Order;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.List;

public class AdditionalFunc {
    public static String validateParam(String fn, String mn, String ln, String ph, String dt){
        String s = new String();
        if(validateTextField(fn)){
            s+="Please, enter correct First Name\n\r";
        }
        if(validateTextField(mn)){
            s+="Please, enter correct Middle Name\n";
        }
        if(validateTextField(ln)){
            s+="Please, enter correct Last Name\n";
        }
        if(ph.equals("+0-000-000-00-00") || validatenumberFiled(ph)){
            s += "Please, enter correct phone number\n";
        }
        if(dt.equals("00.00.0000")){
            s += "Please, enter correct date\n";
            return s;
        }
        s += validateDate(dt);

        return s;
    }

    private static boolean validatenumberFiled(String s) {
        return !(s.matches("\\+\\d-\\d\\d\\d-\\d\\d\\d-\\d\\d-\\d\\d"));
    }

    private static boolean validateTextField(String s){
        return s.equals("") || s.matches("((([A-z]|[А-я])*)([0-9]+)(([A-z]|[А-я])*))+");
    }

    private static String validateDate(String s){
        String answer = "";
        String nowDate = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
        String year = nowDate.substring(0,4);

        if(Integer.parseInt(s.substring(6)) < Integer.parseInt(year) ||Integer.parseInt(s.substring(6)) >Integer.parseInt(year)+ 2 ){
            answer += "Please, enter correct year\n";
        }
        if(Integer.parseInt(s.substring(0,2)) > 32 ||Integer.parseInt(s.substring(0,2)) < 1 ){
            answer += "Please, enter correct day\n";
        }
        if(Integer.parseInt(s.substring(3,5)) > 12 || Integer.parseInt(s.substring(3,5))<1){
            answer += "Please, enter correct mounth\n";
        }
        int date = Integer.parseInt(s.substring(6))*10000 + Integer.parseInt(s.substring(3,5))*100 + Integer.parseInt(s.substring(0,2));

        if(Integer.parseInt(nowDate) > date){
            answer += "Please, enter a later date\n";
        }

        return answer;
    }
    public static int getCountDay(ButtonGroup gr){

        for (Enumeration<AbstractButton> buttons = gr.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return Integer.parseInt(button.getText());
            }
        }
        return 0;
    }
    public static Order searchOrderById(String s, List<Order> orders) {
        if(!(s.equals(""))) {
            int id = Integer.parseInt(s);
            for (Order o : orders) {
                if (o.getId() == id)
                    return o;
            }
        }
        return null;
    }

}
