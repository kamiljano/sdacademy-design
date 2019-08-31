package fi.sdacademy.janoka.patterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Whenever the news agency gets news it has to notify all the channels about it.
 * For this to happen news agency needs to have references to those channels and that means tight coupling
 */
public class ObserverExampleScenario {

    public class NewsAgency {
        private String news;
        private List<Channel> channels = new ArrayList<>();

        public void addObserver(Channel channel) {
            this.channels.add(channel);
        }

        public void removeObserver(Channel channel) {
            this.channels.remove(channel);
        }

        public void setNews(String news) {
            this.news = news;
            for (Channel channel : this.channels) {
                channel.update(this.news);
            }
        }
    }

    public class NewsChannel implements Channel {
        private String news;

        @Override
        public void update(Object news) {
            this.news = (String) news;
        }
    }

    public interface Channel {
        public void update(Object o);
    }
}
