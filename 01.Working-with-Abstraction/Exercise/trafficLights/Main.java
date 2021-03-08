package trafficLights;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TrafficLight[] trafficLights = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(TrafficLight::valueOf)
                .toArray(TrafficLight[]::new);

        int n = Integer.parseInt(scanner.nextLine());

        TrafficLight[] lights = TrafficLight.values();

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < trafficLights.length; j++) {
                int index = (trafficLights[j].ordinal() + 1) % lights.length;
                trafficLights[j] = lights[index];
                builder.append(trafficLights[j].toString()).append(" ");
            }
            builder.append(System.lineSeparator());
        }

        System.out.println(builder);
    }
}
