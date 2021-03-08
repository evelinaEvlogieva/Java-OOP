package studentSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StudentSystem studentSystem = new StudentSystem();

        String input = scanner.nextLine();

        while (!"Exit".equals(input)) {
            String[] data = input.split("\\s+");
            String command = data[0];
            String name = data[1];


            if ("Create".equals(command)) {
                int age = Integer.parseInt(data[2]);
                double grade = Double.parseDouble(data[3]);
                studentSystem.addStudent(name, age, grade);

            } else if ("Show".equals(command)) {
                studentSystem.print(name);

            }

            input = scanner.nextLine();
        }

        System.out.println();
    }
}
