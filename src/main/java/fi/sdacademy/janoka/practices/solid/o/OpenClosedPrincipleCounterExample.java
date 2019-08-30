package fi.sdacademy.janoka.practices.solid.o;

import java.util.Collection;
import java.util.List;

public class OpenClosedPrincipleCounterExample {

    public enum ShapeType {
        SQUARE,
        CIRCLE
    }

    public class Shape {

        private final double a;
        private final ShapeType shapeType;

        public Shape(double a, ShapeType shapeType) {
            this.a = a;
            this.shapeType = shapeType;
        }

        public double getA() {
            return a;
        }

        public ShapeType getShapeType() {
            return shapeType;
        }
    }

    public double sumAreas(Collection<Shape> shapes) {
        double sum = 0;
        for (Shape shape : shapes) {
            if (shape.getShapeType() == ShapeType.CIRCLE) {
                sum += 3.14 * Math.pow(shape.getA(), 2);
            } else if (shape.getShapeType() == ShapeType.SQUARE) {
                sum += Math.pow(shape.getA(), 2);
            }
        }
        return sum;
    }

    public void exampleUsage() {
        sumAreas(List.of(new Shape(4, ShapeType.SQUARE), new Shape(3, ShapeType.CIRCLE)));
    }

}
