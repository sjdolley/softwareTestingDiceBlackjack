package ac.nz.eit;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameEngineTest_UserScore0 {
    private GameEngine gameEngine;

    @Before
    public void setup() {
        gameEngine = new GameEngine();
    }

    @Test
    public void checkScore_whileScoreIs0_shouldReturnTrue () {
        boolean checkResult = gameEngine.checkScoreValid(gameEngine.getUser());
        assertTrue("The player score of 0 should return true", checkResult);
    }

    @Test
    public void dealerTurn_shouldReturnBetween16and27 () {
        gameEngine.dealerTurn();
        int dealerScore = gameEngine.getDealer().getPlayerScore();
        assertTrue("The dealer should finish on a score of at least 16 and no more than 27", dealerScore >= 16 && dealerScore <= 27);
    }

    @Test
    public void hit_shouldReturnAnIncrease () {
        gameEngine.hit(gameEngine.getUser());
        int postScore = gameEngine.getUser().getPlayerScore();
        //int scoreDifference = postScore - preScore;
        assertTrue("Hit should result in an increase of score", postScore > 0);
    }

    @Test
    public void calculateWinner_whileScoresAre0_shouldReturnNull () {
        Player winner = gameEngine.calculateWinner();
        assertNull("While scores are the same, winner should be null", winner);
    }
}
