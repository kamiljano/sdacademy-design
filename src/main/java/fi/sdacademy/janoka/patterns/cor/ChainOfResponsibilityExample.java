package fi.sdacademy.janoka.patterns.cor;

public class ChainOfResponsibilityExample {

    public abstract class Link {
        private Link next;

        public Link then(Link next) {
            this.next = next;
            return next;
        }

        public abstract void handle(String email);

        protected void handleNext(String email) {
            if (next == null) {
                return;
            }
            next.handle(email);
        }
    }

    public class EmailValidator extends Link {

        private boolean isValid(String email) {
            // perform email validation
            return true;
        }

        @Override
        public void handle(String email) {
            if (isValid(email)) {
                handleNext(email);
            }
        }
    }

    public class EmailSaver extends Link {

        @Override
        public void handle(String email) {
            // save email in the db
            handleNext(email);
        }
    }

    public void exampleUsage() {
        new EmailValidator()
                .then(new EmailSaver())
                .handle("email@gmail.com");
    }
}
