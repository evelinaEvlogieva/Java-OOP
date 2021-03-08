package wild_farm;

import java.security.PublicKey;

public abstract class Animal {
    private String animalType;
    private String animalName;
    private Double animalWeight;
    private Integer foodEaten;

    protected Animal(String animalName, String animalType, Double animalWeight) {
        this.animalType = animalType;
        this.animalName = animalName;
        this.animalWeight = animalWeight;
        this.foodEaten = 0;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public void setAnimalWeight(Double animalWeight) {
        this.animalWeight = animalWeight;
    }

    public void setFoodEaten(Integer foodEaten) {
        this.foodEaten = foodEaten;
    }

    public String getAnimalType() {
        return animalType;
    }

    public String getAnimalName() {
        return animalName;
    }

    public Double getAnimalWeight() {
        return animalWeight;
    }

    public Integer getFoodEaten() {
        return foodEaten;
    }


    public abstract void makeSound();

    public abstract void eat(Food food);

}
