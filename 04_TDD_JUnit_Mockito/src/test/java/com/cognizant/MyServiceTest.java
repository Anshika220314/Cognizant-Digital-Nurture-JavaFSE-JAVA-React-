package com.cognizant;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MyServiceTest {

    @Test
    public void testExternalApi() {
        // ⭐ Exercise 1: Mocking and Stubbing
        // 1. Create a mock instance for our targeted external interface layer
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        // 2. Stub the behavioral call path to return a predefined value
        when(mockApi.getData()).thenReturn("Mock Data");

        // 3. Test execution against the service under verification
        MyService service = new MyService(mockApi);
        String result = service.fetchData();

        assertEquals("Mock Data", result, "Service data should match mocked return string");
    }

    @Test
    public void testVerifyInteraction() {
        // ⭐ Exercise 2: Verifying Interactions
        // 1. Setup mock instance dependencies
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        // 2. Invoke service method call execution
        service.fetchData();

        // 3. Verify interaction pathway occurred exactly as expected
        verify(mockApi).getData();
    }
}