package fi.sdacademy.janoka.factory;

/**
 * Example usage available in the unit tests
 */
public class AbstractFactoryExample {

    private AbstractFactoryExample() { }

    public static class FactoryProvider {
        public static AbstractFactory<?> getFactory(String type) {
            if ("Animal".equalsIgnoreCase(type)) {
                return new AnimalFactory();
            } else if ("Color".equalsIgnoreCase(type)) {
                return new ColorFactory();
            }
            throw new NoSuchFactoryException("The factory type " + type + " is not supported");
        }
    }

    public interface AbstractFactory<T> {
        T create(String name);
    }

    public static class AnimalFactory implements AbstractFactory<Animal> {

        @Override
        public Animal create(String name) {
            if ("Dog".equalsIgnoreCase(name)) {
                return new Dog();
            } else if ("Cat".equalsIgnoreCase(name)) {
                return new Cat();
            }
            throw new NoSuchAnimalException("The animal " + name + " is not supported");
        }
    }

    public static class ColorFactory implements AbstractFactory<Color> {

        @Override
        public Color create(String name) {
            if ("White".equalsIgnoreCase(name)) {
                return new White();
            } else if ("Black".equalsIgnoreCase(name)) {
                return new Black();
            }
            throw new NoSuchColorException("The color " + name + " is not supported");
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

    public interface Color {

    }

    public static class White implements Color {

    }

    public static class Black implements Color {

    }

}
