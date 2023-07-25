package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class App {

    public static Map getWordCount(String sentence) {
        Map<String, Integer> wordsCount = new HashMap<>();
        if (sentence.equals("")) {
            return wordsCount;
        }
        String[] wordsArray = sentence.split(" ");
        for (String word: wordsArray) {
            if (wordsCount.containsKey(word)) {
                wordsCount.replace(word, wordsCount.get(word) + 1);
            } else {
                wordsCount.put(word, 1);
            }
        }
        return wordsCount;
    }

    public static String toString(Map<String, Integer> mapToPrint) {
        if (mapToPrint.size() == 0) {
            return "{}";
        }
        String stringToPrint = "{\n";
        for (Map.Entry<String, Integer> entry: mapToPrint.entrySet()) {
            stringToPrint += "  ";
            stringToPrint += entry.getKey();
            stringToPrint += ": ";
            stringToPrint += entry.getValue() + "\n";
        }
        stringToPrint += "}";
        return stringToPrint;
    }
}
//END
