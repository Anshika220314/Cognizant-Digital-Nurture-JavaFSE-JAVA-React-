import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    @Test
    void testAddition() {
        Calculator calc = new Calculator(); // Will show red/error initially (TDD Red Phase)
        assertEquals(5, calc.add(2, 3));
    }
}