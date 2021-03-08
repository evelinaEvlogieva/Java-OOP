package wild_farm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Animal animal = null;

        List<Animal> animals = new ArrayList<>();

        while (!input.equals("End")) {
            String[] data = input.split("\\s+");
                String animalType = data[0];
                String animalName = data[1];
                double animalWeight = Double.parseDouble(data[2]);
                String animalLivingRegion = data[3];

                switch (animalType) {
                    case "Cat":
                        String breed = data[4];
                        animal = new Cat(animalName, animalType, animalWeight, animalLivingRegion, breed);
                        break;
                    case "Tiger":
                        animal = new Tiger(animalName, animalType, animalWeight, animalLivingRegion);
                        break;
                    case "Zebra":
                        animal = new Zebra(animalName, animalType, animalWeight, animalLivingRegion);
                        break;
                    case "Mouse":
                        animal = new Mouse(animalName, animalType, animalWeight, animalLivingRegion);
                        break;
                }

                animals.add(animal);

                data = scanner.nextLine().split("\\s+");
                String foodType = data[0];
                int foodQuantity = Integer.parseInt(data[1]);

                Food food = null;

                if (foodType.equals("Meat")) {
                    food = new Meat(foodQuantity);
                } else if (foodType.equals("Vegetable")) {
                    food = new Vegetable(foodQuantity);
                }

                animals.get(animals.size() - 1).makeSound();

                animal.eat(food);


            input = scanner.nextLine();

        }

        animals.forEach(System.out::println);
    }
}
