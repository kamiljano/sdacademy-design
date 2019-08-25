package fi.sdacademy.janoka.factory;

class NoSuchFactoryException extends RuntimeException{

    public NoSuchFactoryException(String message) {
        super(message);
    }
}
