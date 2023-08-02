package exercise;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// BEGIN
public class Sorter {

    public static List<String> takeOldestMans(List<Map<String, String>> listPeople) {
        return listPeople.stream()
                .filter(map -> map.get("gender").equals("male"))
                .sorted(Comparator.comparing(map -> map.get("birthday")))
                .map(map -> map.get("name"))
                .collect(Collectors.toList());
    }
}
// END
