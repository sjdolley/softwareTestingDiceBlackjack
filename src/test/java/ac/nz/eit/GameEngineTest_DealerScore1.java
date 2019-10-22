package ac.nz.eit;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameEngineTest_DealerScore1 {
    private GameEngine gameEngine;

    @Before
    public void setup() {
        gameEngine = new GameEngine();
        gameEngine.getDealer().setPlayerScore(1);
    }

    @Test
    public void calculateWinner_whileDealerScoreIsHigher_shouldReturnDealer () {
        Player winner = gameEngine.calculateWinner();
        Player dealer = gameEngine.getDealer();
        assertEquals("While dealer score is higher, dealer should win", dealer, winner);
    }
}
