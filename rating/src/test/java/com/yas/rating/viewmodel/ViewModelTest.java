package com.yas.rating.viewmodel;

import com.yas.rating.model.Rating;
import org.junit.jupiter.api.Test;
import java.time.ZonedDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ViewModelTest {

    @Test
    void testCustomerVm() {
        CustomerVm vm = new CustomerVm("user", "email", "first", "last");
        assertEquals("user", vm.username());
        assertEquals("email", vm.email());
        assertEquals("first", vm.firstName());
        assertEquals("last", vm.lastName());
    }

    @Test
    void testErrorVm() {
        ErrorVm vm = new ErrorVm("404", "Not Found", "Detail");
        assertEquals("404", vm.statusCode());
        assertEquals("Not Found", vm.title());
        assertEquals("Detail", vm.detail());
        assertTrue(vm.fieldErrors().isEmpty());

        ErrorVm vm2 = new ErrorVm("400", "Bad", "Detail", List.of("error"));
        assertEquals(1, vm2.fieldErrors().size());
    }

    @Test
    void testOrderExistsByProductAndUserGetVm() {
        OrderExistsByProductAndUserGetVm vm = new OrderExistsByProductAndUserGetVm(true);
        assertTrue(vm.isPresent());
    }

    @Test
    void testRatingListVm() {
        RatingListVm vm = new RatingListVm(List.of(), 10L, 2);
        assertTrue(vm.ratingList().isEmpty());
        assertEquals(10L, vm.totalElements());
        assertEquals(2, vm.totalPages());
    }

    @Test
    void testRatingPostVm() {
        RatingPostVm vm = RatingPostVm.builder()
            .content("Good")
            .star(5)
            .productId(1L)
            .productName("Product")
            .build();
        assertEquals("Good", vm.content());
        assertEquals(5, vm.star());
        assertEquals(1L, vm.productId());
        assertEquals("Product", vm.productName());
    }

    @Test
    void testRatingVm() {
        ZonedDateTime now = ZonedDateTime.now();
        Rating rating = Rating.builder()
            .id(1L)
            .content("Great")
            .ratingStar(5)
            .productId(100L)
            .productName("Phone")
            .lastName("Doe")
            .firstName("John")
            .build();
        rating.setCreatedBy("user");
        rating.setCreatedOn(now);

        RatingVm vm = RatingVm.fromModel(rating);
        assertEquals(1L, vm.id());
        assertEquals("Great", vm.content());
        assertEquals(5, vm.star());
        assertEquals(100L, vm.productId());
        assertEquals("Phone", vm.productName());
        assertEquals("Doe", vm.lastName());
        assertEquals("John", vm.firstName());
        assertEquals("user", vm.createdBy());
        assertEquals(now, vm.createdOn());
        
        RatingVm vmBuilder = RatingVm.builder().id(2L).build();
        assertEquals(2L, vmBuilder.id());
    }

    @Test
    void testResponeStatusVm() {
        ResponeStatusVm vm = new ResponeStatusVm("Title", "Message", "200");
        assertEquals("Title", vm.title());
        assertEquals("Message", vm.message());
        assertEquals("200", vm.statusCode());
    }
}
