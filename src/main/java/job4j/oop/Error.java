package job4j.oop;

public class Error {
    boolean active;
    int status;
    String message;

    public Error() {

    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void infoError() {
        System.out.println("Active " + active);
        System.out.println("Status " + status);
        System.out.println("Message " + message);
    }

    public static void main(String[] args) {
        Error err1 = new Error();
        Error err2 = new Error(true, 1, "Error found");
        Error err3 = new Error(true, 2, "Error not found");
        err1.infoError();
        err2.infoError();
        err3.infoError();
    }
}
