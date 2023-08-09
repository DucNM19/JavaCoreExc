package bai13expert.process;

import bai13expert.entities.Employee;
import bai13expert.exception.EmployeeException;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {

    public static boolean checkGeneral(String s, int i) {
        boolean result = true;
        switch (i) {
            case 0 -> result = checkName(s);
            case 1 -> result = checkDate(s);
            case 2 -> result = checkPhone(s);
            case 3 -> result = checkEmail(s);
            case 4 -> result = checkEmployeeType(s);
        }
        return result;
    }

    public static boolean checkPhone(String phone){
        if(phone.length() != 10)    return false;
        String regex = "^[0-9]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }

    public static boolean checkEmail(String email){
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean checkName(String name){
        String regex = "^[A-Za-z\\s]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }
    public static boolean checkDate(String date){
        //only use 2 formats: DD/MM/YYYY or DD-MM-YYYY (simplified version, uncheck corressponding days of months
        String regex = "^(0[1-9]|[12][0-9]|3[01])[\\/\\-](0[1-9]|1[012])[\\/\\-]\\d{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(date);
        return matcher.matches();
    }

    public static boolean checkEmployeeType(String employeeType) {
        return employeeType.equals("0") || employeeType.equals("1") || employeeType.equals("2");
    }
}
