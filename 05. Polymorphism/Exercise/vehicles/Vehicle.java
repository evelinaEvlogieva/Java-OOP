package vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle {
    private double fuelQuantity;
    private double consumption;
    private double tankCapacity;

    public Vehicle(double fuelQuantity, double consumption, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.consumption = consumption;
        this.tankCapacity = tankCapacity;
    }


    protected void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    public double getConsumption() {
        return consumption;
    }

    public void drive(double distance) {
        if (this.consumption * distance > this.fuelQuantity) {
            System.out.printf(" needs refueling%n");
        } else {
            System.out.printf(" travelled %s km%n",
                    new DecimalFormat("#.##").format(distance));
            this.fuelQuantity -= this.consumption * distance;
            if (this.fuelQuantity <= 0) {
                System.out.println("Fuel must be a positive number");
            }
        }

    }

    public void refuel(double litters) {
        if (litters <= 0) {
            System.out.println("Fuel must be a positive number");
        } else {
            if (this.fuelQuantity + litters > this.tankCapacity) {
                System.out.println("Cannot fit fuel in tank");
            } else {
                this.fuelQuantity += litters;
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%.2f", this.fuelQuantity);
    }
}
