import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Class<Reflection> reflectionClass = Reflection.class;

        List<Method> getters = new ArrayList<>();
        List<Method> setters = new ArrayList<>();

        Method[] methods = reflectionClass.getDeclaredMethods();

        Field[] fields = reflectionClass.getDeclaredFields();

        for (Method method : methods) {
            if (checkIsSetter(method)) {
                setters.add(method);
            } else if (checkIsGetter(method)) {
                getters.add(method);
            }
        }

        Arrays.stream(fields)
                .filter(field -> !Modifier.isPrivate(field.getModifiers()))
                .sorted(Comparator.comparing(Field::getName))
                .forEach(field -> System.out.printf("%s must be private!%n",
                        field.getName()));

        getters
                .stream()
                .sorted(Comparator.comparing(Method::getName))
                .filter(getter -> !Modifier.isPublic(getter.getModifiers()))
                .forEach(getter -> System.out.printf("%s have to be public!%n",
                        getter.getName()));


        setters
                .stream()
                .sorted(Comparator.comparing(Method::getName))
                .filter(setter -> !Modifier.isPrivate(setter.getModifiers()))
                .forEach(setter -> System.out.printf("%s have to be private!%n",
                        setter.getName()));


    }

    private static boolean checkIsGetter(Method method) {
        return method.getName().startsWith("get") &&
                method.getReturnType() != void.class &&
                method.getParameterCount() == 0;
    }

    private static boolean checkIsSetter(Method method) {
        return method.getName().startsWith("set") &&
                method.getReturnType() == void.class &&
                method.getParameterCount() == 1;

    }
}
