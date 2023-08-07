package bai13expert.entities;

public class Fresher extends Employee{
    private int graduationDate;
    private String graduationRank;
    private String education;

    public Fresher(String ID, String fullName, String birthDay, String phone,
                   String email, int employeeType, int graduationDate, String graduationRank, String education) {
        super(ID, fullName, birthDay, phone, email, employeeType);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }

    @Override
    public String toString() {
        return "Fresher{" +
                "graduationDate=" + graduationDate +
                ", graduationRank='" + graduationRank + '\'' +
                ", education='" + education + '\'' +
                ", ID='" + ID + '\'' +
                ", fullName='" + fullName + '\'' +
                ", BirthDay='" + BirthDay + '\'' +
                ", Phone='" + Phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
