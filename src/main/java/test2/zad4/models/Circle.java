package test2.zad4.models;

import java.util.Objects;

public class Circle extends Shape {
    private double radius;

    public Circle(double radius, int number) {
        this.radius = radius;
        this.number = number;
    }

    public Circle(double radius) {
        this.radius = radius;
        this.number = 0;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return Double.compare(radius, circle.radius) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }

    @Override
    public String toString() {
        return super.toString() + "Circle with radius " + (int)radius;
    }
}
