package SLF4J_Logging_Framework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExample {
    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

    public static void main(String[] args) {
        // Logging an error message
        logger.error("This is an error message");

        // Logging a warning message
        logger.warn("This is a warning message");
    }
}