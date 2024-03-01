package exercise;

import exercise.model.Address;
import exercise.annotation.Inspect;
import java.lang.reflect.Method;

public class Application {
    public static void main(String[] args) {
        var address = new Address("London", 12345678);

        // BEGIN
        inspectMethods(address);
        // END
    }


    public static void inspectMethods(Object obj) {
        Class<?> clazz = obj.getClass();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Inspect.class)) {
                String meth = method.getName();
                String type = method.getReturnType().getSimpleName();
                System.out.printf("Method %s returns a value of type %s%n", meth, type);
            }
        }
    }
}
