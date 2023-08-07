package bai13expert.entities;

public class Experience extends Employee{
    private int expInYear;
    private String proSkill;


    public Experience(String ID, String fullName, String birthDay, String phone, String email,
                      int employeeType, int expInYear, String proSkill) {
        super(ID, fullName, birthDay, phone, email, employeeType);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    @Override
    public String toString() {
        return "Experience{" +
                "expInYear=" + expInYear +
                ", proSkill='" + proSkill + '\'' +
                ", ID='" + ID + '\'' +
                ", fullName='" + fullName + '\'' +
                ", BirthDay='" + BirthDay + '\'' +
                ", Phone='" + Phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
