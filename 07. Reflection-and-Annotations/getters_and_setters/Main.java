package getters_and_setters;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Class<Reflection> reflectionClass = Reflection.class;

        Method[] methods = reflectionClass.getDeclaredMethods();

        List<Method> setters = new ArrayList<>();
        List<Method> getters = new ArrayList<>();

        for (Method method : methods) {
            if(checkIsSetter(method)) {
                setters.add(method);
            }
            if(checkIsGetter(method)) {
                getters.add(method);
            }
        }

        getters
                .stream()
                .sorted(Comparator.comparing(Method::getName))
                .forEach(getter -> System.out.println(formatGetter(getter)));


        setters
                .stream()
                .sorted(Comparator.comparing(Method::getName))
                .forEach(setter -> System.out.println(formatSetter(setter)));

    }

    private static boolean checkIsSetter(Method method) {
        return method.getName().startsWith("set") &&
                method.getReturnType() == void.class &&
                method.getParameterCount() == 1;

    }

    private static boolean checkIsGetter(Method method) {
        return  method.getName().startsWith("get") &&
                method.getReturnType() != void.class &&
                method.getParameterCount() == 0;
    }

    private static String formatGetter(Method getter) {
        return String.format("%s will return class %s",
                getter.getName(), getter.getReturnType().getName());
    }

    private static String formatSetter(Method setter) {
        return String.format("%s and will set field of class %s",
                setter.getName(), setter.getParameterTypes()[0].getName());
    }
}