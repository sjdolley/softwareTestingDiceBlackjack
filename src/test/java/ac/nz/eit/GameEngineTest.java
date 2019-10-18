package ac.nz.eit;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameEngineTest {
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
    public void checkScore_whileScoreIs21_shouldReturnFalse () {
        gameEngine.getUser().setPlayerScore(21);
        boolean checkResult = gameEngine.checkScoreValid(gameEngine.getUser());
        assertFalse("The player score of 21 should return false", checkResult);
    }

    @Test
    public void checkScore_whileScoreIs22_shouldReturnFalse () {
        gameEngine.getUser().setPlayerScore(22);
        boolean checkResult = gameEngine.checkScoreValid(gameEngine.getUser());
        assertFalse("The player score of 22 should return false", checkResult);
    }

    @Test
    public void dealerTurn_shouldReturnBetween16and27 () {
        gameEngine.dealerTurn();
        int dealerScore = gameEngine.getDealer().getPlayerScore();
        assertTrue("The dealer should finish on a score of at least 16 and no more than 27", dealerScore >= 16 && dealerScore <= 27);
    }

    @Test
    public void hit_shouldReturnBetween2And12 () {
        int preScore = gameEngine.getUser().getPlayerScore();
        gameEngine.hit(gameEngine.getUser());
        int postScore = gameEngine.getUser().getPlayerScore();
        int scoreDifference = postScore - preScore;
        assertTrue("Hit should add between 2 and 12 to score", scoreDifference >=2 && scoreDifference <= 12);
    }

    @Test
    public void calculateWinner_whileScoresAre0_shouldReturnNull () {
        Player winner = gameEngine.calculateWinner();
        assertNull("While scores are the same, winner should be null", winner);
    }

    @Test
    public void calculateWinner_whileUserScoreIsHigher_shouldReturnUser () {
        gameEngine.getUser().setPlayerScore(1);
        Player winner = gameEngine.calculateWinner();
        Player user = gameEngine.getUser();
        assertEquals("While user score is higher, user should win", user, winner);
    }

    @Test
    public void calculateWinner_whileUserScoreIs22_shouldReturnDealer () {
        gameEngine.getUser().setPlayerScore(22);
        Player winner = gameEngine.calculateWinner();
        Player dealer = gameEngine.getDealer();
        assertEquals("While user score is over 21, dealer should win", dealer, winner);
    }

    @Test
    public void calculateWinner_whileDealerScoreIsHigher_shouldReturnDealer () {
        gameEngine.getDealer().setPlayerScore(1);
        Player winner = gameEngine.calculateWinner();
        Player dealer = gameEngine.getDealer();
        assertEquals("While dealer score is higher, dealer should win", dealer, winner);
    }

    @Test
    public void calculateWinner_whileDealerScoreIs22_shouldReturnUser () {
        gameEngine.getDealer().setPlayerScore(22);
        Player winner = gameEngine.calculateWinner();
        Player user = gameEngine.getUser();
        assertEquals("While dealer score is over 21, user should win", user, winner);
    }
}
