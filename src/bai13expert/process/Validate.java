package bai13expert.process;

import bai13expert.entities.Employee;

import java.util.Scanner;

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
        for(int i = 0; i < email.length(); i++){
            if(email.charAt(i) == '@')  return true;
        }
        return false;
    }

    public static boolean checkName(String name){
        for(int i = 0; i < name.length(); i++){
            char c = name.charAt(i);
            if(c >= 'A' && c <= 'Z') continue;
            if(c >= 'a' && c <= 'z') continue;
            if(c == ' ')    continue;
            return false;
        }
        return true;
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
