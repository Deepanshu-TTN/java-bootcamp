class NoStackTraceException extends RuntimeException {

    public NoStackTraceException(String message) {
        super(message);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
//        return super.fillInStackTrace(); // this method is responsible for filling stacktrace
        return this;
    }
}

public class Question9 {
    public static void main(String[] args) {
        try {
            throw new NoStackTraceException("Something went wrong, stack trace where?");
        } catch (NoStackTraceException e) {
            System.out.println("Caught: " + e);
            e.printStackTrace();
        }
    }
}