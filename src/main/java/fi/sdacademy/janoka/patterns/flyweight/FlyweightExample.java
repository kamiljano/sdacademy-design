package fi.sdacademy.janoka.patterns.flyweight;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Aims to limit the amount of wasted memory.
 * It aims to create overall fewer objects by caching those that are already created
 * and just reusing them where possible
 */
public class FlyweightExample {

    public static class Tree {
        private int x;
        private int y;
        private TreeType type;

        public Tree(int x, int y, TreeType type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }

        public void draw(Graphics g) {
            type.draw(g, x, y);
        }
    }

    public static class TreeType {
        private String name;
        private Color color;
        private String otherTreeData;

        public TreeType(String name, Color color, String otherTreeData) {
            this.name = name;
            this.color = color;
            this.otherTreeData = otherTreeData;
        }

        public void draw(Graphics g, int x, int y) {
            g.setColor(Color.BLACK);
            g.fillRect(x - 1, y, 3, 5);
            g.setColor(color);
            g.fillOval(x - 5, y - 10, 10, 10);
        }
    }

    public static class TreeFactory {
        private static Map<String, TreeType> treeTypes = new HashMap<>();

        /**
         * Call it twice with the same name and you will re-use an already existing object, thus saving memory
         */
        public static TreeType getTreeType(String name, Color color, String otherTreeData) {
            TreeType result = treeTypes.get(name);
            if (result == null) {
                result = new TreeType(name, color, otherTreeData);
                treeTypes.put(name, result);
            }
            return result;
        }
    }

    public static class Forest extends JFrame {
        private List<Tree> trees = new ArrayList<>();

        public void plantTree(int x, int y, String name, Color color, String otherTreeData) {
            TreeType type = TreeFactory.getTreeType(name, color, otherTreeData);
            Tree tree = new Tree(x, y, type);
            trees.add(tree);
        }

        @Override
        public void paint(Graphics graphics) {
            for (Tree tree : trees) {
                tree.draw(graphics);
            }
        }
    }
}
