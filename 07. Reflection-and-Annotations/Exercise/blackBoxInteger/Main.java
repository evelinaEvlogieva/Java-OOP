package blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException,
            NoSuchFieldException {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Constructor<BlackBoxInt> constructor = BlackBoxInt.class.getDeclaredConstructor();

        constructor.setAccessible(true);

        BlackBoxInt box = (BlackBoxInt) constructor.newInstance();

        Field innerValue = box.getClass().getDeclaredField("innerValue");

        innerValue.setAccessible(true);

        Method[] declaredMethods = box.getClass().getDeclaredMethods();

        while (!"END".equals(input)) {
            String[] data = input.split("_");
            String command = data[0];
            int value = Integer.parseInt(data[1]);
            for (Method method : declaredMethods) {
                    String methodName = method.getName();
                if (methodName.equals(command)) {
                    method.setAccessible(true);
                    method.invoke(box, value);
                    System.out.println(innerValue.get(box));
                }
            }

            input = scanner.nextLine();
        }

    }
}
