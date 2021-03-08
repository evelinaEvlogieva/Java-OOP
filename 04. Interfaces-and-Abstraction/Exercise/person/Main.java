package person;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Buyer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            if (data.length == 4){
                list.add(new Citizen(data[0], Integer.parseInt(data[1]), data[2], data[3]));
            } else {
             list.add(new Rebel(data[0],Integer.parseInt(data[1]), data[2]));
            }
        }

        String input = scanner.nextLine();

        int totalAmountFood = 0;

        while (!"End".equals(input)){

            for (Buyer person : list) {
                if (person.getName().equals(input)){
                    person.buyFood();
                }
            }

            input = scanner.nextLine();
        }

        for (Buyer buyer : list) {
            totalAmountFood += buyer.getFood();
        }

        System.out.println(totalAmountFood);

        //Трета задача:
//        String input = scanner.nextLine();
//
//        List<Birthable> list = new ArrayList<>();
//
//        while (!"End".equals(input)) {
//            String[] data = input.split("\\s+");
//            String object = data[0];
//            if (object.equals("Citizen")) {
//                list.add(new Citizen(data[1], Integer.parseInt(data[2]), data[3], data[4]));
//
//            } else if (object.equals("Pet")) {
//                list.add(new Pet(data[1], data[2]));
//            }
//
//            input = scanner.nextLine();
//        }
//
//        input = scanner.nextLine();
//
//        for (Birthable object : list) {
//            if (object.getBirthDate().contains(input)){
//                System.out.println(object.getBirthDate());
//            }
//        }

        // Първа и втора задача:
//        Class[] citizenInterfaces = Citizen.class.getInterfaces();
//        if (Arrays.asList(citizenInterfaces).contains(Birthable.class)
//                && Arrays.asList(citizenInterfaces).contains(Identifiable.class)) {
//            Method[] methods = Birthable.class.getDeclaredMethods();
//            methods = Identifiable.class.getDeclaredMethods();
//            Scanner scanner = new Scanner(System.in);
//            String name = scanner.nextLine();
//            int age = Integer.parseInt(scanner.nextLine());
//            String id = scanner.nextLine();
//            String birthDate = scanner.nextLine();
//            Identifiable identifiable = new Citizen(name,age,id,birthDate);
//            Birthable birthable = new Citizen(name,age,id,birthDate);
//            System.out.println(methods.length);
//            System.out.println(methods[0].getReturnType().getSimpleName());
//            System.out.println(methods.length);
//            System.out.println(methods[0].getReturnType().getSimpleName());
//        }
    }

}
