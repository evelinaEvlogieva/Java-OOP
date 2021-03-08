package vehicles;

import org.w3c.dom.ls.LSOutput;

public class Car extends Vehicle {
    protected Car(double fuelQuantity, double consumption, double tankCapacity) {
        super(fuelQuantity, consumption + 0.9, tankCapacity);
    }

    @Override
    public void drive (double distance) {
        System.out.print("Car");
        super.drive(distance);
    }

    @Override
    public String toString() {
        return "Car: " + super.toString();
    }
}
