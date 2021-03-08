package border_control;

import javax.security.auth.login.AccountExpiredException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Identifiable> list = new ArrayList<>();

        while (!"End".equals(input)){
            String[] data = input.split("\\s+");
            if (data.length == 2){
                Identifiable robot = new Robot(data[0], data[1]);
                list.add(robot);
            } else {
                Identifiable citizen = new Citizen(data[0], Integer.parseInt(data[1]), data[2]);
                list.add(citizen);

            }

            input = scanner.nextLine();
        }

        String idEnd = scanner.nextLine();

        for (Identifiable object : list) {
            if (object.getId().endsWith(idEnd)){
                System.out.println(object.getId());
            }
        }

    }
}
