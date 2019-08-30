package fi.sdacademy.janoka.prototype;

import java.util.Objects;

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

        @Override
        public boolean equals(Object object2) {
            if (!(object2 instanceof Shape)) return false;
            Shape shape2 = (Shape) object2;
            return shape2.x == x && shape2.y == y && Objects.equals(shape2.color, color);
        }
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

        @Override
        public boolean equals(Object object2) {
            if (!(object2 instanceof Circle) || !super.equals(object2)) return false;
            Circle shape2 = (Circle) object2;
            return shape2.radius == radius;
        }
    }
}
