package ShipGame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShipTest {

    Ship ship = new Ship();

    @Test
    void checkPositionLowestValueOfRangeVerticalOrientation() {

        assertArrayEquals(new int[][] {{1, 1}, {1, 2}, {1, 3}}, ship.positionDetermination(0,0,0));
    }
    @Test
    void checkPositionLowestValueOfRangeHorizontalOrientation() {

        assertArrayEquals(new int[][] {{1, 1}, {2, 1}, {3, 1}}, ship.positionDetermination(0,0,1));
    }
    @Test
    void checkPositionHighestValueOfRangeVerticalOrientation() {

        assertArrayEquals(new int[][] {{6, 6}, {7, 6}, {8, 6}}, ship.positionDetermination(5,5,5));
    }
    @Test
    void checkPositionHighestValueOfRangeHorizontalOrientation() {

        assertArrayEquals(new int[][] {{6, 6}, {6, 7}, {6, 8}}, ship.positionDetermination(5,5,4));
    }

    @Test
    void checkIfHitAndThirdHitDestroyShip() {

        ship.positionDetermination(4,4,1);
        assertEquals("Trafiony!", ship.check("5","5"));
        assertEquals("Trafiony!", ship.check("6","5"));
        assertNotEquals("Trafiony!", ship.check("6","5"));
        assertNotEquals("Trafiony!", ship.check("6","6"));
        assertEquals("Zatopiony!!!", ship.check("7","5"));
        assertNotEquals("Trafiony!", ship.check("6","5"));


    }



}