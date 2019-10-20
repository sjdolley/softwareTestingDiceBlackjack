package ac.nz.eit;

public class Player {
    private int playerScore;

    public void setPlayerScore(int score){
        this.playerScore=score;
    }

    public int getPlayerScore(){
        return this.playerScore;
    }

    public void updateScore(int newScore){
        playerScore += newScore;
    }
}
