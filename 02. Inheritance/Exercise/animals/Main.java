package animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Animal> animals = new ArrayList<>();

        while (!"Beast!".equals(input)) {

            String[] data = scanner.nextLine().split("\\s+");

            Animal animal;

            try {
                if (input.equals("Dog")) {
                    animal = new Dog(data[0], Integer.parseInt(data[1]), data[2]);
                } else if (input.equals("Cat")) {
                    animal = new Cat(data[0], Integer.parseInt(data[1]), data[2]);
                } else if (input.equals("Frog")) {
                    animal = new Frog(data[0], Integer.parseInt(data[1]), data[2]);
                } else if (input.equals("Kittens")) {
                    animal = new Kitten(data[0], Integer.parseInt(data[1]));
                } else {
                    animal = new Tomcat(data[0], Integer.parseInt(data[1]));
                }

                animals.add(animal);

            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }

            input = scanner.nextLine();
        }

        for (Animal animal : animals) {
            System.out.println(animal.toString());
        }
    }
}
