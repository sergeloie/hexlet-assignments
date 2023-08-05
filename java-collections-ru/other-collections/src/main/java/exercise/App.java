package exercise;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

// BEGIN
public class App {

    public static LinkedHashMap<String, String> genDiff(Map<String, ?> map1, Map<String, ?> map2) {
        LinkedHashMap<String, String> result = new LinkedHashMap<>();
        Set<String> setOfKeys = new HashSet<>(map1.size() + map2.size(), 1.0f);
        setOfKeys.addAll(map1.keySet());
        setOfKeys.addAll(map2.keySet());
        for (String key : setOfKeys) {
            if (!map1.containsKey(key) & map2.containsKey(key)) {
                result.put(key, "added");
            }
            if (map1.containsKey(key) & !map2.containsKey(key)) {
                result.put(key, "deleted");
            }
            if (map1.containsKey(key) & map2.containsKey(key)) {
                if (map1.get(key).equals(map2.get(key))) {
                    result.put(key, "unchanged");
                } else {
                    result.put(key, "changed");
                }
            }
        }

        return result;
    }
}
//END
