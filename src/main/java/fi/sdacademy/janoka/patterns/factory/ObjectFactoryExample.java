package fi.sdacademy.janoka.patterns.factory;

/**
 * Usage example in tests
 */
public class ObjectFactoryExample {

    /**
     * Keeping the constructor private so that nobody can unnecessarily create the instance of this class
     */
    private ObjectFactoryExample() {}

    public static class AnimalFactory {

        public static Animal create(String name) {
            if ("Dog".equalsIgnoreCase(name)) {
                return new Dog();
            } else if ("Cat".equalsIgnoreCase(name)) {
                return new Cat();
            }
            throw new NoSuchAnimalException("The animal " + name + " is not supported");
        }
    }

    public interface Animal {
        void makeSound();
    }

    public static class Dog implements Animal {

        @Override
        public void makeSound() {
            //Do something
        }
    }

    public static class Cat implements Animal {

        @Override
        public void makeSound() {
            //Do something
        }
    }
}
