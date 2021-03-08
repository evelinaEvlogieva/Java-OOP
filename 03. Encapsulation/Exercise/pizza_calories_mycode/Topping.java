package pizza_calories_mycode;

public class Topping {
    private  String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        if (!toppingType.equalsIgnoreCase("Meat")
                && !toppingType.equalsIgnoreCase("Veggies")
                && !toppingType.equalsIgnoreCase("Cheese")
                && !toppingType.equalsIgnoreCase("Sauce")){
            throw new IllegalArgumentException(String.format
            ("Cannot place %s on top of your pizza.", toppingType));
        }
        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50){
            throw new IllegalArgumentException(String.format
                    ("%s weight should be in the range [1..50]."
                            , this.toppingType));
        }
        this.weight = weight;
    }

    public String getToppingType() {
        return toppingType;
    }

    public double getWeight() {
        return weight;
    }

    public double calculateCalories (){

        double calories = 2 * weight;

        switch (toppingType){
            case "Meat":
                calories *= 1.2;
                break;
            case "Veggies":
                calories *= 0.8;
                break;
            case "Cheese":
                calories *= 1.1;
                break;
            case "Sauce":
                calories *= 0.9;
                break;
        }

        return calories;
    }
}
