package com.practice.assignment;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

public class EmailServiceTest {
    static EmailService e;

    @BeforeClass
    public static void setup() {
        e = EmailService.getInstance();
    }
    @Test
    public void testGetInstance() {
        EmailService e1 = e;
        EmailService e2 = EmailService.getInstance();
        assertSame(e1, e2);
    }

    @Test(expected = RuntimeException.class)
    public void testSendEmail_exceptionCase() {
        e.sendEmail(new Order());
    }

    @Test
    public void testSendEmail_positiveCase() {
        assertTrue(e.sendEmail(new Order(), "some cc"));
    }
}
