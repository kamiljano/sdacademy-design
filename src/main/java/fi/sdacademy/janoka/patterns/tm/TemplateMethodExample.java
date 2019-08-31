package fi.sdacademy.janoka.patterns.tm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * In the example below `buildComputer()` is just a template of how the computer needs to be built
 * and the inheriting classes fill in all the gaps
 */
public class TemplateMethodExample {

    public class Computer {
        public Computer(Map<String, String> computerParts) { }
    }

    public abstract class ComputerBuilder {

        protected Map<String, String> computerParts = new HashMap<>();
        protected List<String> motherboardSetupStatus = new ArrayList<>();

        public final Computer buildComputer() {
            addMotherboard();
            setupMotherboard();
            addProcessor();
            return new Computer(computerParts);
        }

        public abstract void addMotherboard();
        public abstract void setupMotherboard();
        public abstract void addProcessor();
    }

    public class StandardComputerBuilder extends ComputerBuilder {

        @Override
        public void addMotherboard() {
            computerParts.put("Motherboard", "Standard Motherboard");
        }

        @Override
        public void setupMotherboard() {
            motherboardSetupStatus.add(
                    "Screwing the standard motherboard to the case.");
            motherboardSetupStatus.add(
                    "Pluging in the power supply connectors.");
            motherboardSetupStatus.forEach(
                    step -> System.out.println(step));
        }

        @Override
        public void addProcessor() {
            computerParts.put("Processor", "Standard Processor");
        }
    }

    public class HighEndComputerBuilder extends ComputerBuilder {

        @Override
        public void addMotherboard() {
            computerParts.put("Motherboard", "High-end Motherboard");
        }

        @Override
        public void setupMotherboard() {
            motherboardSetupStatus.add(
                    "Screwing the high-end motherboard to the case.");
            motherboardSetupStatus.add(
                    "Pluging in the power supply connectors.");
            motherboardSetupStatus.forEach(
                    step -> System.out.println(step));
        }

        @Override
        public void addProcessor() {
            computerParts.put("Processor", "High-end Processor");
        }
    }
}
