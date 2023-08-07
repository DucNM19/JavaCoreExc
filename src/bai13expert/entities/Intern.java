package bai13expert.entities;

public class Intern extends Employee{
    private String majors;
    private int semester;
    private String universityName;

    public Intern(String ID, String fullName, String birthDay,
                  String phone, String email, int employeeType, String majors, int semester, String universityName) {
        super(ID, fullName, birthDay, phone, email, employeeType);
        this.majors = majors;
        this.semester = semester;
        this.universityName = universityName;
    }

    @Override
    public String toString() {
        return "Intern{" +
                "majors='" + majors + '\'' +
                ", semester=" + semester +
                ", universityName='" + universityName + '\'' +
                ", ID='" + ID + '\'' +
                ", fullName='" + fullName + '\'' +
                ", BirthDay='" + BirthDay + '\'' +
                ", Phone='" + Phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
