package pizza_calories;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;
    private static final String INVALID_MESSAGE = "Invalid type of dough.";

    public Dough(String flourType, String backingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(backingTechnique);
        this.setWeight(weight);
    }

    private boolean isDoughValid(String type) {
        DoughModifiers[] modifiers = DoughModifiers.values();
        for (DoughModifiers modifier : modifiers) {
            if (modifier.name().equalsIgnoreCase(type)) {
                return true;
            }
        }
        return false;
    }

    private String getFlourType() {
        return flourType;
    }

    private void setFlourType(String flourType) {
        if (!isDoughValid(flourType)) {
            throw new IllegalArgumentException(INVALID_MESSAGE);
        }
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (!isDoughValid(bakingTechnique)) {
            throw new IllegalArgumentException(INVALID_MESSAGE);
        }
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException(
                    "Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        return (2 * weight) *
                DoughModifiers.valueOf(flourType).getCal() *
                DoughModifiers.valueOf(bakingTechnique).getCal();
    }
}
