package fi.sdacademy.janoka.patterns.mediator;

/**
 * Note tight coupling between the button and the fan.
 * Fan requires a reference to the button and the button requires a reference to the fan
 * Such tight coupling prevents reusability of the button in other cases
 */
public class MediatorExampleScenario {

    public static class Button {
        private Fan fan;

        // constructor, getters and setters

        public void press() {
            if (fan.isOn()) {
                fan.turnOff();
            } else {
                fan.turnOn();
            }
        }
    }

    public static class Fan {
        private Button button;
        private PowerSupplier powerSupplier;
        private boolean isOn = false;

        public boolean isOn() {
            return isOn;
        }

        public void turnOn() {
            powerSupplier.turnOn();
            isOn = true;
        }

        public void turnOff() {
            isOn = false;
            powerSupplier.turnOff();
        }
    }

    public static class PowerSupplier {
        public void turnOn() {
            // implementation
        }

        public void turnOff() {
            // implementation
        }
    }
}
