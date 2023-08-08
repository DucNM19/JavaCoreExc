package bai13expert.process;

import bai13expert.entities.Employee;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    public static boolean checkPhone(String phone){
        if(phone.length() != 10)    return false;
        for(int i = 0; i < 10; i++){
            if (phone.charAt(i) < '0' || phone.charAt(i) > '9')
                return false;
        }
        return true;
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
        //only use 1 format: DD/MM/YYYY (simplified version, uncheck corressponding days of months
        int day = Integer.parseInt(date.substring(0, 2));
        int month = Integer.parseInt(date.substring(3, 5));
        int year = Integer.parseInt(date.substring(6, 10));
        if(day <= 0 || day > 31) return false;
        if(month <= 0 || month > 12)    return false;
        return year > 0 && year < 2023;
    }

}
