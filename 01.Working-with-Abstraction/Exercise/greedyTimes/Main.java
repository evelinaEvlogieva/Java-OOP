package greedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long bagCapacity = Long.parseLong(scanner.nextLine());

        String[] itemsAndQuantities = scanner.nextLine().split("\\s+");

        Map<String, LinkedHashMap<String, Long>> bag = new LinkedHashMap<>();

        long gold = 0;
        long gem = 0;
        long cash = 0;

        for (int i = 0; i < itemsAndQuantities.length; i += 2) {
            String item = itemsAndQuantities[i];
            long quantity = Long.parseLong(itemsAndQuantities[i + 1]);

            String itemName = "";

            if (item.length() == 3) {
                itemName = "Cash";
            } else if (item.toLowerCase().endsWith("gem")) {
                itemName = "Gem";
            } else if (item.toLowerCase().equals("gold")) {
                itemName = "Gold";
            }

            if (itemName.equals("")) {
                continue;
            } else if (bagCapacity < bag.values().stream().
                    map(Map::values).flatMap(Collection::stream)
                    .mapToLong(e -> e).sum() + quantity) {
                continue;
            }

            switch (itemName) {
                case "Gem":
                    if (!bag.containsKey(itemName)) {
                        if (bag.containsKey("Gold")) {
                            if (quantity > bag.get("Gold").values().stream()
                                    .mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bag.get(itemName).values().stream()
                            .mapToLong(e -> e).sum()
                            + quantity > bag.get("Gold").values().stream().
                            mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
                case "Cash":
                    if (!bag.containsKey(itemName)) {
                        if (bag.containsKey("Gem")) {
                            if (quantity > bag.get("Gold").values().stream()
                                    .mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bag.get(itemName).values().stream()
                            .mapToLong(e -> e).sum()
                            + quantity > bag.get("Gem").values().stream()
                            .mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
            }

            if (!bag.containsKey(itemName)) {
                bag.put((itemName), new LinkedHashMap<>());
            }

            if (!bag.get(itemName).containsKey(item)) {
                bag.get(itemName).put(item, 0L);
            }

            bag.get(itemName).put(item, bag.get(itemName).get(item) + quantity);

            if (itemName.equals("Gold")) {
                gold += quantity;
            } else if (itemName.equals("Gem")) {
                gem += quantity;
            } else if (itemName.equals("Cash")) {
                cash += quantity;
            }
        }

        for (Map.Entry<String, LinkedHashMap<String, Long>> entry : bag.entrySet()) {
            Long sumValues = entry.getValue().values().stream().mapToLong(l -> l).sum();

            System.out.println(String.format("<%s> $%s", entry.getKey(), sumValues));

            entry.getValue().entrySet().stream()
                    .sorted((e1, e2) -> e2.getKey()
                            .compareTo(e1.getKey()))
                    .forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));

        }
    }

}
