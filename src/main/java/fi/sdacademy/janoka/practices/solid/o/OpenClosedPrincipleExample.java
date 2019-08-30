package fi.sdacademy.janoka.practices.solid.o;

import java.util.Collection;
import java.util.List;

public class OpenClosedPrincipleExample {

    public interface Shape {
        double getArea();
    }

    public class Square implements Shape {

        private final double side;

        public Square(double side) {
            this.side = side;
        }

        @Override
        public double getArea() {
            return Math.pow(side, 2);
        }
    }

    public class Rectangle implements Shape {

        private final double a;
        private final double b;

        public Rectangle(double a, double b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public double getArea() {
            return a * b;
        }
    }

    public double sumAreas(Collection<Shape> shapes) {
        double sum = 0;
        for (Shape shape : shapes) {
            sum += shape.getArea();
        }
        return sum;
    }

    public void exampleUsage() {
        sumAreas(List.of(new Square(2), new Rectangle(3, 4)));
    }
}
