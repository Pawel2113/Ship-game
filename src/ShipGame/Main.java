package ShipGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    private JButton shoot;
    private JTextField coordinateX;
    private JTextField coordinateY;
    private JLabel result;
    private JLabel inputX;
    private JLabel inputY;
    private JPanel panelMain;
    static Ship titanic = new Ship();
    static Ship aurora = new Ship();
    static Ship bismarck = new Ship();
    static Ship gustloff = new Ship();
    static ArrayList<Ship> ships = new ArrayList<>();

    private static String fieldX = "2";
    private static String fieldY = "3";
    private static String roundResult = "początek";
    private static int control;
    private static int iloscProb = 0;
    private static String errorMessange = "";
    private static boolean win = false;
    private static int replay;

    public Main() {
        JOptionPane.showMessageDialog(null, "Ahoj Kapitanie!!! \n" +
                "Musisz się ponownie rzucić w wir walki. Na nasze morze wpłynęły 4 wrogie okręty. \n" +
                "Aby zniszczyć statki przeciwnika należy określić ich pozycję.");


        shoot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fieldX = coordinateY.getText();
                fieldY = coordinateX.getText();

                result.setText(" ");
                control(fieldX, fieldY);
                startGame();
                result.setText(iloscProb + " strzał i " + roundResult);

                if (win == true) {
                    Object[] options = {"Zagraj jeszcze raz", "Wyjdź z gry"};
                    int reply = JOptionPane.showOptionDialog(null, "wygrałeś!!! \n"
                            + "potrzebowałeś " + iloscProb + " prób, by zniszczyć wszytkie statki", "Zwycięstwo!!!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                    if (reply == JOptionPane.YES_OPTION) {
                        randomisation();
                        coordinateY.setText("");
                        coordinateX.setText("");
                        result.setText("");
                        titanic.numberOfHits = 0;
                        aurora.numberOfHits = 0;
                        bismarck.numberOfHits = 0;
                        gustloff.numberOfHits = 0;
                        iloscProb = 0;
                        win = false;
                    } else {
                        JOptionPane.showMessageDialog(null, "Dziękuję za zagranie w grę. Do zobaczenia");
                        System.exit(0);
                    }
                }
            }

        });

    }

    int control(String fieldX, String fieldY) {
        control = 0;


//        while (kontrola < 1) {
        System.out.println("to ma być napisx " + fieldX);
        System.out.println("to ma być napisy " + fieldY);

        System.out.println("Podaj współrzędną x - od 1 do 8");


        if (fieldX.equals("1") || fieldX.equals("2") || fieldX.equals("3") || fieldX.equals("4") ||
                fieldX.equals("5") || fieldX.equals("6") || fieldX.equals("7") || fieldX.equals("8")) {
            System.out.println("Podaj współrzędną y - od 1 do 8");
            if (fieldY.equals("1") || fieldY.equals("2") || fieldY.equals("3") || fieldY.equals("4") ||
                    fieldY.equals("5") || fieldY.equals("6") || fieldY.equals("7") || fieldY.equals("8")) {
                control = 1;
//                System.out.println(control);
            } else {
                errorMessange = "Kapitanie!!! Niech pan Kapitan chociaż w morze trafi i amunicji nie marnuje!!! Musi Kapitan podać cyfre od 1 do 8";
                JOptionPane.showMessageDialog(null, errorMessange);
            }
        } else {
            errorMessange = "Kapitanie!!! Niech pan Kapitan chociaż w morze trafi i amunicji nie marnuje!!! Musi Kapitan podać cyfre od 1 do 8";
            JOptionPane.showMessageDialog(null, errorMessange);
        }
//        }
        return control;
    }

    private static void startGame() {

        for (Ship s : ships) {
            String shootResult = s.check(fieldX, fieldY);
            if (shootResult.equals("Zatopiony!!!")) {
//                System.out.println("Zatopiony!!!");
                roundResult = shootResult;
                break;
            } else if (shootResult.equals("Trafiony!")) {
//                System.out.println("Trafiony!");
                roundResult = shootResult;
                break;
            } else {
//                System.out.println("pudło");
                roundResult = "pudło";
            }
        }
        iloscProb++;
        if (titanic.numberOfHits == 4 && aurora.numberOfHits == 4 && bismarck.numberOfHits == 4 && gustloff.numberOfHits == 4) {
            win = true;
        }
    }

    private static void randomisation() {

        Random r = new Random();
        int x, m, a;

        for (Ship s : ships) {
            x = r.nextInt(6);
            m = r.nextInt(6);
            a = r.nextInt(6);
            s.positionDetermination(x, m, a);
        }
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("ShipGame");
        frame.setContentPane(new Main().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        ships.add(titanic);
        ships.add(aurora);
        ships.add(bismarck);
        ships.add(gustloff);

        randomisation();
    }


    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panelMain = new JPanel();
        panelMain.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(6, 1, new Insets(10, 10, 30, 10), -1, -1));
        result = new JLabel();
        result.setText("");
        panelMain.add(result, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        coordinateX = new JTextField();
        panelMain.add(coordinateX, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        coordinateY = new JTextField();
        panelMain.add(coordinateY, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        shoot = new JButton();
        shoot.setText("Kliknij, by strzelić");
        panelMain.add(shoot, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        inputX = new JLabel();
        inputX.setText("Wprowadź współrzędną X");
        panelMain.add(inputX, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        inputY = new JLabel();
        inputY.setText("Wprowadź współrzędną Y");
        panelMain.add(inputY, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panelMain;
    }
}