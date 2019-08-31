package fi.sdacademy.janoka.patterns.iterator;

/**
 * Real life example also available under List.iterator();
 *
 * Check out the unit test
 */
public class IteratorExample {

    public interface Iterator<E> {
        E next();   // To get the next element

        boolean hasNext();  // To check whether there is any next element or not.
    }

    public static class StringIterator implements Iterator<String> {

        private String[] topics;
        private int position;

        public StringIterator(String... topics)
        {
            this.topics = topics;
            position = 0;
        }

        @Override
        public String next() {
            return topics[position++];
        }

        @Override
        public boolean hasNext() {
            return position < topics.length;
        }
    }
}
