package ac.nz.eit;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameEngineTest_DealerScore22 {
    private GameEngine gameEngine;

    @Before
    public void setup() {
        gameEngine = new GameEngine();
        gameEngine.getDealer().setPlayerScore(22);
    }

    @Test
    public void calculateWinner_whileDealerScoreIs22_shouldReturnUser () {
        Player winner = gameEngine.calculateWinner();
        Player user = gameEngine.getUser();
        assertEquals("While dealer score is over 21, user should win", user, winner);
    }
}
