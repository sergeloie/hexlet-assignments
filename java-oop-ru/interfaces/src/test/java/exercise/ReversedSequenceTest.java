package exercise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReversedSequenceTest {

    @Test
    void lengthTest() {
        String str = "Hello";
        assertEquals(5, new ReversedSequence(str).length());
    }

    @Test
    void charAt() {
        String str = "Hello";
        assertEquals('o', new ReversedSequence(str).charAt(0));
    }

    @Test
    void subSequence() {
        String str = "Hello";
        assertEquals("lle", new ReversedSequence(str).subSequence(1, 4).toString());
    }

    @Test
    void testToString() {
        String str = "Hello";
        assertEquals("olleH", new ReversedSequence(str).toString());
    }
}
