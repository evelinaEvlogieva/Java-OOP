package vehicles;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carData = scanner.nextLine().split("\\s+");
        String[] truckData = scanner.nextLine().split("\\s+");
        String[] busData = scanner.nextLine().split("\\s+");

        Vehicle car = new Car(Double.parseDouble(carData[1]),
                Double.parseDouble(carData[2]), Double.parseDouble(carData[3]));
        Vehicle truck = new Truck(Double.parseDouble(truckData[1]),
                Double.parseDouble(truckData[2]), Double.parseDouble(truckData[3]));
        Vehicle bus = new Bus(Double.parseDouble(busData[1]),
                Double.parseDouble(busData[2]), Double.parseDouble(busData[3]));

        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(car);
        vehicles.add(truck);
        vehicles.add(bus);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String command = input[0];
            String vehicle = input[1];

            if ("Drive".equals(command)) {
                double distance = Double.parseDouble(input[2]);
                if ("Car".equals(vehicle)) {
                    car.drive(distance);
                } else if ("Truck".equals(vehicle)) {
                    truck.drive(distance);
                } else if ("Bus".equals(vehicle)) {
                    bus.drive(distance);
                }

            } else if ("Refuel".equals(command)) {
                double litters = Double.parseDouble(input[2]);
                if ("Car".equals(vehicle)) {
                    car.refuel(litters);
                } else if ("Truck".equals(vehicle)) {
                    truck.refuel(litters);
                } else if ("Bus".equals(vehicle)) {
                    bus.refuel(litters);
                }
            } else if ("DriveEmpty".equals(command)){
                double distance = Double.parseDouble(input[2]);
                ((Bus) bus).setEmpty(true);
                bus.drive(distance);
            }

        }

        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.toString());
        }

    }
}
