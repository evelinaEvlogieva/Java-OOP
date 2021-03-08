package animal_farm;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    public double productPerDay() {
        return calculateProductPerDay();
    }

    private double calculateProductPerDay() {
        double producedEggs = 0;
        if (this.age >= 0 && this.age <= 5) {
            producedEggs = 2;
        } else if (this.age >= 6 && this.age <= 11) {
            producedEggs = 1;
        } else if (this.age > 11) {
            producedEggs = 0.75;
        }

        return producedEggs;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    private void setName(String name) {
        if (name.isEmpty() || name.equals(" ")) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    private void setAge(int age) {
        if (age < 0 || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    @Override
    public String toString() {
            return String.format("Chicken %s (age %d) can produce %.2f eggs per day.",
                    this.getName(), this.getAge(), this.productPerDay());
    }
}
