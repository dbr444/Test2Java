package test2.zad4.services;

import test2.zad4.models.Shape;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class ShapeService {
    public static Shape findShapeWithMaxPerimeter(List<Shape> shapes) {
        return shapes.stream().max(Comparator.comparingDouble(Shape::calculatePerimeter)).orElse(null);
    }

    public static Shape findShapeWithMaxArea(List<Shape> shapes) {
        return shapes.stream().max(Comparator.comparingDouble(Shape::calculateArea)).orElse(null);
    }

    public static void saveShapesToFile(List<Shape> shapes, String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Shape shape : shapes) {
                writer.write(shape.toString());
                writer.newLine();
            }
        }
    }
}
