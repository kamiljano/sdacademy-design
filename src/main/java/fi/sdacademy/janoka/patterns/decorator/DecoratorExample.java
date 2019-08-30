package fi.sdacademy.janoka.patterns.decorator;

public class DecoratorExample {

    public interface ChristmasTree {
        String decorate();
    }

    public abstract class TreeDecorator implements ChristmasTree {
        private ChristmasTree tree;

        public TreeDecorator(ChristmasTree tree) {
            this.tree = tree;
        }

        // standard constructors
        @Override
        public String decorate() {
            return tree.decorate();
        }
    }

    public class BubbleLights extends TreeDecorator {

        public BubbleLights(ChristmasTree tree) {
            super(tree);
        }

        public String decorate() {
            return super.decorate() + decorateWithBubbleLights();
        }

        private String decorateWithBubbleLights() {
            return " with Bubble Lights";
        }
    }
}
