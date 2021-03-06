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

        String playerInputRoll = "";
        Scanner s = new Scanner(System.in);
        System.out.println("------------------------------------------------");
        System.out.println("Welcome to Dice Blackjack");
        System.out.println("Hit to roll dice and add them to your score");
        System.out.println("Try not to go over 21, if you do you lose");
        System.out.println("Dealer will hit until their score is at least 16");
        System.out.println("Closest to 21 wins, good luck!");
        System.out.println("------------------------------------------------");
        System.out.println("Would you like to play a game?");
        System.out.println("please enter 'y' or 'n'");
        String playerInputPlay = s.nextLine();
        playerInputPlay = playerInputPlay.toLowerCase();

        while (!(playerInputPlay.equals("n"))) // while loop to encapsulate game
        {
            playerInputRoll = "y";
            switch (playerInputPlay) // switch statement to validate inputs
            {
                case "y":


                    GameEngine game = new GameEngine();
                    // newGame being a method within the game class which intitialises players scores to zero and the players

                    System.out.println("making your initial roll");
                    game.hit(game.getUser());

                    while (!playerInputRoll.equals("n")) // while loop to encapsulate rolling process
                    {
                        System.out.println("Your score is: " + game.getUser().getPlayerScore());

                        // if score is bust player can no longer roll
                        if (game.checkScoreValid(game.getUser())) {
                            System.out.println("Do you wish to roll again? Please enter y/n");
                            playerInputRoll = s.nextLine();
                            playerInputRoll = playerInputRoll.toLowerCase();
                        }
                        else {
                            playerInputRoll = "n";
                        }
                        switch (playerInputRoll)
                        {
                            case "y":
                                game.hit(game.getUser());
                                break;
                            case "n":
                                break;
                            default:
                                System.out.println("Invalid Input");
                                System.out.println("Please be sure to enter correct data");
                        }
                    }
                    // if player did not go bust dealer plays
                    if(game.getUser().getPlayerScore() <= 21){
                        System.out.println("You stand on :" + game.getUser().getPlayerScore());
                        System.out.println("It is the Dealers Turn");
                        System.out.println("Dealer Rolls");
                        game.dealerTurn();
                        try{Thread.sleep(1000);}catch(InterruptedException e){System.out.println(e);}
                        System.out.println("Dealer score is a: " + game.getDealer().getPlayerScore());
                        try{Thread.sleep(1000);}catch(InterruptedException e){System.out.println(e);}
                    } else {
                        System.out.println("You are bust"); //player is bust the player has lost
                    }
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

                    if (game.calculateWinner() == game.getUser()) { // if player has won
                        System.out.println("Congratulations you have won");
                    }
                    else if (game.calculateWinner() == null){ // if result is a draw
                        System.out.println("It is a draw, you failed to win or lose.");
                    }
                    else { // if player loses
                        System.out.println("I'm sorry it appears that the computer has beaten you");
                    }
                    // enquire if user wants to play again and get input
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

