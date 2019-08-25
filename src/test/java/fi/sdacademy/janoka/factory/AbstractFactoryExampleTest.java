package fi.sdacademy.janoka.factory;

import fi.sdacademy.janoka.factory.AbstractFactoryExample.Animal;
import fi.sdacademy.janoka.factory.AbstractFactoryExample.Color;
import fi.sdacademy.janoka.factory.AbstractFactoryExample.FactoryProvider;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AbstractFactoryExampleTest {

    @Test
    public void testCreation() {
        assertTrue(FactoryProvider.getFactory("animal").create("dog") instanceof Animal);
        assertTrue(FactoryProvider.getFactory("color").create("white") instanceof Color);
    }
}