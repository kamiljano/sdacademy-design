package fi.sdacademy.janoka.builder;

public class BuilderExample {

    public void exampleUsage() {
        User user = User.builder()
                .withName("John")
                .withSurname("Doe")
                .withSocialSecurityNumber("211290-1234")
                .build();
    }

    public static class User {

        /**
         * Note that the method needs to be static so that you can acquire the builder from the outside
         */
        public static UserBuilder builder() {
            return new UserBuilder();
        }

        private final String name;
        private final String surname;
        private final String socialSecurityNumber;

        /**
         * Note private constructor - enforces the object creation via builder
         */
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
}
