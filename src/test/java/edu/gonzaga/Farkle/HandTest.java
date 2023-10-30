package edu.gonzaga.Farkle;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import static org.mockito.Mockito.*;

class HandTest {
    /*@Test
    void HotHand_NotFound() {
        ArrayList<Integer> testDie =  new ArrayList<Integer>(Arrays.asList(0, 5, 3, 1, 5, 2, 2));
        boolean expectedValue = false;
        boolean actualValue;
        Hand hand = new Hand(testDie);

        Hand handMock = mock(Hand.class);
        when(handMock.hotHandTrue()).thenReturn('A');
        actualValue = handMock.checkForHotHand();

        assertEquals(expectedValue, actualValue);
    }
    @Test
    void HotHand_Found() {
        ArrayList<Integer> testDie =  new ArrayList<Integer>(Arrays.asList(0, 1, 5, 3, 5, 3, 3));
        boolean expectedValue = true;
        boolean actualValue;
        Hand hand = new Hand(testDie);

        Hand handMock = mock(Hand.class);
        when(handMock.hotHandTrue()).thenReturn('A');
        actualValue = handMock.checkForHotHand(hand);

        assertEquals(expectedValue, actualValue);
    }*/
    @Test
    void Farkle_NotTrue() {
        ArrayList<Integer> testDie =  new ArrayList<Integer>(Arrays.asList(0, 1, 5, 3, 5, 3, 3));
        boolean expectedValue = false;
        boolean actualValue;
        Hand hand = new Hand(testDie);
        actualValue = hand.checkForFarkle();
        assertEquals(expectedValue, actualValue);
    }
    @Test
    void Farkle_True() {
        ArrayList<Integer> testDie =  new ArrayList<Integer>(Arrays.asList(0, 2, 2, 6, 4, 3, 3));
        boolean expectedValue = true;
        boolean actualValue;
        Hand hand = new Hand(testDie);
        actualValue = hand.checkForFarkle();
        assertEquals(expectedValue, actualValue);
    }
}

