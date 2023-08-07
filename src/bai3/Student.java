package bai3;

public class Student {
    private String id;
    private String name;
    private String address;
    private int priority;
    private char major;
    private String subjects;

    public Student(String id, String name, String address, int priority, char major) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.priority = priority;
        this.major = major;

        if(major == 'A')        this.subjects = "Toan, Ly, Hoa";
        else if (major == 'B')  this.subjects = "Toan, Hoa, Sinh";
        else if (major == 'C')  this.subjects = "Van, Su, Dia";
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getPriority() {
        return priority;
    }

    public char getMajor() {
        return major;
    }

    public String getSubjects() {
        return subjects;
    }

    @Override
    public String toString() {
        return this.id + ". " + this.name + "_" + this.address + "_" + this.major + "(" + this.subjects + ")";
    }
}
