package exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static exercise.Sorter.takeOldestMans;

// BEGIN
public class App {
    public static String[][] enlargeArrayImage(String[][] sourceMatrix) {
        int y = sourceMatrix.length;
        if (y == 0) {
            return new String[0][];
        }
        int x = sourceMatrix[0].length;
        String[][] matrix = new String[y * 2][x * 2];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                matrix[i * 2][j * 2] = sourceMatrix[i][j];
                matrix[i * 2 + 1][j * 2] = sourceMatrix[i][j];
                matrix[i * 2][j * 2 + 1] = sourceMatrix[i][j];
                matrix[i * 2 + 1][j * 2 + 1] = sourceMatrix[i][j];
            }
        }
        return matrix;
    }
}
// END
