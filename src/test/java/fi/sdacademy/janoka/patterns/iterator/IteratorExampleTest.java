package fi.sdacademy.janoka.patterns.iterator;

import org.junit.Test;

public class IteratorExampleTest {

    @Test
    public void testIterator() {
        IteratorExample.StringIterator iterator = new IteratorExample.StringIterator("a", "b", "c");
        do {
            System.out.println(iterator.next());
        } while (iterator.hasNext());
    }

}