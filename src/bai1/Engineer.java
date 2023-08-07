package bai1;

public class Engineer extends Employee{
    private String major;

    public Engineer(String name, short age, String gender, String address, String major) {
        super(name, age, gender, address);
        this.major = major;
    }

    @Override
    public String toString() {
        return "Employee type(Engineer): " + super.toString() + "_major: " + this.major;
    }
}
