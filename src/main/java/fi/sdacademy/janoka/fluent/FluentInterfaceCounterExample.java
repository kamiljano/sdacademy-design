package fi.sdacademy.janoka.fluent;

import java.util.ArrayList;
import java.util.List;

public class FluentInterfaceCounterExample {

    public class Library {

        private final List<User> users = new ArrayList<>();

        /**
         * Will be confusing if a class representing a user already exists and then this method doesn't try to use it,
         * but specifies each user's property separately. It will lead to discrepancies between the class and this method at some point.
         *
         * The user of the method has to look up this method for every parameter to know what a certain String is supposed to represent,
         * so that he doesn't accidentally specify social security number as a name
         *
         * The method name itself doesn't make it very specific what you're registering... perhaps a book?
         */
        public void register(String name, String surname, String socialSecurityNumber) {
            users.add(new User(name, surname, socialSecurityNumber));
        }

        public class User {
            private final String n;
            private final String sn;
            private final String ssn;

            /**
             * The parameters are not descriptive. It makes it difficult to work with this class
             */
            public User(String n, String sn, String ssn) {
                this.n = n;
                this.sn = sn;
                this.ssn = ssn;
            }
        }
    }

    public void exampleUsage() {

    }
}
