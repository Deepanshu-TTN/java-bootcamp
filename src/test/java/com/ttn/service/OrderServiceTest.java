package com.ttn.service;

import com.ttn.domain.Order;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(Parameterized.class)
public class OrderServiceTest {

    private final double basePrice;
    private final String cc;
    private final boolean expectedNotify;
    private final double expectedTax;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    Order order;
    OrderService orderService;

    public OrderServiceTest(double basePrice, String cc, boolean expectedNotify, double expectedTax) {
        this.basePrice = basePrice;
        this.cc = cc;
        this.expectedNotify = expectedNotify;
        this.expectedTax = expectedTax;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {100.0, "cc1@test.com", true, 20.0},
                {200.0, "cc2@test.com", true, 40.0},
                {50.0,  "cc3@test.com", true, 10.0}
        });
    }

    @Before
    public void setup(){
        orderService = OrderService.getInstance();
    }

    @Test
    public void testPlaceOrder_withoutCC() {
        when(order.getPrice()).thenReturn(100d);
        try{
            orderService.placeOrder(order);
        } catch(RuntimeException _){} //we know
        verify(order, times(1)).setPriceWithTax(100d*20/100);
        verify(order, times(1)).setCustomerNotified(false);
        verify(order, times(1)).setCustomerNotified(true);
    }


    @Test
    public void testPlaceOrder_withCC_parameterized() {
        when(order.getPrice()).thenReturn(basePrice);

        boolean result = orderService.placeOrder(order, cc);

        assertEquals(expectedNotify, result);
        verify(order).getPrice();
        verify(order).setPriceWithTax(expectedTax);
        verify(order, times(2)).setCustomerNotified(expectedNotify);
    }
}
