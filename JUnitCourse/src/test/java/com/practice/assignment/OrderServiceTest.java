package com.practice.assignment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class OrderServiceTest {
    Order order;
    OrderService orderService;

    @Before
    public void setup(){
        order = new Order(10, "Cat Treat", 80);
        orderService = OrderService.getInstance();
    }

    @Test
    public void testGetInstance() {
        OrderService o1 = OrderService.getInstance();
        OrderService o2 = OrderService.getInstance();
        assertSame(o1, o2);
    }

    @Test
    public void testPlaceOrder_withoutCC() {
        // should fail and throw exception
        // also cant check internal state using only just junit
        orderService.placeOrder(order);
    }

    @Test
    public void testPlaceOrder_withCC(){
        boolean actual = orderService.placeOrder(order, "some cc");
        boolean expected = order.isCustomerNotified();
        assertEquals(expected, actual);
    }
}
