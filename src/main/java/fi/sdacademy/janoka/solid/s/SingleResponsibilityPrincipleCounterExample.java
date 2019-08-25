package fi.sdacademy.janoka.solid.s;

import java.util.Random;

/**
 * S - Single Responsibility Principle Counter Example
 *
 * Now imagine that the class Library could potentially have operations for registering a new user, removing a user,
 * managing the employees of the library in a lot of various ways etc. The file could grow to an enormous extent.
 * Good luck finding anything in such a jungle.
 *
 * Additionally:
 *  * Limited re-usability
 *  * operating on low-level objects, whereas you could easily abstract parts of the logic into appropriate classes
 */
public class SingleResponsibilityPrincipleCounterExample {

    public class Library {

        public void rentBook(int userId, int bookId) {
            // Mark in DB as rented
        }

        public void returnBook(int userId, int bookId) {
            // Mark in DB as returned
        }

        public int findUserId(String name) {
            // Normally this would be a db operation
            return new Random().nextInt();
        }

        public int findBookId(String title) {
            // Normally this would be a db operation
            return new Random().nextInt();
        }

    }

    public void exampleUsage() {
        Library library = new Library();
        int bookId = library.findBookId("Harry Potter and the Philosopher's Stone");
        int userId = library.findUserId("Kamil");
        library.rentBook(userId, bookId);
    }

}
