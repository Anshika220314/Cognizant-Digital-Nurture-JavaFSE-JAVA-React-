package SLF4J_Logging_Framework;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LoggingExampleTest {

    @Test
    void testLoggingRunsWithoutErrors() {
        assertDoesNotThrow(() -> {
            LoggingExample.main(new String[]{});
        });
    }
}