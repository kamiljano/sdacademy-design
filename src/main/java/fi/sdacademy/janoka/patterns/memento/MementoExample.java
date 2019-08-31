package fi.sdacademy.janoka.patterns.memento;

/**
 * Design pattern to implement the undo/redo operations
 */
public class MementoExample {

    public class Article
    {
        private long id;
        private String title;
        private String content;

        public Article(long id, String title) {
            super();
            this.id = id;
            this.title = title;
        }

        public void setId(long id) {
            this.id = id;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public ArticleMemento createMemento()
        {
            ArticleMemento m = new ArticleMemento(id, title, content);
            return m;
        }

        public void restore(ArticleMemento m) {
            this.id = m.getId();
            this.title = m.getTitle();
            this.content = m.getContent();
        }

        @Override
        public String toString() {
            return "Article [id=" + id + ", title=" + title + ", content=" + content + "]";
        }
    }

    public final class ArticleMemento
    {
        private final long id;
        private final String title;
        private final String content;

        public ArticleMemento(long id, String title, String content) {
            super();
            this.id = id;
            this.title = title;
            this.content = content;
        }

        public long getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getContent() {
            return content;
        }
    }

    public void exampleUsage() {
        Article article = new Article(1, "My Article");
        article.setContent("ABC");      //original content
        System.out.println(article);

        ArticleMemento memento = article.createMemento();   //created immutable memento

        article.setContent("123");      //changed content
        System.out.println(article);

        article.restore(memento);       //UNDO change
        System.out.println(article);    //original content
    }
}
