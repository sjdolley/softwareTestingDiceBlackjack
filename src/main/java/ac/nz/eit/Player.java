package ac.nz.eit;

public class Player {
    private int playerScore;


    // Constructor initialises player score as 0
    public Player(){
        playerScore = 0;
    }


    public void setPlayerScore(int score){
        this.playerScore=score;
    }

    public int getPlayerScore(){
        return this.playerScore;
    }

    // adds the argument to the playerscore
    public void updateScore(int newScore){
        playerScore += newScore;
    }
}
