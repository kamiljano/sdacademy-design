package fi.sdacademy.janoka.proxy;

public class ProxyPattern {

    public interface ExpensiveObject {
        void process();
    }

    public static class ExpensiveObjectImpl implements ExpensiveObject {

        public ExpensiveObjectImpl() {
            heavyInitialConfiguration();
        }

        @Override
        public void process() {
            System.out.println("processing complete.");
        }

        private void heavyInitialConfiguration() {
            System.out.println("Loading initial configuration...");
        }

    }

    public static class ExpensiveObjectProxy implements ExpensiveObject {
        private static ExpensiveObject object;

        @Override
        public void process() {
            if (object == null) {
                object = new ExpensiveObjectImpl();
            }
            object.process();
        }
    }
}
