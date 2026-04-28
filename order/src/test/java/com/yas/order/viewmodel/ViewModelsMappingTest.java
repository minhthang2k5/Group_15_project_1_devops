package com.yas.order.viewmodel;

import com.yas.order.model.Order;
import com.yas.order.model.OrderAddress;
import com.yas.order.model.OrderItem;
import com.yas.order.model.enumeration.OrderStatus;
import com.yas.order.viewmodel.order.OrderBriefVm;
import com.yas.order.viewmodel.order.OrderGetVm;
import com.yas.order.viewmodel.order.OrderItemGetVm;
import com.yas.order.viewmodel.order.OrderItemVm;
import com.yas.order.viewmodel.order.OrderVm;
import com.yas.order.viewmodel.orderaddress.OrderAddressVm;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ViewModelsMappingTest {

    @Test
    void testOrderAddressVmFromModel() {
        OrderAddress address = new OrderAddress();
        address.setId(1L);
        address.setPhone("123456");
        address.setAddressLine1("Line1");
        address.setCity("City");
        address.setZipCode("Zip");
        address.setDistrict("District");
        address.setStateOrProvince("State");
        address.setCountryId(1L);
        address.setCountryName("Country");

        OrderAddressVm vm = OrderAddressVm.fromModel(address);
        assertNotNull(vm);
        assertEquals(1L, vm.id());
        assertEquals("123456", vm.phone());
        assertEquals("Line1", vm.addressLine1());
        assertEquals("City", vm.city());
        assertEquals("Zip", vm.zipCode());
        assertEquals("District", vm.district());
        assertEquals("State", vm.stateOrProvince());
        assertEquals(1L, vm.countryId());
        assertEquals("Country", vm.countryName());
    }

    @Test
    void testOrderItemVmFromModel() {
        OrderItem item = new OrderItem();
        item.setId(1L);
        item.setProductId(100L);
        item.setProductName("Product 1");
        item.setQuantity(2);
        item.setProductPrice(BigDecimal.TEN);
        item.setNote("Note");
        item.setDiscountAmount(BigDecimal.ONE);
        item.setTaxAmount(BigDecimal.ZERO);
        item.setTaxPercent(BigDecimal.ZERO);

        OrderItemVm vm = OrderItemVm.fromModel(item);
        assertEquals(1L, vm.id());
        assertEquals(100L, vm.productId());
        assertEquals("Product 1", vm.productName());
        assertEquals(2, vm.quantity());
    }

    @Test
    void testOrderItemGetVmFromModel() {
        OrderItem item = new OrderItem();
        item.setId(1L);
        item.setProductId(100L);
        item.setProductName("Product 1");
        item.setQuantity(2);
        item.setProductPrice(BigDecimal.TEN);
        item.setNote("Note");
        item.setDiscountAmount(BigDecimal.ONE);
        item.setTaxAmount(BigDecimal.ZERO);
        item.setTaxPercent(BigDecimal.ZERO);

        OrderItemGetVm vm = OrderItemGetVm.fromModel(item);
        assertEquals(1L, vm.id());
        assertEquals(100L, vm.productId());

        var list = OrderItemGetVm.fromModels(Set.of(item));
        assertEquals(1, list.size());
    }

    @Test
    void testOrderVmFromModel() {
        Order order = new Order();
        order.setId(1L);
        order.setEmail("test@email.com");
        order.setPhone("123456789");
        order.setOrderStatus(OrderStatus.PENDING);
        order.setTotalPrice(BigDecimal.valueOf(100));
        order.setTotalDiscount(BigDecimal.TEN);
        order.setDeliveryFee(BigDecimal.ZERO);
        order.setDeliveryMethod("STANDARD");
        order.setPaymentMethod("CREDIT_CARD");

        OrderAddress billing = new OrderAddress();
        billing.setId(10L);
        order.setBillingAddressId(billing);

        OrderAddress shipping = new OrderAddress();
        shipping.setId(20L);
        order.setShippingAddressId(shipping);

        OrderItem item = new OrderItem();
        item.setId(1L);
        item.setProductId(100L);
        item.setQuantity(1);

        OrderVm vm = OrderVm.fromModel(order, Set.of(item));
        assertNotNull(vm);
        assertEquals(1L, vm.id());
        assertEquals(1, vm.orderItemVms().size());
        assertEquals(20L, vm.shippingAddressVm().id());
        assertEquals(10L, vm.billingAddressVm().id());
    }
    
    @Test
    void testOrderGetVmFromModel() {
        Order order = new Order();
        order.setId(1L);
        order.setEmail("test@email.com");
        order.setPhone("123456789");
        order.setOrderStatus(OrderStatus.PENDING);
        order.setTotalPrice(BigDecimal.valueOf(100));
        order.setTotalDiscount(BigDecimal.TEN);
        order.setDeliveryFee(BigDecimal.ZERO);
        order.setDeliveryMethod("STANDARD");
        order.setPaymentMethod("CREDIT_CARD");

        OrderGetVm vm = OrderGetVm.fromModel(order, Set.of());
        assertNotNull(vm);
        assertEquals(1L, vm.id());
    }
    
    @Test
    void testOrderBriefVmFromModel() {
        Order order = new Order();
        order.setId(1L);
        order.setEmail("test@email.com");
        order.setPhone("123456789");
        order.setOrderStatus(OrderStatus.PENDING);
        order.setTotalPrice(BigDecimal.valueOf(100));

        OrderBriefVm vm = OrderBriefVm.fromModel(order);
        assertNotNull(vm);
        assertEquals(1L, vm.id());
    }

}
