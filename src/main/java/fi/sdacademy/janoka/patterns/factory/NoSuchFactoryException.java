package fi.sdacademy.janoka.patterns.factory;

class NoSuchFactoryException extends RuntimeException{

    public NoSuchFactoryException(String message) {
        super(message);
    }
}
