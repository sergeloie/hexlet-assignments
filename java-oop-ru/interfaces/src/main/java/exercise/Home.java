package exercise;

// BEGIN
interface Home {
    double getArea();
    default int compareTo(Home other) {
        return Integer.signum(Double.compare(this.getArea(), other.getArea()));
    }
}
// END
