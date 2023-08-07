package bai13expert.process;

import bai13expert.exception.EmployeeException;
import bai13expert.entities.Employee;
import bai13expert.entities.Experience;
import bai13expert.entities.Fresher;
import bai13expert.entities.Intern;

import java.io.*;
import java.util.*;

public class EmployeeManagement {
    private static Map<String, Employee> employees = new HashMap<>();

    public static void addEmployee() {
        try {
            Scanner input = new Scanner(System.in);

            System.out.print("Creating new employee...\nInput ID: ");
            String ID = input.nextLine();

            if(employees.containsKey(ID)){
                System.out.println("ID already exist");
                addEmployee();
            }

            System.out.print("Input Full Name: ");
            String fullName = input.nextLine();
            if (!Validate.checkName(fullName)) throw new EmployeeException("Wrong name format");

            System.out.print("Input birthday: ");
            String birthday = input.nextLine();
            if (!Validate.checkDate(birthday)) throw new EmployeeException("Wrong birthday format");

            System.out.print("Input phone: ");
            String phone = input.nextLine();
            if (!Validate.checkPhone(phone)) throw new EmployeeException("Wrong phone format");

            System.out.print("Input email: ");
            String email = input.nextLine();
            if (!Validate.checkEmail(email)) throw new EmployeeException("Wrong email format");

            System.out.print("Input employee type(0 Experience, 1 Fresher, 2 Intern): ");
            int employeeType = Integer.parseInt(input.nextLine());

            switch (employeeType) {
                case 0 -> {
                    System.out.print("Input year of experience: ");
                    int yoe = Integer.parseInt(input.nextLine());
                    System.out.print("Input pro skill: ");
                    String proskill = input.nextLine();
                    employees.put(ID, new Experience(ID, fullName, birthday, phone, email, 0, yoe, proskill));
                }
                case 1 -> {
                    System.out.print("Input graduation year: ");
                    int graduationYear = Integer.parseInt(input.nextLine());
                    System.out.print("Input graduation rank: ");
                    String graduationRank = input.nextLine();
                    System.out.print("Input education: ");
                    String education = input.nextLine();
                    employees.put(ID, new Fresher(ID, fullName, birthday, phone, email, 1, graduationYear, graduationRank, education));
                }
                case 2 -> {
                    System.out.print("Input majors: ");
                    String majors = input.nextLine();
                    System.out.print("Input semester: ");
                    int semester = Integer.parseInt(input.nextLine());
                    System.out.print("Input university name: ");
                    String university = input.nextLine();
                    employees.put(ID, new Intern(ID, fullName, birthday, phone, email, 2, majors, semester, university));
                }
            }
            employees.get(ID).addCertificates();
        } catch (EmployeeException | NumberFormatException e) {
            System.out.println("Please enter information again");
            addEmployee();
        }
    }

    public static void showSpecific() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input employee type: ");
        int k = Integer.parseInt(scanner.nextLine());
        employees.forEach((key, value) -> {
            if (value.getEmployeeType() == k) System.out.println(value);
        });
    }

    public static void writeObjectListToMap() {
        try {
            FileOutputStream file = new FileOutputStream("D:\\Users\\DucNM\\DH\\Code\\LTLT\\FsoftFresher\\JavaTest\\BasicExcercise\\src\\bai13expert\\data\\employeeList.txt");
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(employees);

            out.close();
            file.close();
            System.out.println("Write successful");
        } catch (IOException e) {
            System.out.println("IO Exception found!");
        }
    }

    public static void addEmployeeByFile() {
        try {
            FileInputStream file = new FileInputStream("D:\\Users\\DucNM\\DH\\Code\\LTLT\\FsoftFresher\\JavaTest\\BasicExcercise\\src\\bai13expert\\data\\baseEmployee.txt");
            ObjectInputStream in = new ObjectInputStream(file);

            Map<String, Employee> baseEmployee = (Map<String, Employee>) in.readObject();
            employees.putAll(baseEmployee);

            in.close();
            file.close();

            System.out.println("Add successful!");
        } catch (IOException e) {
            System.out.println("IO exception found!");
        } catch (Exception e) {
            System.out.println("Casting exception");
        }
    }

    public static void showAllEmployees() {
        employees.forEach((key, value) -> System.out.println(value));
    }

    public static void deleteEmployee() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input ID: ");
        String ID = sc.nextLine();
        if(employees.containsKey(ID))   employees.remove(ID);
        else System.out.println("ID not found");
    }

    public static void modifyEmployee() {
        Scanner input = new Scanner(System.in);
        System.out.print("Input ID: ");
        String ID = input.nextLine();
        if(employees.containsKey(ID)) {
            System.out.print("Input Full Name: ");
            String fullName = input.nextLine();
            if (!Validate.checkName(fullName)) throw new EmployeeException("Wrong name format");
            employees.get(ID).setFullName(fullName);

            System.out.print("Input birthday: ");
            String birthday = input.nextLine();
            if (!Validate.checkDate(birthday)) throw new EmployeeException("Wrong birthday format");
            employees.get(ID).setBirthDay(birthday);

            System.out.print("Input phone: ");
            String phone = input.nextLine();
            if (!Validate.checkPhone(phone)) throw new EmployeeException("Wrong phone format");
            employees.get(ID).setPhone(phone);

            System.out.print("Input email: ");
            String email = input.nextLine();
            if (!Validate.checkEmail(email)) throw new EmployeeException("Wrong email format");
            employees.get(ID).setEmail(email);
        }
        else System.out.println("ID not found");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("1. Add new employee\n2. Show all employee\n3. Write lists to files\n4. Retrieve from file\n" +
                "5. Show with filter\n6. Modify employee\n7. Delete employee\n9. Exit\nInput operation: ");
        int N = Integer.parseInt(sc.nextLine());
        while(N != 9) {
            switch (N) {
                case 1 -> addEmployee();
                case 2 -> showAllEmployees();
                case 3 -> writeObjectListToMap();
                case 4 -> addEmployeeByFile();
                case 5 -> showSpecific();
                case 6 -> modifyEmployee();
                case 7 -> deleteEmployee();
            }
            System.out.print("Input operation: ");
            N = sc.nextInt();
        }
    }
}
