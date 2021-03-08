package shopping_spree;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person (String name, double money){
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public double getMoney() {
        return money;
    }

    public List<Product> getProducts() {
        return products;
    }

    private void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void buyProduct (Product product){
        double cost = product.getCost();
        if (this.money >= cost){
            this.money -= cost;
            this.products.add(product);
        } else {
            throw new IllegalStateException(String.format("%s can't afford %s",
                    this.getName(), product.getName()));
        }

    }

    @Override
    public String toString() {
        String output = "Nothing bought";
        if (!this.products.isEmpty()){
            output = this.products.stream()
                    .map(Product::getName)
                    .collect(Collectors.joining(", "));
        }

        return this.getName() + " - " + output;
    }
}
