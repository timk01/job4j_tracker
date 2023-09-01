package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Error is active: " + active);
        System.out.println("Error's status: " + status);
        System.out.println("Error's message: " + message);
    }

    public static void main(String[] args) {
        Error emptyError = new Error();
        Error filledError = new Error(true, 404, "Page is not found");
        emptyError.printInfo();
        filledError.printInfo();
    }
}
