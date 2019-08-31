package fi.sdacademy.janoka.patterns.strategy;

import java.io.File;
import java.util.ArrayList;

/**
 * Essentially, the strategy pattern allows us to change the behavior of an algorithm at runtime.
 *
 * In the example below, depending on a selected strategy, the CompressionContext.createArchive will either create a zip or a rar
 */
public class StrategyExample {

    public interface CompressionStrategy {
        public void compressFiles(ArrayList<File> files);
    }


    public class ZipCompressionStrategy implements CompressionStrategy {
        public void compressFiles(ArrayList<File> files) {
            //using ZIP approach
        }
    }

    public class RarCompressionStrategy implements CompressionStrategy {
        public void compressFiles(ArrayList<File> files) {
            //using RAR approach
        }
    }

    public class CompressionContext {
        private CompressionStrategy strategy;
        //this can be set at runtime by the application preferences
        public void setCompressionStrategy(CompressionStrategy strategy) {
            this.strategy = strategy;
        }

        //use the strategy
        public void createArchive(ArrayList<File> files) {
            strategy.compressFiles(files);
        }
    }
}
