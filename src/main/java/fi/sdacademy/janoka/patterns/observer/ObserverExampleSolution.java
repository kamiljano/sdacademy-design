package fi.sdacademy.janoka.patterns.observer;

import java.util.Observable;
import java.util.Observer;

public class ObserverExampleSolution {

    public class ONewsChannel implements Observer {

        private String news;

        @Override
        public void update(Observable o, Object news) {
            this.news = (String) news;
        }
    }

    public class ONewsAgency extends Observable {
        private String news;

        public void setNews(String news) {
            this.news = news;
            setChanged();
            notifyObservers(news);
        }
    }

    public void exampleUsage() {
        ONewsAgency observable = new ONewsAgency();
        ONewsChannel observer = new ONewsChannel();

        observable.addObserver(observer);
        observable.setNews("news");
    }
}
