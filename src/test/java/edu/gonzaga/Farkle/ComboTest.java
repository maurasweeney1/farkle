package edu.gonzaga.Farkle;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;


public class ComboTest {
    @Test
    void straightCombo_NotFound() {
        ArrayList<Integer> testDie =  new ArrayList<Integer>(Arrays.asList(0, 2, 2, 2, 2, 2, 2));
        Integer expectedScore = 0;
        Integer actualScore = 0;
        Combo combo = new Combo();

        for (int i = 1; i < 7; i++) {
            combo.addToComboArr(testDie.get(i));
        }
        combo.CheckForStraight();
        actualScore = combo.returnScore();
        assertEquals(expectedScore, actualScore);
    }

    @Test
    void straightCombo_Found() {
        ArrayList<Integer> testDie =  new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5, 6));
        Integer expectedScore = 1000;
        Integer actualScore = 0;
        Combo combo = new Combo();

        for (int i = 1; i < 7; i++) {
            combo.addToComboArr(testDie.get(i));
        }
        combo.CheckForStraight();
        actualScore = combo.returnScore();
        assertEquals(expectedScore, actualScore);
    }

    @Test
    void Triples_NotFound() {
        ArrayList<Integer> testDie =  new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 2, 5, 3));
        Integer expectedScore = 0;
        Integer actualScore = 0;
        Combo combo = new Combo();

        for (int i = 1; i < 7; i++) {
            combo.addToComboArr(testDie.get(i));
        }
        combo.checkForTriples();
        actualScore = combo.returnScore();
        assertEquals(expectedScore, actualScore);
    }

    @Test
    void Triples_Found() {
        ArrayList<Integer> testDie =  new ArrayList<Integer>(Arrays.asList(0, 6, 2, 6, 6, 5, 3));
        Integer expectedScore = 600;
        Integer actualScore = 0;
        Combo combo = new Combo();

        for (int i = 1; i < 7; i++) {
            combo.addToComboArr(testDie.get(i));
        }
        combo.checkForTriples();
        actualScore = combo.returnScore();
        assertEquals(expectedScore, actualScore);
    }

    @Test
    void Quad_NotFound() {
        ArrayList<Integer> testDie =  new ArrayList<Integer>(Arrays.asList(0, 3, 3, 4, 2, 5, 3));
        Integer expectedScore = 0;
        Integer actualScore = 0;
        Combo combo = new Combo();

        for (int i = 1; i < 7; i++) {
            combo.addToComboArr(testDie.get(i));
        }
        combo.checkForQuads();
        actualScore = combo.returnScore();
        assertEquals(expectedScore, actualScore);
    }
    
    @Test
    void Quad_Found() {
        ArrayList<Integer> testDie =  new ArrayList<Integer>(Arrays.asList(0, 2, 1, 2, 2, 2, 3));
        Integer expectedScore = 400;
        Integer actualScore = 0;
        Combo combo = new Combo();

        for (int i = 1; i < 7; i++) {
            combo.addToComboArr(testDie.get(i));
        }
        combo.checkForQuads();
        actualScore = combo.returnScore();
        assertEquals(expectedScore, actualScore);
    }

    @Test
    void Quint_NotFound() {
        ArrayList<Integer> testDie =  new ArrayList<Integer>(Arrays.asList(0, 2, 1, 2, 2, 2, 3));
        Integer expectedScore = 0;
        Integer actualScore = 0;
        Combo combo = new Combo();

        for (int i = 1; i < 7; i++) {
            combo.addToComboArr(testDie.get(i));
        }
        combo.checkForQuints();
        actualScore = combo.returnScore();
        assertEquals(expectedScore, actualScore);
    }

    @Test
    void Quint_Found() {
        ArrayList<Integer> testDie =  new ArrayList<Integer>(Arrays.asList(0, 1, 1, 1, 2, 1, 1));
        Integer expectedScore = 3000;
        Integer actualScore = 0;
        Combo combo = new Combo();

        for (int i = 1; i < 7; i++) {
            combo.addToComboArr(testDie.get(i));
        }
        combo.checkForQuints();
        actualScore = combo.returnScore();
        assertEquals(expectedScore, actualScore);
    }

    @Test
    void Hex_NotFound() {
        ArrayList<Integer> testDie =  new ArrayList<Integer>(Arrays.asList(0, 2, 2, 5, 2, 2, 2));
        Integer expectedScore = 0;
        Integer actualScore = 0;
        Combo combo = new Combo();

        for (int i = 1; i < 7; i++) {
            combo.addToComboArr(testDie.get(i));
        }
        combo.checkForHex();
        actualScore = combo.returnScore();
        assertEquals(expectedScore, actualScore);
    }

    @Test
    void Hex_Found() {
        ArrayList<Integer> testDie =  new ArrayList<Integer>(Arrays.asList(0, 2, 2, 2, 2, 2, 2));
        Integer expectedScore = 800;
        Integer actualScore = 0;
        Combo combo = new Combo();

        for (int i = 1; i < 7; i++) {
            combo.addToComboArr(testDie.get(i));
        }
        combo.checkForHex();
        actualScore = combo.returnScore();
        assertEquals(expectedScore, actualScore);
    }

    @Test
    void TripleDouble_NotFound() {
        ArrayList<Integer> testDie =  new ArrayList<Integer>(Arrays.asList(0, 2, 3, 3, 3, 5, 5));
        Integer expectedScore = 0;
        Integer actualScore = 0;
        Combo combo = new Combo();

        for (int i = 1; i < 7; i++) {
            combo.addToComboArr(testDie.get(i));
        }
        combo.checkForTripleDouble();
        actualScore = combo.returnScore();
        assertEquals(expectedScore, actualScore);
    }

    @Test
    void TripleDouble_Found() {
        ArrayList<Integer> testDie =  new ArrayList<Integer>(Arrays.asList(0, 2, 2, 3, 3, 5, 5));
        Integer expectedScore = 750;
        Integer actualScore = 0;
        Combo combo = new Combo();

        for (int i = 1; i < 7; i++) {
            combo.addToComboArr(testDie.get(i));
        }
        combo.checkForTripleDouble();
        actualScore = combo.returnScore();
        assertEquals(expectedScore, actualScore);
    }

    @Test
    void One_NotFound() {
        ArrayList<Integer> testDie =  new ArrayList<Integer>(Arrays.asList(0, 4, 3, 5, 6, 2, 2));
        Integer expectedScore = 0;
        Integer actualScore = 0;
        Combo combo = new Combo();

        for (int i = 1; i < 7; i++) {
            combo.addToComboArr(testDie.get(i));
        }
        
        combo.checkForOnes();
        actualScore = combo.returnScore();
        assertEquals(expectedScore, actualScore);
    }

    @Test
    void One_Found() {
        ArrayList<Integer> testDie =  new ArrayList<Integer>(Arrays.asList(0, 4, 3, 1, 6, 2, 2));
        Integer expectedScore = 100;
        Integer actualScore = 0;
        Combo combo = new Combo();

        for (int i = 1; i < 7; i++) {
            combo.addToComboArr(testDie.get(i));
        }
        combo.checkForOnes();
        actualScore = combo.returnScore();
        assertEquals(expectedScore, actualScore);
    }

    @Test
    void TwoOnes_Found() {
        ArrayList<Integer> testDie =  new ArrayList<Integer>(Arrays.asList(0, 1, 3, 1, 6, 2, 2));
        Integer expectedScore = 200;
        Integer actualScore = 0;
        Combo combo = new Combo();

        for (int i = 1; i < 7; i++) {
            combo.addToComboArr(testDie.get(i));
        }
        combo.checkForOnes();
        actualScore = combo.returnScore();
        assertEquals(expectedScore, actualScore);
    }

    @Test
    void Five_NotFound() {
        ArrayList<Integer> testDie =  new ArrayList<Integer>(Arrays.asList(0, 4, 3, 1, 6, 2, 2));
        Integer expectedScore = 0;
        Integer actualScore = 0;
        Combo combo = new Combo();

        for (int i = 1; i < 7; i++) {
            combo.addToComboArr(testDie.get(i));
        }
        combo.checkForFives();
        actualScore = combo.returnScore();
        assertEquals(expectedScore, actualScore);
    }

    @Test
    void Five_Found() {
        ArrayList<Integer> testDie =  new ArrayList<Integer>(Arrays.asList(0, 4, 3, 5, 6, 2, 2));
        Integer expectedScore = 50;
        Integer actualScore = 0;
        Combo combo = new Combo();

        for (int i = 1; i < 7; i++) {
            combo.addToComboArr(testDie.get(i));
        }
        combo.checkForFives();
        actualScore = combo.returnScore();
        assertEquals(expectedScore, actualScore);
    }

    @Test
    void TwoFives_Found() {
        ArrayList<Integer> testDie =  new ArrayList<Integer>(Arrays.asList(0, 5, 3, 1, 5, 2, 2));
        Integer expectedScore = 100;
        Integer actualScore = 0;
        Combo combo = new Combo();

        for (int i = 1; i < 7; i++) {
            combo.addToComboArr(testDie.get(i));
        }
        combo.checkForFives();
        actualScore = combo.returnScore();
        assertEquals(expectedScore, actualScore);
    }

/*@Test
    void BadMeld_True() {
        ArrayList<Integer> testDie =  new ArrayList<Integer>(Arrays.asList(0, 5, 3, 1, 5, 2, 2));
        boolean expectedValue = true;
        boolean actualValue;
        Combo combo = new Combo();

        for (int i = 1; i < 7; i++) {
            combo.addToComboArr(testDie.get(i));
        }
        combo.calculateScore();
        actualValue = combo.checkForBadMeld();
        assertEquals(expectedValue, actualValue);
    }*/
}