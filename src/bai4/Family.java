package bai4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Family {
    private int numberOfPeople;
    private int addressNo;
    private List<People> members = new ArrayList<>();

    public Family(int numberOfPeople, int addressNo) {
        this.numberOfPeople = numberOfPeople;
        this.addressNo = addressNo;
        for(int i = 0; i < this.numberOfPeople; i++)    this.addMembers();
    }

    public void addMembers() {
        try {
            Scanner input = new Scanner(System.in);
            System.out.print("Input name: ");
            String name = input.nextLine();
            System.out.print("Input age: ");
            int age = Integer.parseInt(input.nextLine());
            if(age < 0)
                throw new PeopleException("Age not valid");
            System.out.print("Input job: ");
            String job = input.nextLine();
            System.out.print("Input id: ");
            String id = input.nextLine();
            if (Street.getPeopleID().contains(id))
                throw new PeopleException("ID already exists");
            Street.getPeopleID().add(id);
            this.members.add(new People(name, age, job, id));
        } catch (PeopleException e) {
            System.out.println("PLease enter people information again");
            addMembers();
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Family address no: ").append(this.addressNo).append("(").append(this.numberOfPeople).append(" people):\n");
        for(People people : this.members)   s.append(people.toString()).append('\n');
        return s.toString();
    }
}
