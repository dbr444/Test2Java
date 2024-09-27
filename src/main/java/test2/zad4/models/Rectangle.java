package test2.zad4.models;

import java.util.Objects;

public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height, int number) {
        this.width = width;
        this.height = height;
        this.number = number;
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
        this.number = 0;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (width + height);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(width, rectangle.width) == 0 && Double.compare(height, rectangle.height) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height);
    }

    @Override
    public String toString() {
        return super.toString() + "Rectangle with sides " + (int)width + "x" + (int)height;
    }
}
