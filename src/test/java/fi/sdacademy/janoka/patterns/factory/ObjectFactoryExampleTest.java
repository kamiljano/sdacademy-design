package fi.sdacademy.janoka.patterns.factory;

import fi.sdacademy.janoka.patterns.factory.ObjectFactoryExample.AnimalFactory;
import fi.sdacademy.janoka.patterns.factory.ObjectFactoryExample.Cat;
import fi.sdacademy.janoka.patterns.factory.ObjectFactoryExample.Dog;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ObjectFactoryExampleTest {

    @Test
    public void testCreation() {
        assertTrue(AnimalFactory.create("Dog") instanceof Dog);
        assertTrue(AnimalFactory.create("Cat") instanceof Cat);
    }

}