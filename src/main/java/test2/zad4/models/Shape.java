package test2.zad4.models;

public abstract class Shape {
    protected static int counter = 0;
    protected int number;

    public Shape() {
        this.number = 0;
    }

    public abstract double calculatePerimeter();

    public abstract double calculateArea();

    public static int getCounter() {
        return counter;
    }

    public static Square createSquare(double side) {
        counter++;
        return new Square(side, getCounter());
    }

    public static Circle createCircle(double radius) {
        counter++;
        return new Circle(radius / 2, getCounter());
    }

    public static Rectangle createRectangle(double sideA, double sideB) {
        counter++;
        return new Rectangle(sideA, sideB, getCounter());
    }

    @Override
    public String toString() {
        return "Shape number " + number + ": ";
    }
}
