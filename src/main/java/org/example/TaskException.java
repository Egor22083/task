package org.example;

public class TaskException extends RuntimeException {
    public TaskException(String message) {
        super(message);
    }
    public TaskException() {
        super();
    }
}
