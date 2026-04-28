package com.yas.rating.utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MessagesUtilsTest {

    @Test
    void getMessage_whenKeyExists_shouldReturnFormattedMessage() {
        // Use a known message code from messages.properties
        String result = MessagesUtils.getMessage("RATING_NOT_FOUND", 123L);
        assertThat(result).isNotNull();
        assertThat(result).isNotEmpty();
    }

    @Test
    void getMessage_whenKeyDoesNotExist_shouldReturnKeyAsMessage() {
        String result = MessagesUtils.getMessage("NON_EXISTENT_KEY");
        assertThat(result).isEqualTo("NON_EXISTENT_KEY");
    }

    @Test
    void getMessage_whenKeyDoesNotExist_withArgs_shouldReturnKeyWithArgs() {
        String result = MessagesUtils.getMessage("NON_EXISTENT_KEY_WITH_ARGS", "arg1", "arg2");
        assertThat(result).isEqualTo("NON_EXISTENT_KEY_WITH_ARGS");
    }
}
