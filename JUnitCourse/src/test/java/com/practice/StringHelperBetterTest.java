package com.practice;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class StringHelperBetterTest {
    public String expected;
    public String actual;
    public StringHelper stringHelper;

    @Before
    public void setup(){
        stringHelper = new StringHelper();
    }

    @Parameters
    public static Collection<String[]> conditions(){
        return Arrays.asList(new String[][] {
                {"ABC", "BC"},
                {"AABC", "BC"},
                {"BCA", "BCA"},
                {"AAABC", "ABC"},
        });
    }

    public StringHelperBetterTest(String actual, String expected) {
        this.actual = actual;
        this.expected = expected;
    }

    @Test
    public void testTruncateAInFirst2Positions(){
        assertEquals(expected, stringHelper.truncateAInFirst2Positions(actual));
    }
}
