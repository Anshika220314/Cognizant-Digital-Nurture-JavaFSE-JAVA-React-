import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AAAPatternTest {

    private Calculator calc;

    // Setup method runs before every single test
    @BeforeEach
    public void setUp() {
        // Arrange
        calc = new Calculator();
        System.out.println("Setup: Calculator initialized.");
    }

    @Test
    public void testAdditionWithAAA() {
        // Act
        int result = calc.add(10, 20);

        // Assert
        assertEquals(30, result, "10 + 20 should equal 30");
    }

    // Teardown method runs after every single test
    @AfterEach
    public void tearDown() {
        calc = null;
        System.out.println("Teardown: Resources cleared.");
    }
}