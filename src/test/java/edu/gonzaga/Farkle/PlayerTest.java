package edu.gonzaga.Farkle;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PlayerTest {
    @Test
    void NameEntered() {
        Player player = new Player("Maura");
        String givenName = "Maura";
        String actualName = "";
        actualName = player.getName();
        assertEquals(givenName, actualName);
    }
}
