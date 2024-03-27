package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
public class Validator {

    public static List<String> validate(Address address) {
        List<String> result = new ArrayList<>();
        Field[] fields = address.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(NotNull.class)) {
                try {
                    Object value = field.get(address);
                    if (value == null) {
                        result.add(field.getName());
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return result;
    }

    public static Map<String, List<String>> advancedValidate(Address address) {
        Map<String, List<String>> result = new HashMap<>();
        Field[] fields = address.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            List<String> list = new ArrayList<>();
            if (field.isAnnotationPresent(NotNull.class)) {
                try {
                    Object value = field.get(address);
                    if (value == null) {
                        list.add("can not be null");
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
            if (field.isAnnotationPresent(MinLength.class)) {
                MinLength sizeAnnotation = field.getAnnotation(MinLength.class);
                try {
                    Object value = field.get(address);
                    if (value != null && value instanceof String) {
                        int length = ((String) value).length();
                        if (length < sizeAnnotation.minLength()) {
                            list.add("length less than 4");
                        }
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
            if (!list.isEmpty()) {result.put(field.getName(), list);}
        }
        return result;
    }
}
// END
