package exercise;

import java.util.Locale;

// BEGIN
public class Flat implements Home {

    private double area;
    private double balconyArea;
    private int floor;

    public Flat(double area, double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }

    /**
     * @return Квартира площадью area + balconyArea метров на floor этаже
     */
    public String toString() {

        return String.format(Locale.US, "Квартира площадью %.1f метров на %d этаже", area + balconyArea, floor);
    }

    /**
     * @return площадь квартиры
     */
    public double getArea() {
        return area + balconyArea;
    }

}

// END
