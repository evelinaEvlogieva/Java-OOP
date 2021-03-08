package need_for_speed;

public class Vehicle {
     private static final double DEFAULT_FUEL_CONSUMPTION = 1.25;
     private double fuelConsumption;
     private double fuel;
     private int horsePower;

     public Vehicle(double fuel, int horsePower){
         this.fuel = fuel;
         this.horsePower = horsePower;
         this.fuelConsumption = DEFAULT_FUEL_CONSUMPTION;
     }


    public int getHorsePower() {
        return horsePower;
    }

    public double getFuel() {
        return fuel;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public void drive (double kilometers){
         double neededFuel = this.fuelConsumption * kilometers;
         if (hasEnoughFuel(neededFuel)){
                this.fuel -= neededFuel;
         }
    }

    private boolean hasEnoughFuel(double neededFuel) {
         return this.fuel >= neededFuel;
    }
}
