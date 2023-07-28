package exercise;

import java.util.*;
import java.util.Map.Entry;

// BEGIN
class App {
    public static void main(String[] args) {
        Map<String, String> where = new HashMap<>(Map.of("author", "Shakespeare", "year", "1611"));

        List<Map<String, String>> books = new ArrayList<>();
        List<Map<String, String>> result = App.findWhere(books, where);

        System.out.println(result);


    }

    public static List<Map<String, String>> findWhere(List<Map<String, String>> library, Map<String, String> libCard) {
        List<Map<String, String>> result = new ArrayList<>();
//        Map<String, String> book1 = new HashMap<>(
//                Map.of("title", "Cymbeline", "author", "Shakespeare", "year", "1611")
//        );
//        List<Map<String, String>> books = new ArrayList<>();
//        System.out.println(book1);
//        System.out.println(books);
//        return books;

        for (Iterator<Map<String, String>> iterator = library.iterator(); iterator.hasNext(); ) {
            Map<String, String> book = iterator.next();

        }


    }

    public static boolean isMapContainsSubmap (Map<String, String> map, Map<String, String> submap) {
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
