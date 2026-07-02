package com.cognizant;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AssertionsTest {

    private String sampleContext;

    // Exercise 4: Setup Method (Initializes test fixtures before each test runs)
    @BeforeEach
    public void setUp() {
        sampleContext = "Initialized Context";
    }

    // Exercise 4: Teardown Method (Cleans up resources after each test completes)
    @AfterEach
    public void tearDown() {
        sampleContext = null;
    }

    @Test
    public void testAssertions() {
        // Exercise 4: Arrange (Set up data and expectations)
        int valueA = 2;
        int valueB = 3;

        // Exercise 4: Act (Execute the target operation)
        int result = valueA + valueB;

        // Exercise 3 & 4: Assert (Validate actual results match expectations)
        assertEquals(5, result, "2 + 3 should equal 5");
        assertTrue(5 > 3, "Condition must evaluate to True");
        assertFalse(5 < 3, "Condition must evaluate to False");
        assertNull(null, "Object instance must be Null");
        assertNotNull(sampleContext, "Test fixture context must not be Null");
    }
}