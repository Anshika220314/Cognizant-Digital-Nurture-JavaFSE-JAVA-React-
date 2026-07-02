public class TestSingleton {
    public static void main(String[] args) {
        // Retrieve the first instance
        Logger logger1 = Logger.getInstance();
        logger1.log("This is the first log message.");

        // Retrieve the second instance
        Logger logger2 = Logger.getInstance();
        logger2.log("This is the second log message.");

        // Verification: Check if both references point to the exact same object
        if (logger1 == logger2) {
            System.out.println("\nSUCCESS: Both logger1 and logger2 point to the same instance.");
            System.out.println("Memory Address 1: " + System.identityHashCode(logger1));
            System.out.println("Memory Address 2: " + System.identityHashCode(logger2));
        } else {
            System.out.println("\nFAILURE: Multiple instances exist! Pattern broken.");
        }
    }
}