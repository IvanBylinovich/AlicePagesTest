package exception;

public class NegativePageNumberException extends Exception{

    public NegativePageNumberException() {
    }

    public NegativePageNumberException(String message) {
        super(message);
    }
}
