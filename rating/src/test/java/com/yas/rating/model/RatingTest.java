package com.yas.rating.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RatingTest {

    @Test
    void testRatingGettersAndSetters() {
        Rating rating = new Rating();
        rating.setId(1L);
        rating.setContent("Good");
        rating.setRatingStar(4);
        rating.setProductId(100L);
        rating.setProductName("Test Product");
        rating.setLastName("Nguyen");
        rating.setFirstName("An");

        assertEquals(1L, rating.getId());
        assertEquals("Good", rating.getContent());
        assertEquals(4, rating.getRatingStar());
        assertEquals(100L, rating.getProductId());
        assertEquals("Test Product", rating.getProductName());
        assertEquals("Nguyen", rating.getLastName());
        assertEquals("An", rating.getFirstName());
    }

    @Test
    void testEqualsAndHashCode() {
        Rating r1 = Rating.builder().id(1L).build();
        Rating r2 = Rating.builder().id(1L).build();
        Rating r3 = Rating.builder().id(2L).build();
        Rating r4 = new Rating();

        assertEquals(r1, r2);
        assertNotEquals(r1, r3);
        assertNotEquals(r1, r4);
        assertNotEquals(r1, null);
        assertNotEquals(r1, new Object());
        assertEquals(r1, r1);

        assertEquals(r1.getClass().hashCode(), r1.hashCode());
    }
    
    @Test
    void testBuilderAndAllArgsConstructor() {
        Rating rating = new Rating(1L, "Content", 5, 10L, "PName", "LName", "FName");
        assertEquals(1L, rating.getId());
        assertEquals("Content", rating.getContent());
    }
}
