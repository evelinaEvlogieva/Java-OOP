package vehicles;

public class Bus extends Vehicle {
    private boolean isEmpty;

    public Bus(double fuelQuantity, double consumption, double tankCapacity) {
        super(fuelQuantity, consumption, tankCapacity);
        this.isEmpty = false;
    }


    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    @Override
    public void drive(double distance) {
        System.out.print("Bus");
        if (this.isEmpty) {
            super.drive(distance);
            this.isEmpty = false;
        } else {
            super.setConsumption(super.getConsumption() + 1.4);
            super.drive(distance);
        }
    }

    @Override
    public String toString() {
        return "Bus: " + super.toString();
    }
}
