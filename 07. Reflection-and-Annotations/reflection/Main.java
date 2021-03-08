package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class reflection = Reflection.class;

        System.out.println(reflection);
        System.out.println(reflection.getSuperclass());

        Class[] interfaces = reflection.getInterfaces();
        for (Class anInterface : interfaces) {
            System.out.println(anInterface);
        }

        Object reflectionObject = reflection.getDeclaredConstructor().newInstance();

        System.out.println(reflectionObject);


    }
}