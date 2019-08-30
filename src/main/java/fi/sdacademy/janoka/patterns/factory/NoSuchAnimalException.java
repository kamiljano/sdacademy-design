package fi.sdacademy.janoka.patterns.factory;

class NoSuchAnimalException extends RuntimeException {

    public NoSuchAnimalException(String message) {
        super(message);
    }
}
