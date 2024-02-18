package models;

import utility.Validatable;

public class Coordinates implements Validatable {
    private float x; // Максимальное значение поля: 145
    private double y;
    public Coordinates(float x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean validate() {
        return (x <= 145);
    }
    @Override
    public String toString() {
        return "x.coordinate = " + x + " y.coordinate = " + y;
    }
}
