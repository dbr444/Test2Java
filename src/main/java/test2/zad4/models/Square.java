package test2.zad4.models;

import java.util.Objects;

public class Square extends Shape {
    private double side;

    public Square(double side, int number) {
        this.side = side;
        this.number = number;
    }

    public Square(double side) {
        this.side = side;
        this.number = 0;
    }

    @Override
    public double calculateArea() {
        return side * side;
    }

    @Override
    public double calculatePerimeter() {
        return 4 * side;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return Double.compare(side, square.side) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(side);
    }

    @Override
    public String toString() {
        return super.toString() + "Square with side " + (int)side;
    }
}
