package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppTest {
    // BEGIN

    private int n;
    List<Integer> testList = new ArrayList<>();


    @BeforeEach
    void prepareTest() {
        testList.add(0);
        testList.add(1);
        testList.add(2);
        testList.add(3);
        testList.add(4);
        testList.add(5);
        testList.add(6);
        testList.add(7);
    }


        @Test
        void testTake() {
        n = 3;
        List<Integer> compareList = new ArrayList<>();
        compareList.add(0);
        compareList.add(1);
        compareList.add(2);
        assertThat(compareList).isEqualTo(App.take(testList, n));

        // END
    }
}
