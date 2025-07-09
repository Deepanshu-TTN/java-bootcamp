package com.practice;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StringHelperTest {
    StringHelper stringHelper;

    @Before
    public void setup(){
        stringHelper = new StringHelper();
    }

    @Test
    public void testTruncateAInFirst2Positions_result(){
        assertEquals("BC", stringHelper.truncateAInFirst2Positions("ABC"));
        assertEquals("BC", stringHelper.truncateAInFirst2Positions("AABC"));
        assertEquals("BCA", stringHelper.truncateAInFirst2Positions("BCA"));
    }
    @Test
    public void testTruncateAInFirst2Positions_noChange(){
        assertEquals("BCA", stringHelper.truncateAInFirst2Positions("BCA"));
    }

    @Test
    public void testAreFirstAndLastTwoCharactersTheSame_shortInput() {
        assertFalse(stringHelper.areFirstAndLastTwoCharactersTheSame("A"));
        assertFalse(stringHelper.areFirstAndLastTwoCharactersTheSame("Z"));
    }

    @Test
    public void testAreFirstAndLastTwoCharactersTheSame_2characters() {
        assertTrue(stringHelper.areFirstAndLastTwoCharactersTheSame("AB"));
        assertTrue(stringHelper.areFirstAndLastTwoCharactersTheSame("23"));
    }

    @Test
    public void testAreFirstAndLastTwoCharactersTheSame_moraThan2Characters_positive() {
        assertTrue(stringHelper.areFirstAndLastTwoCharactersTheSame("AAA"));
        assertTrue(stringHelper.areFirstAndLastTwoCharactersTheSame("ABAB"));
        assertTrue(stringHelper.areFirstAndLastTwoCharactersTheSame("XYXY"));
    }

    @Test
    public void testAreFirstAndLastTwoCharactersTheSame_moraThan2Characters_negative() {
        assertFalse(stringHelper.areFirstAndLastTwoCharactersTheSame("ABA"));
        assertFalse(stringHelper.areFirstAndLastTwoCharactersTheSame("AABB"));
        assertFalse(stringHelper.areFirstAndLastTwoCharactersTheSame("ABC"));
    }

}
