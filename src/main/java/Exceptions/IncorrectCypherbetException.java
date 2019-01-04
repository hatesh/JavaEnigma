package Exceptions;

public class IncorrectCypherbetException extends Exception {
    public IncorrectCypherbetException(String cipherbet, String origin, String reason) {
        super("Incorrect Cypherbet in  " + origin + ", Cyberbet: " + cipherbet + ", Reason: " + reason);
    }
}
