package Main;

import javax.swing.*;


public class game {

        public static void main(String[] args) {
        JFrame window = new JFrame("ASTEROID") ; // create a window frame
        window.add(new gamePanel()) ; // create a game panel which contains all the game stuff
        window.setResizable(false);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        }
}
