package ac.nz.eit;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest_PlayerScore20 {

    private Player player;

    @Before
    public void setup() {
        player = new Player();
        player.setPlayerScore(20);
    }

    @Test
    public void updateScore_playerScoreis20andDieRoll1_playerScore21shouldReturnTrue() {
        player.updateScore(1);
        assertEquals("The score should be 6", player.getPlayerScore(), 21);
    }

    @Test
    public void updateScore_playerScoreis20andDieRoll6_playerScore26shouldReturnTrue() {
        player.updateScore(6);
        assertEquals("The score should be 6", player.getPlayerScore(), 26);
    }


}
