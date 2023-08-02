package exercise;

import org.junit.jupiter.api.Test;
//import java.util.Arrays;
//import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

// BEGIN
class AppTest {

    @Test
    void testMatrix2() {
        String[][] test = {
                {" ", "*"},
                {"*", " "},
        };

        String[][] image = {
                {" ", " ", "*", "*"},
                {" ", " ", "*", "*"},
                {"*", "*", " ", " "},
                {"*", "*", " ", " "},
        };

        String[][] actual = App.enlargeArrayImage(test);
        assertThat(actual).isEqualTo(image);
    }


    @Test
    void testMatrix1() {
        String[][] test = {
                {" "},
        };

        String[][] image = {
                {" ", " "},
                {" ", " "},
        };

        String[][] actual = App.enlargeArrayImage(test);
        assertThat(actual).isEqualTo(image);

    }

    @Test
    void testZero() {
        String[][] test = {};

        String[][] image = {};

        String[][] actual = App.enlargeArrayImage(test);
        assertThat(actual).isEqualTo(image);
    }
}
// END
