package test2.zad4.app;

import test2.zad4.models.Shape;
import test2.zad4.models.Square;
import test2.zad4.services.ShapeService;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ShapeRunner {
    public static void main(String[] args) {
        List<Shape> shapes = Arrays.asList(
                Shape.createSquare(10),
                Shape.createCircle(20),
                Shape.createRectangle(10, 20)
        );

        for (Shape s : shapes) {
            System.out.println(s);
        }

        //

        Shape shapeWithMaxPerimeter = ShapeService.findShapeWithMaxPerimeter(shapes);
        System.out.println("Shape with the largest perimeter: " + shapeWithMaxPerimeter);

        Shape shapeWithMaxArea = ShapeService.findShapeWithMaxArea(shapes);
        System.out.println("Shape with the largest area: " + shapeWithMaxArea);

        System.out.println(shapes.contains(new Square(10)));

        //save do pliku

        String filename = "shapes.txt";

        try {
            ShapeService.saveShapesToFile(shapes, filename);
            System.out.println("Shapes saved to file.");
        } catch (IOException e) {
            System.out.println("Error saving shapes: " + e.getMessage());
        }
    }
}
