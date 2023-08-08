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

            if (employees.containsKey(ID)) {
                System.out.println("ID already exist");
                addEmployee();
            }

            String[] types = new String[5];
            String[] inputNames = {"Full Name", "birthday", "phone", "email"};

            for (int i = 0; i < 4; i++) {
                System.out.print("Input " + inputNames[i] + ": ");

                do {
                    types[i] = input.nextLine();

                    if (!Validate.checkGeneral(types[i], i)) {
                        System.out.println("Wrong " + inputNames[i] + " format, please enter again!");
                        //throw is only use for debugging.
                        //throw new EmployeeException("Wrong " + inputNames[i] + " format, please enter again!");
                    }
                } while (!Validate.checkGeneral(types[i], i));
            }

            System.out.print("Input employee type(0 Experience, 1 Fresher, 2 Intern): ");
            int employeeType = Integer.parseInt(input.nextLine());

            do {
                switch (employeeType) {
                    case 0 -> {
                        System.out.print("Input year of experience: ");
                        int yoe = Integer.parseInt(input.nextLine());
                        System.out.print("Input pro skill: ");
                        String proskill = input.nextLine();
                        employees.put(ID, new Experience(ID, types[0], types[1], types[2], types[3],
                                0, yoe, proskill));
                    }
                    case 1 -> {
                        System.out.print("Input graduation year: ");
                        int graduationYear = Integer.parseInt(input.nextLine());
                        System.out.print("Input graduation rank: ");
                        String graduationRank = input.nextLine();
                        System.out.print("Input education: ");
                        String education = input.nextLine();
                        employees.put(ID, new Fresher(ID, types[0], types[1], types[2], types[3],
                                1, graduationYear, graduationRank, education));
                    }
                    case 2 -> {
                        System.out.print("Input majors: ");
                        String majors = input.nextLine();
                        System.out.print("Input semester: ");
                        int semester = Integer.parseInt(input.nextLine());
                        System.out.print("Input university name: ");
                        String university = input.nextLine();
                        employees.put(ID, new Intern(ID, types[0], types[1], types[2], types[3],
                                2, majors, semester, university));
                    }
                }

                if(employeeType < 0 || employeeType > 3) {
                    System.out.print("Not a valid number, please input again(0 to 2): ");
                    employeeType = Integer.parseInt(input.nextLine());
                }

                employees.get(ID).addCertificates();
            } while(employeeType < 0 || employeeType > 3);
        } catch (EmployeeException | NumberFormatException e) {
            System.out.println(e);
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
            FileOutputStream file = new FileOutputStream("src/bai13expert/data/baseEmployee.txt");
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(employees);

            out.close();
            file.flush();
            file.close();
            System.out.println("Write successful");
        } catch (IOException e) {
            System.out.println("IO Exception found!");
        }
    }

    public static void printEmployeeFromFile() {
        try {
            FileInputStream file = new FileInputStream("src/bai13expert/data/baseEmployee.txt");
            ObjectInputStream in = new ObjectInputStream(file);

            Map<String, Employee> baseEmployee = (Map<String, Employee>) in.readObject();

            baseEmployee.forEach((key, value) -> System.out.println(value));

            in.close();
            file.close();

        } catch (EOFException e) {
            System.out.println("File empty!");
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
                case 4 -> printEmployeeFromFile();
                case 5 -> showSpecific();
                case 6 -> modifyEmployee();
                case 7 -> deleteEmployee();
            }
            System.out.print("Input operation: ");
            N = sc.nextInt();
        }
    }
}
