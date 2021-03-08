package valid_person;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            String first = scanner.nextLine();
            String second = scanner.nextLine();
            int age = Integer.parseInt(scanner.nextLine());

            Person person = new Person(first, second, age);


        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}