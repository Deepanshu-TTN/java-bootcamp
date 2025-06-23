package SingletonPattern;

public class Main {
    public static void main(String[] args) {
//        logMockWithoutSingleton();
        logMockWithSingleton();
    }

    public static void logMockWithoutSingleton() {
        // we can create 2 logger instances, bad !!!
        // similar use cases - database connection
        LoggerWithoutSingleton logger1 = new LoggerWithoutSingleton();
        LoggerWithoutSingleton logger2 = new LoggerWithoutSingleton();

        logger1.log("Logger 1 logging");
        logger2.log("Logger 2 logging");

        System.out.println("Logger1 == Logger2? " + (logger1 == logger2));
    }

    public static void logMockWithSingleton() {
        // here we only use a single instance of the logger due to design pattern
        LoggerSingleton logger1 = LoggerSingleton.getInstance();
        LoggerSingleton logger2 = LoggerSingleton.getInstance();

        logger1.log("Logger 1 logging");
        logger2.log("Logger 2 logging");

        System.out.println("Logger1 == Logger2? " + (logger1 == logger2));
    }
}

class LoggerWithoutSingleton {
    public void log(String message) {
        System.out.println("[Logger] " + message);
    }
}

class LoggerSingleton {
    private static LoggerSingleton instance;

    private LoggerSingleton() {}

    public static LoggerSingleton getInstance() {
        if (instance == null) {
            instance = new LoggerSingleton();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("[SingletonLogger] " + message);
    }
}
