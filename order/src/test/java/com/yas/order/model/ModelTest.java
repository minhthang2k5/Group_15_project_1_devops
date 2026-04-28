package com.yas.order.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

class ModelTest {

    @Test
    void testCheckoutItem() {
        CheckoutItem item1 = new CheckoutItem();
        item1.setId(1L);
        item1.setProductId(100L);
        
        CheckoutItem item2 = new CheckoutItem();
        item2.setId(1L);
        item2.setProductId(100L);

        CheckoutItem item3 = new CheckoutItem();
        item3.setId(2L);
        
        CheckoutItem item4 = new CheckoutItem();

        assertEquals(item1, item1);
        assertEquals(item1, item2);
        assertNotEquals(item1, item3);
        assertNotEquals(item1, item4);
        assertNotEquals(item1, null);
        assertNotEquals(item1, new Object());
        
        assertEquals(item1.getClass().hashCode(), item1.hashCode());
    }

    @Test
    void testOrder() {
        Order order = new Order();
        order.setId(1L);
        order.setEmail("test@email.com");
        
        Order order2 = new Order();
        order2.setId(1L);
        
        assertEquals(order, order2);
        assertEquals(order.getClass().hashCode(), order.hashCode());
    }
    
    @Test
    void testCheckout() {
        Checkout checkout = new Checkout();
        checkout.setId("checkout-1");
        checkout.setEmail("test@email.com");
        
        Checkout checkout2 = new Checkout();
        checkout2.setId("checkout-1");
        
        assertEquals(checkout, checkout2);
        assertEquals(checkout.getClass().hashCode(), checkout.hashCode());
    }
}
