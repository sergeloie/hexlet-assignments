package exercise;

// BEGIN
public class ReversedSequence implements CharSequence {

    private String string;

    public ReversedSequence(String string) {
        StringBuilder sb = new StringBuilder(string);
        this.string = sb.reverse().toString();
    }


    /**
     * @return длина строки
     */
    @Override
    public int length() {
        return this.string.length();
    }

    /**
     * @param index the index of the {@code char} value to be returned
     * @return the {@code char} value at the specified index
     */
    @Override
    public char charAt(int index) {
        return this.string.charAt(index);
    }

    /**
     * @param start the start index, inclusive
     * @param end   the end index, exclusive
     * @return a new CharSequence that is a subsequence of this sequence
     */
    @Override
    public CharSequence subSequence(int start, int end) {
        return this.string.subSequence(start, end);
    }

    /**
     * @return строковое представление объекта
     */
    public String toString() {
        return this.string;
    }
}
// END
