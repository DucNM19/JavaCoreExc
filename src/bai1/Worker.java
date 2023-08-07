package bai1;

import java.util.Scanner;

public class Worker extends Employee{
    private short level;

    public Worker(String name, short age, String gender, String address, short level) {
        super(name, age, gender, address);
        this.level = level;
    }

    @Override
    public String toString() {
        return "Employee type(Worker): " + super.toString() + "_level: " + this.level;
    }
}
