package bai13expert.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Employee implements Serializable {
    String ID;
    String fullName;
    String BirthDay;
    String Phone;
    String email;
    int employeeType;
    List<Certificate> certificates = new ArrayList<>();
    static int employeeCount;

    public Employee(String ID, String fullName, String birthDay, String phone, String email, int employeeType) {
        this.ID = ID;
        this.fullName = fullName;
        this.BirthDay = birthDay;
        this.Phone = phone;
        this.email = email;
        this.employeeType = employeeType;
        employeeCount++;
    }

    public void addCertificates(){
        Scanner input = new Scanner(System.in);
        System.out.print("Input number of certificates: ");
        int N = Integer.parseInt(input.nextLine());
        for(int i = 0; i < N; i++){
            System.out.print("Input certificate ID: ");
            String ID = input.nextLine();
            System.out.print("Input certificate name: ");
            String name = input.nextLine();
            System.out.print("Input certificate rank: ");
            int rank = Integer.parseInt(input.nextLine());
            System.out.print("Input certificate date: ");
            String date = input.nextLine();
            certificates.add(new Certificate(ID, name, rank, date));
        }
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthDay() {
        return BirthDay;
    }

    public void setBirthDay(String birthDay) {
        BirthDay = birthDay;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(int employeeType) {
        this.employeeType = employeeType;
    }

    public List<Certificate> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<Certificate> certificates) {
        this.certificates = certificates;
    }
}
