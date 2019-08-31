package fi.sdacademy.janoka.patterns.command;

import java.util.ArrayList;
import java.util.List;

public class CommandPatternExample {

    public interface TextFileOperation {
        String execute();
    }

    public class OpenTextFileOperation implements TextFileOperation {

        private TextFile textFile;

        // constructors

        @Override
        public String execute() {
            return textFile.open();
        }
    }

    public class SaveTextFileOperation implements TextFileOperation {

        private TextFile textFile;

        @Override
        public String execute() {
            return textFile.save();
        }
    }

    public class TextFile {

        private String name;

        // constructor

        public String open() {
            return "Opening file " + name;
        }

        public String save() {
            return "Saving file " + name;
        }

    }

    public class TextFileOperationExecutor {

        private final List<TextFileOperation> textFileOperations = new ArrayList<>();

        public String executeOperation(TextFileOperation textFileOperation) {
            textFileOperations.add(textFileOperation);
            return textFileOperation.execute();
        }
    }
}
