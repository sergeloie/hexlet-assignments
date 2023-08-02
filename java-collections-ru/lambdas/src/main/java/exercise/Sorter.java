package exercise;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// BEGIN
public class Sorter {

    public static List<String> takeOldestMans(List<Map<String, String>> listPeople) {
        List<String> result = listPeople.stream()
                .filter(map -> map.get("gender").equals("male"))
                .sorted((map1, map2) -> map1.get("birthday").compareTo(map2.get("birthday")))
                .map(map -> map.get("name"))
                .collect(Collectors.toList());
        return result;
    }
}
// END
