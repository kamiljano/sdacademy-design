package fi.sdacademy.janoka.patterns.singleton;

public class SingletonExample {

    private static SingletonExample INSTANCE;

    public static SingletonExample getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SingletonExample();
        }

        return INSTANCE;
    }

    /**
     * Note the private constructor. This way you can ensure that the client will always
     * acquire the instance through the getInstance() method, since he cannot call
     * `new SingletonExample()` even if he wanted to
     */
    private SingletonExample() {}
}
