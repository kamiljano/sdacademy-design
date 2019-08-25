package fi.sdacademy.janoka.factory;

class NoSuchAnimalException extends RuntimeException {

    public NoSuchAnimalException(String message) {
        super(message);
    }
}
