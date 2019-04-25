package com.netcracker.shared;


/**
 * <p>
 * FieldVerifier validates that the name the user enters is valid.
 * </p>
 * <p>
 * This class is in the <code>shared</code> packing because we use it in both
 * the client code and on the server. On the client, we verify that the name is
 * valid before sending an RPC request so the user doesn't have to wait for a
 * network round trip to get feedback. On the server, we verify that the name is
 * correct to ensure that the input is correct regardless of where the RPC
 * originates.
 * </p>
 * <p>
 * When creating a class that is used on both the client and the server, be sure
 * that all code is translatable and does not use native JavaScript. Code that
 * is note translatable (such as code that interacts with a database or the file
 * system) cannot be compiled into client side JavaScript. Code that uses native
 * JavaScript (such as Widgets) cannot be run on the server.
 * </p>
 */
public class FieldVerifier {

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
      s += "Please, enter correct phone number, +8-888-888-88-88\n";
    }
    if(dt.equals("00.00.0000")){
      s += "Please, enter noy null date\n";
      return s;
    }
    if(validDate(dt)) {
      s += "Please, enter correct date, format - 00.00.0000\n";
    }
     else
       s += validateDate(dt);

    return s;
  }

  private static boolean validatenumberFiled(String s) {
    return !(s.matches("\\+\\d-\\d\\d\\d-\\d\\d\\d-\\d\\d-\\d\\d"));
  }

  private static boolean validateTextField(String s){
    return s.equals("") || s.matches("((([A-z]|[А-я])*)([0-9]+)(([A-z]|[А-я])*))+");
  }
  private static boolean validDate(String s){
    return  !(s.matches("\\d\\d\\.\\d\\d\\.\\d\\d\\d\\d"));
  }

  private static String validateDate(String s){
    String answer = "";

    if(Integer.parseInt(s.substring(0,2)) > 32 ||Integer.parseInt(s.substring(0,2)) < 1 ){
      answer += "Please, enter correct day\n";
    }
    if(Integer.parseInt(s.substring(3,5)) > 12 || Integer.parseInt(s.substring(3,5))<1){
      answer += "Please, enter correct mounth\n";
    }
    int date = Integer.parseInt(s.substring(6))*10000 + Integer.parseInt(s.substring(3,5))*100 + Integer.parseInt(s.substring(0,2));


    return answer;
  }
}
