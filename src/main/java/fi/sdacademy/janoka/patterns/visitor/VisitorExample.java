package fi.sdacademy.janoka.patterns.visitor;

import lombok.AllArgsConstructor;

import java.util.List;

/**
 * Makes it easy to iterate and process a number of classes that are not otherwise related
 */
public class VisitorExample {

    public interface Visitable{
        public void accept(Visitor visitor);
    }

    @AllArgsConstructor
    public class Book implements Visitable{
        private double price;
        private double weight;

        public void accept(Visitor visitor) {
            visitor.visit(this);
        }
        public double getPrice() {
            return price;
        }
        public double getWeight() {
            return weight;
        }
    }

    public class CD implements Visitable {

        @Override
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }

        public void play() {

        }
    }

    public interface Visitor{
        public void visit(Book book);

        public void visit(CD cd);
    }

    public class ConsumerVisitor implements Visitor {

        @Override
        public void visit(Book book) {
            book.getPrice();
            book.getWeight();
        }

        @Override
        public void visit(CD cd) {
            cd.play();
        }
    }

    public void exampleUsage() {
        ConsumerVisitor visitor = new ConsumerVisitor();
        List.of(new Book(1, 1), new CD()).forEach(item -> item.accept(visitor));
    }
}
