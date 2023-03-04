package Exceptions;

public class ArgumentException extends Exception {
    public ArgumentException(String argument) {
        this.argument = argument;
    }

    private final String argument;

    public String getArgument() {
        return argument;
    }

    @Override
    public String toString() {
        return argument;
    }
}