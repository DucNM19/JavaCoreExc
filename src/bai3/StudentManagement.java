package bai3;

import java.util.*;

public class StudentManagement {
    private static List<Student> students = new ArrayList<>();
    private static Set<String> studentID = new HashSet<>();

    public static void addNewStudent(){
        Scanner input = new Scanner(System.in);
        System.out.print("Input id: ");

        String id = input.nextLine();
        if(studentID.contains(id)) throw new StudentException("ID already created, must be unique");
        studentID.add(id);

        System.out.print("Input name: ");
        String name = input.nextLine();
        System.out.print("Input address: ");
        String address = input.nextLine();
        System.out.print("Input priority: ");
        int priority = Integer.parseInt(input.nextLine());
        System.out.print("Input major: ");
        char major = input.nextLine().charAt(0);
        students.add(new Student(id, name, address, priority, major));

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Add new student\n2. Show student list\n3. Find using id");
        int N = scanner.nextInt();
        while(N <= 3 && N >= 1){
            if(N == 1){
                addNewStudent();
            } else if (N == 2){
                students.forEach(System.out::println);
            } else {
                Scanner idInput = new Scanner(System.in);
                String id = idInput.nextLine();
                students.stream()
                        .filter(s -> s.getId().equals(id))
                        .forEach(System.out::println);
            }
            N = scanner.nextInt();
        }
        scanner.close();
    }
}
