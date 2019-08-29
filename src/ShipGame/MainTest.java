package ShipGame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    Main main = new Main();

    @Test
    void controlValuesInTheRange() {
        assertEquals(1, main.control("7","7"));
    }

    @Test
    void controlValuesOutOfTheRange() {
        assertEquals(0, main.control("9","7"));
    }

    @Test
    void controlNotNumbers() {
        assertEquals(0, main.control("sag","htreg"));
    }
    
}