package ShipGame;

import java.util.Arrays;

public class Ship {
    int[][] positionDetermination;
    int numberOfHits;
    int fieldXInt;
    int fieldYInt;

    boolean correctPositionX;
    boolean correctPositionY;

    int markerX;
    int markerY;

    String result = "";

    public int[][] positionDetermination (int x, int m, int a) {

        int y,z;
        int n,p;
        if (a%2 == 0) {
            x++;
            m++;
            y = x + 1;
            z = x + 2;
            n = m;
            p = m;
        } else {
            x++;
            m++;
            n = m + 1;
            p = m + 2;
            y = x;
            z = x;
        }

        positionDetermination = new int[][]{{m,x}, {n,y}, {p,z}};
        System.out.println(Arrays.deepToString(positionDetermination));

        return positionDetermination;
    }

    String check(String fieldX, String fieldY) {

        fieldXInt = Integer.parseInt(fieldX);
        fieldYInt = Integer.parseInt(fieldY);

        correctPositionX = false;
        correctPositionY = false;

        markerX = 0;
        markerY = 0;

        result = "";

        for (int i = 0; i < positionDetermination.length; i++) {
            for (int j = 0; j < positionDetermination.length-1; j++) {

                if (positionDetermination[i][0] == fieldXInt) {
                    markerX = i;
                    correctPositionX = true;
                }
                if (positionDetermination[i][1] == fieldYInt) {
                    markerY = j;
                    correctPositionY = true;
                }
            }
//            System.out.println(correctPositionX+ " " +correctPositionY);
            if (correctPositionX == true && correctPositionY == true) {
                result = "Trafiony!";
                numberOfHits++;
                System.out.println(markerX + " " + markerY);
                positionDetermination[markerX][0] = 0;
                positionDetermination[markerX][1] = 0;
                correctPositionX = false;
                correctPositionY = false;
                System.out.println("ilość trafień "+ numberOfHits);
                System.out.println(result+ " wewnątrz");
            }
        }
        if (numberOfHits == 3) {
            result = "Zatopiony!!!";
            numberOfHits = 4;
        }
        return result;
    }
}
