package exercise;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// BEGIN
class App {

    public static List<Map<String, String>> findWhere(List<Map<String, String>> library, Map<String, String> libCard) {
        List<Map<String, String>> result = new ArrayList<>();

        for (Iterator<Map<String, String>> iterator = library.iterator(); iterator.hasNext();) {
            Map<String, String> book = iterator.next();
            if (isMapContainsSubmap(book, libCard)) {
                result.add(book);
            }
        }
        return result;
    }

    public static boolean isMapContainsSubmap(Map<String, String> map, Map<String, String> submap) {
        boolean result = true;

        for (String key : submap.keySet()) {
            if (!submap.get(key).equals(map.get(key))) {
                result = false;
                break;
            }
        }
        return result;
    }
}
//END
