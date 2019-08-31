package fi.sdacademy.janoka.patterns.prototype;

public class PrototypeExample {

    public abstract class Shape {
        public int x;
        public int y;
        public String color;

        public Shape() {
        }

        public Shape(Shape target) {
            if (target != null) {
                this.x = target.x;
                this.y = target.y;
                this.color = target.color;
            }
        }

        public abstract Shape clone();

    }

    public class Circle extends Shape {
        public int radius;

        public Circle() {
        }

        public Circle(Circle target) {
            super(target);
            if (target != null) {
                this.radius = target.radius;
            }
        }

        @Override
        public Shape clone() {
            return new Circle(this);
        }
    }
}
