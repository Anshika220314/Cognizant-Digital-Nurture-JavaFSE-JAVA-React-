public class Logger {
    // 1. Private static instance of the class (Lazy initialization)
    private static Logger instance;

    // 2. Private constructor to prevent instantiation from other classes
    private Logger() {
        System.out.println("Logger Instance Created.");
    }

    // 3. Public static method to provide a global access point
    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger(); // Created only if it doesn't exist
        }
        return instance;
    }

    // A simple method to simulate logging activity
    public void log(String message) {
        System.out.println("[LOG]: " + message);
    }
}