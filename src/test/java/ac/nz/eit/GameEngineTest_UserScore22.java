package ac.nz.eit;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameEngineTest_UserScore22 {
    private GameEngine gameEngine;

    @Before
    public void setup() {
        gameEngine = new GameEngine();
        gameEngine.getUser().setPlayerScore(22);
    }

    @Test
    public void checkScore_whileScoreIs22_shouldReturnFalse () {
        boolean checkResult = gameEngine.checkScoreValid(gameEngine.getUser());
        assertFalse("The player score of 22 should return false", checkResult);
    }

    @Test
    public void calculateWinner_whileUserScoreIs22_shouldReturnDealer () {
        Player winner = gameEngine.calculateWinner();
        Player dealer = gameEngine.getDealer();
        assertEquals("While user score is over 21, dealer should win", dealer, winner);
    }
}
