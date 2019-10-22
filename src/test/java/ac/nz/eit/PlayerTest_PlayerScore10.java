package ac.nz.eit;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest_PlayerScore10 {

    private Player player;

    @Before
    public void setup() {
        Player player = new Player();
        player.setPlayerScore(10);
    }

    @Test
    public void updateScore_playerScoreis10andDieRoll3_playerScore13shouldReturnTrue() {
        player.updateScore(3);
        assertEquals("The score should be 6", player.getPlayerScore(), 13);
    }

}
