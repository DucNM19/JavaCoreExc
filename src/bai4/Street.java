package bai4;

import java.util.*;

public class Street {
    private static List<Family> families = new ArrayList<>();
    private static Set<String> peopleID = new HashSet<>();

    public static Set<String> getPeopleID() {
        return peopleID;
    }

    public static void addFamily(){
        System.out.print("Input number of people: ");
        Scanner input = new Scanner(System.in);
        int K = Integer.parseInt(input.nextLine());
        System.out.print("Input address no: ");
        int H = Integer.parseInt(input.nextLine());
        families.add(new Family(K, H));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of families: ");
        int N = Integer.parseInt(scanner.nextLine());
        for(int i = 0; i < N; i++)  addFamily();
        families.forEach(System.out::print);
    }
}
