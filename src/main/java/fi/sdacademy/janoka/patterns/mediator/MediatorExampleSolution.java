package fi.sdacademy.janoka.patterns.mediator;


import static fi.sdacademy.janoka.patterns.mediator.MediatorExampleScenario.PowerSupplier;

/**
 * The data that both fan and the button were dependant on
 * were extracted to the mediator
 */
public class MediatorExampleSolution {

    public interface Mediator {
        void press();
        void start();
        void stop();
    }

    public class ButtonFanMediator implements Mediator {
        private Button button;
        private Fan fan;
        private PowerSupplier powerSupplier;

        @Override
        public void press() {
            if (fan.isOn()) {
                fan.turnOff();
            } else {
                fan.turnOn();
            }
        }

        @Override
        public void start() {
            powerSupplier.turnOn();
        }

        @Override
        public void stop() {
            powerSupplier.turnOff();
        }
    }

    public class Button {
        private Mediator mediator;

        // constructor, getters and setters

        public void press() {
            mediator.press();
        }
    }

    public class Fan {
        private Mediator mediator;
        private boolean isOn = false;

        // constructor, getters and setters

        public boolean isOn() {
            return isOn;
        }

        public void turnOn() {
            mediator.start();
            isOn = true;
        }

        public void turnOff() {
            isOn = false;
            mediator.stop();
        }
    }
}
