package fi.sdacademy.janoka.fluent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Fluent Interface means to build a project in such way that it meets the following criteria:
 *  * user can understand the interface very easily
 *  * interface can perform a series of actions in order to finish a task
 *  * each method's name should be domain-specific
 *  * Interface should be suggestive enough to guide users on what to do next
 *      and what possible operations can take at a particular moment
 */
public class FluentInterfaceExample {

    public class Library {
        private final List<User> users = new ArrayList<>();

        public void registerUser(User user) {
            users.add(user);
        }

        public List<User> getUsers() {
            return Collections.unmodifiableList(users);
        }
    }

    public static class User {

        public static UserBuilder builder() {
            return new UserBuilder();
        }

        private final String name;
        private final String surname;
        private final String socialSecurityNumber;

        private User(String name, String surname, String socialSecurityNumber) {
            this.name = name;
            this.surname = surname;
            this.socialSecurityNumber = socialSecurityNumber;
        }

        public static class UserBuilder {
            private String name;
            private String surname;
            private String socialSecurityNumber;

            public UserBuilder withName(String name) {
                this.name = name;
                return this;
            }

            public UserBuilder withSurname(String surname) {
                this.surname = surname;
                return this;
            }

            public UserBuilder withSocialSecurityNumber(String socialSecurityNumber) {
                this.socialSecurityNumber = socialSecurityNumber;
                return this;
            }

            public User build() {
                return new User(name, surname, socialSecurityNumber);
            }
        }
    }

    public void exampleUsage() {
        //TODO: show how to use
    }

}
