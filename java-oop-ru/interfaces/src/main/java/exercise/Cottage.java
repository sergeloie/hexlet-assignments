package exercise;

import java.util.Locale;

// BEGIN
public class Cottage implements Home {

    private double area;
    private int floorCount;

    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    /**
     * @return floorCount этажный коттедж площадью area метров
     */
    public String toString() {
        return String.format(Locale.US, "%d этажный коттедж площадью %.1f метров", floorCount, area);
    }

    /**
     * @return площадь коттеджа
     */
    public double getArea() {
        return area;
    }
}
// END
