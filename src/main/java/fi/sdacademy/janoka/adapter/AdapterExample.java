package fi.sdacademy.janoka.adapter;

public class AdapterExample {

    public interface Movable {
        double getSpeed();
    }

    public class BugattiVeyron implements Movable {
        @Override
        public double getSpeed() {
            return 268;
        }
    }

    public interface MovableAdapter {
        // returns speed in KM/H
        double getSpeed();
    }

    public class MovableAdapterImpl implements MovableAdapter {
        private Movable luxuryCars;

        @Override
        public double getSpeed() {
            return convertMPHtoKMPH(luxuryCars.getSpeed());
        }

        private double convertMPHtoKMPH(double mph) {
            return mph * 1.60934;
        }
    }
}
