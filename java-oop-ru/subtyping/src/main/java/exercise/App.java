package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
public class App {

    public static void swapKeyValue(KeyValueStorage kvs) {

        Map<String, String> map = kvs.toMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            kvs.set(entry.getValue(), entry.getKey());
            kvs.unset(entry.getKey());
        }

    }
}
// END
