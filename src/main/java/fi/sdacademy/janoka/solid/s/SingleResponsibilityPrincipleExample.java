package fi.sdacademy.janoka.solid.s;

import java.util.Random;

/**
 * S - Single Responsibility Principle Example
 *
 * Small classes. Once split into separate files, can be instantly readable with a single look.
 * Additional abstractions make it easier to understand what is going on
 */
public class SingleResponsibilityPrincipleExample {

    public class Library {

        public Book findBook(String title) {
            // Normally we would search for the book from some database, but for the sake of an example, we just create it here
            return new Book(new Random().nextInt(), title);
        }

        public User findUser(String name) {
            // Normally we would search for the book from some database, but for the sake of an example, we just create it here
            return new User(new Random().nextInt(), name);
        }
    }

    public class Book {

        private final int id;
        private final String title;

        public Book(int id, String title) {
            this.id = id;
            this.title = title;
        }

        public void rent(User user) {
            //TODO: mark the book as rented in the database
        }

        public void release() {
            //TODO: mark the book as returned in the database
        }

    }

    public class User {

        private final int id;
        private final String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    public void exampleUsage() {
        Library library = new Library();
        library
                .findBook("Harry Potter and the Philosopher's Stone")
                .rent(library.findUser("Kamil"));
    }
}
