package harvestingFields;


import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Field[] fields = RichSoilLand.class.getDeclaredFields();

        String input = scanner.nextLine();

        while (!"HARVEST".equals(input)) {
            for (Field field : fields) {
                String modifier = Modifier.toString(field.getModifiers());
                if ("all".equals(input)) {
					System.out.printf("%s %s %s%n",
							modifier, field.getType().getSimpleName(), field.getName() );
                } else {
                    if (modifier.equals(input)) {
                        System.out.printf("%s %s %s%n",
                                modifier, field.getType().getSimpleName(), field.getName() );
                    }
                }

            }


            input = scanner.nextLine();
        }

    }
}
