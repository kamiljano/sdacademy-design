package fi.sdacademy.janoka.patterns.observer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Better solution with PropertyChangeListener
 */
public class ObserverExampleBetterSolution {

    public class PCLNewsAgency {
        private String news;

        private PropertyChangeSupport support;

        public PCLNewsAgency() {
            support = new PropertyChangeSupport(this);
        }

        public void addPropertyChangeListener(PropertyChangeListener pcl) {
            support.addPropertyChangeListener(pcl);
        }

        public void setNews(String value) {
            support.firePropertyChange("news", this.news, value);
            this.news = value;
        }
    }

    public class PCLNewsChannel implements PropertyChangeListener {

        private String news;

        public void propertyChange(PropertyChangeEvent evt) {
            this.news = (String) evt.getNewValue();
        }
    }

    public void exampleUsage() {
        PCLNewsAgency observable = new PCLNewsAgency();
        PCLNewsChannel observer = new PCLNewsChannel();

        observable.addPropertyChangeListener(observer);
        observable.setNews("news");
    }
}
