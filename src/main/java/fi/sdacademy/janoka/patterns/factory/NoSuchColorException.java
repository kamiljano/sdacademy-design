package fi.sdacademy.janoka.patterns.factory;

class NoSuchColorException extends RuntimeException {
    public NoSuchColorException(String message) {
        super(message);
    }
}
