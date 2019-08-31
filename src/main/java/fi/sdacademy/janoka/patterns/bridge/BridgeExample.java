package fi.sdacademy.janoka.patterns.bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Exposing the object specific logic to be executed in a common place
 * where it is known how the object specific logic should be executed in the optimal way.
 *
 * Allows to decouple compile-time dependencies between classes
 */
public class BridgeExample {

    public interface WorkShop {
        void work(Vehicle vehicle);
    }

    public class ProduceWorkShop implements WorkShop {

        @Override
        public void work(Vehicle vehicle) {
            System.out.print("Producing... ");
            long timeToTake = 300 * vehicle.minWorkTime();
            try {
                TimeUnit.MILLISECONDS.sleep(timeToTake);
            } catch (InterruptedException exp) {
                // nothing to do for now.
            }
            System.out.printf("(Time taken: %d millis), Done.\n", timeToTake);
        }
    }

    public abstract class Vehicle {
        // assempbly line for the workshops
        protected List<WorkShop> workshops = new ArrayList<WorkShop>();

        public boolean joinWorkshop(WorkShop workshop) {
            return workshops.add(workshop);
        }
        public abstract void manufacture();
        public abstract int minWorkTime();
    }


    public class Bike extends Vehicle {
        @Override
        public void manufacture() {
            System.out.println("Manufactoring Bike...");
            workshops.stream().forEach(workshop -> workshop.work(this));
            System.out.println("Done.");
            System.out.println();
        }

        @Override
        public int minWorkTime() {
            return 5;
        }
    }

    public class Car extends Vehicle {
        @Override
        public void manufacture() {
            System.out.println("Manufactoring Car");
            workshops.stream().forEach(workshop -> workshop.work(this));
            System.out.println("Done.");
            System.out.println();
        }
        @Override
        public int minWorkTime() {
            return 10;
        }
    }


    public class Bus extends Vehicle {
        @Override
        public void manufacture() {
            System.out.println("Manufactoring Bus");
            workshops.stream().forEach(workshop -> workshop.work(this));
            System.out.println("Done.");
            System.out.println();
        }
        @Override
        public int minWorkTime() {
            return 20;
        }
    }
}
