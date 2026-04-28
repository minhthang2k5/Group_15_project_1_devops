package com.yas.rating.config;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ConfigTest {

    @Test
    void testServiceUrlConfig() {
        ServiceUrlConfig config = new ServiceUrlConfig("product", "customer", "order");
        assertEquals("product", config.product());
        assertEquals("customer", config.customer());
        assertEquals("order", config.order());
    }
}
