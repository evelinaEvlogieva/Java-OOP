package car_shop;

public class Seat extends CarImpl implements Sellable{
    private String model;
    private String color;
    private Integer horsePower;
    private String countryProduced;
    private Double price;

    public Seat(String model, String color, Integer horsePower, String countryProduced, Double price) {
        super(model, color, horsePower, countryProduced);
        this.price = price;
    }

    @Override
    public Double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return String.format("This is %s produced in %s and have %d tires%n" +
                        "%s sells for %f",
                super.getModel(), super.countryProduced(), super.TIRES,
                this.getModel(), this.getPrice());
    }


}
