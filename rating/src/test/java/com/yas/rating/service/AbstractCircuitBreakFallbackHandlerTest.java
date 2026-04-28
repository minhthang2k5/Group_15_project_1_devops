package com.yas.rating.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class AbstractCircuitBreakFallbackHandlerTest {

    private final TestHandler handler = new TestHandler();

    @Test
    void handleBodilessFallback_shouldRethrowException() {
        RuntimeException exception = new RuntimeException("Test error");

        assertThrows(RuntimeException.class, () -> handler.handleBodilessFallback(exception));
    }

    @Test
    void handleFallback_shouldRethrowException() {
        RuntimeException exception = new RuntimeException("Test error");

        assertThrows(RuntimeException.class, () -> handler.handleFallback(exception));
    }

    /**
     * Concrete subclass for testing the abstract class.
     */
    static class TestHandler extends AbstractCircuitBreakFallbackHandler {
    }
}
