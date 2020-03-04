/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpsgame;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author matthewbelgre
 */
public class RPSgame {

    public static void main(String[] args) {

        Player player1 = new Player("Alice");
        Player player2 = new Player("Bob");

        System.out.println(player1.getName() + " shows "
                + player1.makeHandshape());
        System.out.println(player2.getName() + " shows "
                + player2.makeHandshape());

        System.out.println(Player.findWinner(player1, player2) + "  wins!");

    }

}

class Player {

    private String name;
    private int hand;

    public Player(String name) {
        this.name = name;
    }

    public Player(String name, int hand) {
        this.name = name;
        this.hand = hand;
    }

    public String getName() {
        return name;
    }

    public int getHandshape() {
        return hand;
    }

    public int makeHandshape() {

        hand = (int) (Math.random() * 3 + 1);
//        String handName = "Nothing";
//       switch(hand){
//           case 1:
//               handName = "Rock";
//               break;
//           case 2:
//               handName = "Scissors";
//               break;
//           case 3:
//               handName = "Paper";
//               break;
//       }

        return hand;
    }

    public String getShape() {
        switch (hand) {
            case 1:
                return "Rock";
            case 2:
                return "Scissors";
            case 3:
                return "Paper";
        }
        return null;
    }

    public static String findWinner(Player player1, Player player2) {
        String winner = "";
        if (player1.getHandshape() == 1 && player2.getHandshape() == 1
                || player1.getHandshape() == 2 && player2.getHandshape() == 2
                || player1.getHandshape() == 3 && player2.getHandshape() == 3) {
            winner = "No one";
        } else if (player1.getHandshape() == 1 && player2.getHandshape() == 2) {
            winner = player1.getName();
        } else if (player1.getHandshape() == 2 && player2.getHandshape() == 1) {
            winner = player2.getName();
        } else if (player1.getHandshape() == 2 && player2.getHandshape() == 3) {
            winner = player1.getName();
        } else if (player1.getHandshape() == 3 && player2.getHandshape() == 2) {
            winner = player2.getName();
        } else if (player1.getHandshape() == 1 && player2.getHandshape() == 3) {
            winner = player2.getName();
        } else if (player1.getHandshape() == 3 && player2.getHandshape() == 1) {
            winner = player1.getName();
        };

        //  rock = 1
        //scissors = 2
        //paper =3
        // Task IV.2 
        return winner;
    }

    public static ImageIcon ImageSelection(int choice) {
        ImageIcon imageIcon = null;
        switch (choice) {
            case 1:
                imageIcon = new ImageIcon("/Users/matthewbelgre/NetBeansProjects/RPSgame/src/rpsgame/rockLeft.jpeg"); // load the image to a imageIcon
                break;
            case 2:
                imageIcon = new ImageIcon("/Users/matthewbelgre/NetBeansProjects/RPSgame/src/rpsgame/scissorLeft.jpeg"); // load the image to a imageIcon
                break;
            case 3:
                imageIcon = new ImageIcon("/Users/matthewbelgre/NetBeansProjects/RPSgame/src/rpsgame/paperLeft.jpeg"); // load the image to a imageIcon
                break;
            case 4:
                imageIcon = new ImageIcon("/Users/matthewbelgre/NetBeansProjects/RPSgame/src/rpsgame/rockRight.jpeg"); // load the image to a imageIcon
                break;
            case 5:
                imageIcon = new ImageIcon("/Users/matthewbelgre/NetBeansProjects/RPSgame/src/rpsgame/scissorRight.jpeg"); // load the image to a imageIcon
                break;
            case 6:
                imageIcon = new ImageIcon("/Users/matthewbelgre/NetBeansProjects/RPSgame/src/rpsgame/paperRight.jpeg"); // load the image to a imageIcon
                break;
            default:
                break;
        }
        Image image = imageIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(300, 200, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        imageIcon = new ImageIcon(newimg);
        return imageIcon;
    }
}
