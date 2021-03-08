package pizza_calories_mycode;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;
    private int numberOfToppings;

    public Pizza(String name, int numberOfToppings) {
        setName(name);
        setToppings(numberOfToppings);
        this.toppings = new ArrayList<>(this.numberOfToppings);
    }

    public String getName() {
        return name;
    }

    public Dough getDough() {
        return dough;
    }

    public List<Topping> getToppings() {
        return toppings;
    }


    private void setName(String name) {
        if (name.trim().isEmpty() || name.equals(" ")
                || name.length() > 15){
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    private void setToppings(int numberOfToppings) {
        if (numberOfToppings < 0 || numberOfToppings > 10){
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");

        }
        this.toppings = new ArrayList<>();
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }



    public void addTopping (Topping topping){
//        if (toppings.size() < 10){
            toppings.add(topping);
//        }

    }

    public double getOverallCalories (){
        double sumCallories = 0;
        for (Topping topping : toppings) {
            sumCallories += topping.calculateCalories();
        }

        return sumCallories + dough.calculateCalories();
    }

    @Override
    public String toString() {
        return String.format("%s - %.2f",
                this.name, getOverallCalories());
    }
}
