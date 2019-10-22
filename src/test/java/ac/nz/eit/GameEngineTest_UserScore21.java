package ac.nz.eit;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameEngineTest_UserScore21 {
    private GameEngine gameEngine;

    @Before
    public void setup() {
        gameEngine = new GameEngine();
        gameEngine.getUser().setPlayerScore(21);
    }

    @Test
    public void checkScore_whileScoreIs21_shouldReturnFalse () {
        boolean checkResult = gameEngine.checkScoreValid(gameEngine.getUser());
        assertFalse("The player score of 21 should return false", checkResult);
    }

    @Test
    public void calculateWinner_whileUserScoreIsHigher_shouldReturnUser () {
        gameEngine.getUser().setPlayerScore(21);
        Player winner = gameEngine.calculateWinner();
        Player user = gameEngine.getUser();
        assertEquals("While user score is higher, user should win", user, winner);
    }
}
