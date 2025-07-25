package com.ttn.service;

import com.ttn.domain.Order;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class EmailServiceTest {

    @Mock
    Order order;

    private static EmailService emailService;

    @BeforeClass
    public static void setUp() {
        emailService = EmailService.getInstance();
    }

    @Test
    public void testSendEmail_exceptionCase() {
        try {
            emailService.sendEmail(order);
            fail("exception not thrown");
        } catch (RuntimeException e){
            assertThat(e.getMessage(), equalTo("An Exception Occurred"));
        }
        verify(order, times(1)).setCustomerNotified(false);
    }

    @Test
    public void testSendEmail_positiveCase() {
        boolean mailSent = emailService.sendEmail(order, "some cc");
        assertTrue(mailSent);
        verify(order, times(1)).setCustomerNotified(true);
    }
}
