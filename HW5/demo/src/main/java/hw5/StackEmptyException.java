package hw5;

public class StackEmptyException extends RuntimeException{
    public StackEmptyException() {
        super("Error: Stack is empty.");
    }
}
