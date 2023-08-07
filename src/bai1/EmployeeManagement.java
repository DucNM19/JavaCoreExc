package bai1;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeManagement {
    private static List<Employee> employees = new ArrayList<>();

    public static void addNewEmployees(int K) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input name: ");
        String name = scanner.nextLine();
        System.out.print("Input age: ");
        short age = Short.parseShort(scanner.nextLine());
        if(age <= 0) throw new EmployeeException("Invalid age, must be > 0");
        System.out.print("Input gender: ");
        String gender = scanner.nextLine();
        System.out.print("Input address: ");
        String address = scanner.nextLine();
        if (K == 1) {
            System.out.print("Input worker level: ");
            short H = Short.parseShort(scanner.nextLine());
            if(H < 0 || H > 10) throw new EmployeeException("Invalid level, must be between 1 - 10");
            Worker worker = new Worker(name, age, gender, address, H);
            employees.add(worker);
        } else if (K == 2) {
            System.out.print("Input engineer major: ");
            String major = scanner.nextLine();
            Engineer engineer = new Engineer(name, age, gender, address, major);
            employees.add(engineer);
        } else if (K == 3) {
            System.out.println("Input staff work: ");
            String work = scanner.nextLine();
            Staff staff = new Staff(name, age, gender, address, work);
            employees.add(staff);
        }
        scanner.close();
    }


    public static void main(String[] args) {
        int N;
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Create new employee\n2. Find employee by name\n3. Show employee list\n4. Exit");
        N = Integer.parseInt(scanner.nextLine());
        while (N <= 3 && N >= 1) {
            if (N == 1) {
                System.out.println("1 Worker, 2 Engineer, 3 Staff");
                addNewEmployees(scanner.nextInt());
            } else if (N == 2) {
                System.out.print("Input employee name: ");
                Scanner findName = new Scanner(System.in);
                String givenName = findName.nextLine();
                employees.stream()
                        .filter(employee -> employee.getName().equals(givenName))
                        .forEach(System.out::println);
                findName.close();
            } else {
                employees.forEach(System.out::println);
            }
            N = scanner.nextInt();
        }
    }
}
