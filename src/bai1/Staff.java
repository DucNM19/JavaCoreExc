package bai1;

public class Staff extends Employee{
    public String work;

    public Staff(String name, short age, String gender, String address, String work) {
        super(name, age, gender, address);
        this.work = work;
    }

    @Override
    public String toString() {
        return "Employee type(Staff): " + super.toString() + "_work: " + this.work;
    }
}
