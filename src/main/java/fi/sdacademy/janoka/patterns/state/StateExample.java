package fi.sdacademy.janoka.patterns.state;

/**
 * The main idea of State pattern is to allow the object for changing its behavior without changing its class.
 * Also, by implementing it, the code should remain cleaner without many if/else statements.
 *
 * (in this case depending on the current state, the 'printStatus' does something else,
 * whereas technically the state could be just an enum and printStatus could have a lot of if statements)
 */
public class StateExample {

    public class Package {

        private PackageState state = new OrderedState();

        public void setState(PackageState state) {
            this.state = state;
        }

        public void previousState() {
            state.prev(this);
        }

        public void nextState() {
            state.next(this);
        }

        public void printStatus() {
            state.printStatus();
        }
    }

    public interface PackageState {

        void next(Package pkg);
        void prev(Package pkg);
        void printStatus();
    }

    public class OrderedState implements PackageState {

        @Override
        public void next(Package pkg) {
            pkg.setState(new DeliveredState());
        }

        @Override
        public void prev(Package pkg) {
            System.out.println("The package is in its root state.");
        }

        @Override
        public void printStatus() {
            System.out.println("Package ordered, not delivered to the office yet.");
        }
    }

    public class DeliveredState implements PackageState {

        @Override
        public void next(Package pkg) {
            pkg.setState(new ReceivedState());
        }

        @Override
        public void prev(Package pkg) {
            pkg.setState(new OrderedState());
        }

        @Override
        public void printStatus() {
            System.out.println("Package delivered to post office, not received yet.");
        }
    }

    public class ReceivedState implements PackageState {

        @Override
        public void next(Package pkg) {
            System.out.println("This package is already received by a client.");
        }

        @Override
        public void prev(Package pkg) {
            pkg.setState(new DeliveredState());
        }

        @Override
        public void printStatus() {
            System.out.println("Package received.");
        }
    }

}
