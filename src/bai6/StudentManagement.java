package bai6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManagement {
    private static List<Student> students = new ArrayList<>();

    public static void addStudent(){
        Scanner input = new Scanner(System.in);
        System.out.print("Input name: ");
        String name = input.nextLine();
        System.out.print("Input age: ");
        int age = Integer.parseInt(input.nextLine());
        if(age < 0) throw new StudentException("Age invalid");
        System.out.print("Input hometown: ");
        String hometown = input.nextLine();
        students.add(new Student(name, age, hometown));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Add new student\n2. Show student 20 yo\n3. Show student 23 yo and hometown is DN");
        int N = scanner.nextInt();
        while (N <= 3 && N >= 1) {
            if (N == 1) addStudent();
            else if (N == 2) students.stream()
                    .filter(s -> s.getAge() == 20)
                    .forEach(System.out::println);
            else students.stream()
                        .filter(s -> s.getAge() == 23 && s.getHometown().equals("DN"))
                        .forEach(System.out::println);
            N = scanner.nextInt();
        }
    }
}
