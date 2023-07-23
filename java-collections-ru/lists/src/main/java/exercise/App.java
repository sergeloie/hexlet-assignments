package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
public class App {

    public static boolean scrabble(String bunchOfLetters, String word) {

        boolean result = true;
        List<String> listOfLetters = new ArrayList<>(Arrays.asList(bunchOfLetters.split("")));
        List<String> preparedWord = new ArrayList<>(Arrays.asList(word.toLowerCase().split("")));
        for (String letter : preparedWord) {
            if (listOfLetters.contains(letter)) {
                listOfLetters.remove(letter);
            } else {
                result = false;
                break;
            }
        }
        return result;
    }
}
//END
