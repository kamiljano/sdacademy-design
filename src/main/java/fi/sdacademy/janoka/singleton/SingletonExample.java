package fi.sdacademy.janoka.singleton;

public class SingletonExample {

    private static SingletonExample INSTANCE;

    public static SingletonExample getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SingletonExample();
        }

        return INSTANCE;
    }

    private SingletonExample() {}
}
