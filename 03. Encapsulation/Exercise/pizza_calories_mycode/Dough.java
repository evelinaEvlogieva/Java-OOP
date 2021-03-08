package pizza_calories_mycode;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    private void setFlourType(String flourType) {
        if (!flourType.equalsIgnoreCase("White")
                && !flourType.equalsIgnoreCase("Wholegrain")) {
            throw new IllegalArgumentException("Invalid type of dough.");

        }
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (!bakingTechnique.equalsIgnoreCase("Crispy")
                && !bakingTechnique.equalsIgnoreCase("Chewy")
                && !bakingTechnique.equalsIgnoreCase("Homemade")) {
            throw new IllegalArgumentException("Invalid type of dough.");

        }
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200){
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");

        }
        this.weight = weight;
    }

    public String getFlourType() {
        return flourType;
    }

    public String getBakingTechnique() {
        return bakingTechnique;
    }

    public double getWeight() {
        return weight;
    }

    public double calculateCalories() {
        double calories = 2 * this.weight;

        switch (this.flourType){
            case "White":
                calories *= 1.5;
                break;
            case "Wholegrain":
                calories *= 1.0;
                break;
        }

        switch (this.bakingTechnique){
            case "Crispy":
                calories *= 0.9;
                break;
            case "Chewy":
                calories *= 1.1;
                break;
            case "Homemade":
                calories *= 1.0;
                break;
        }

        return calories;
    }
}
