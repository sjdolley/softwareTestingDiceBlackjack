package ac.nz.eit;

import java.lang.*;
import java.io.*;
import java.util.*;

/**
 * Dice Blackjack
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        String playerInputPlay = "";
        String playerInputRoll = "";
        Scanner s = new Scanner(System.in);

        while (!(playerInputPlay.equals("n")))
        {
            System.out.println("Would you like to play a game?");
            System.out.println("please enter 'y' or 'n'");
            playerInputPlay = s.nextLine();
            playerInputPlay = playerInputPlay.toLowerCase();
            switch (playerInputPlay)
            {
                case "y":


                    GameEngine game = new GameEngine();

                    // newGame being a method within the game class which intitialises players scores to zero and the players

                    System.out.println("making your initial roll");
                    game.hit(game.getUser());

                    while (!playerInputRoll.equals("n"))
                    {
                        System.out.println("Your score is: " + game.getUser().getPlayerScore());
                        if (game.checkScoreValid(game.getUser())) {
                            System.out.println("Do you wish to roll again");
                            playerInputRoll = s.nextLine();
                            playerInputRoll = playerInputRoll.toLowerCase();
                        }
                        else {
                            System.out.println("You are bust");
                            playerInputRoll = "n";
                        }
                        switch (playerInputRoll)
                        {
                            case "y":
                                game.hit(game.getUser());
                                break;
                            case "n":
                                System.out.println("You stand on :" + game.getUser().getPlayerScore());
                                break;
                            default:
                                System.out.println("Invalid Input");
                                System.out.println("Please be sure to enter correct data");
                        }
                    }
                    System.out.println("It is the Dealers Turn");
                    System.out.println("Dealer Rolls");
                    game.dealerTurn();
                    try{Thread.sleep(1000);}catch(InterruptedException e){System.out.println(e);}
                    System.out.println("Dealer score is a: " + game.getDealer().getPlayerScore());
                    try{Thread.sleep(1000);}catch(InterruptedException e){System.out.println(e);}
                    /* while (AI.getPlayerScore<16)
                    {
                        System.out.println("Dealer Hits Again");
                        try{Thread.sleep(1000);}catch(InterruptedException e){System.out.println(e);}
                        AI.dealerTurn();
                        System.out.println("Dealer Score after roll: " + AI.getPlayerScore())
                    }
                    if (AI.getPlayerScore()>21){
                        System.out.println("Dealer goes Bust");
                    }
                    else {
                        System.out.println("Dealer sits on :" + AI.getPlayerScore())
                    }
                    System.out.println("And the winner is: " + calculateWinner());
                    try{Thread.sleep(1000);}catch(InterruptedException e){System.out.println(e);}
                    System.out.println("This game has finished");
                    */

                    if (game.calculateWinner() == game.getUser()) {
                        System.out.println("Congratulations you have won");
                    }
                    else {
                        System.out.println("I'm sorry it appears that the computer has beaten you");
                    }

                    System.out.println("Would you like to play again? Please enter y or n");
                    playerInputPlay = s.nextLine();
                    playerInputPlay = playerInputPlay.toLowerCase();

                    break;

                default:
                    System.out.println("Warning Invalid Input");
                    System.out.println("Please enter y or n");
                    playerInputPlay = s.nextLine();
                    playerInputPlay = playerInputPlay.toLowerCase();
            }



        }
    }
}

