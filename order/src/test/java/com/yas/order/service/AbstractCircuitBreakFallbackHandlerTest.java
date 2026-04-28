package com.yas.order.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class AbstractCircuitBreakFallbackHandlerTest {

    private final TestCircuitBreakFallbackHandler handler = new TestCircuitBreakFallbackHandler();

    @Test
    void handleBodilessFallback_shouldRethrowException() {
        RuntimeException exception = new RuntimeException("Test error");

        assertThrows(Throwable.class, () -> handler.handleBodilessFallback(exception));
    }

    @Test
    void handleTypedFallback_shouldRethrowException() {
        RuntimeException exception = new RuntimeException("Test error");

        assertThrows(Throwable.class, () -> handler.handleTypedFallback(exception));
    }

    /**
     * Concrete subclass for testing the abstract class.
     */
    static class TestCircuitBreakFallbackHandler extends AbstractCircuitBreakFallbackHandler {
    }
}
