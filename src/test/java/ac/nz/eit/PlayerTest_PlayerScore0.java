package ac.nz.eit;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest_PlayerScore0 {

    private Player player;

    @Before
    public void setup() {
        player = new Player();
        player.setPlayerScore(0);
    }

    @Test
    public void updateScore_playerScore0andDieRoll1_playerScore1shouldReturnTrue() {
        player.updateScore(1);
        assertEquals("The score should be 1", player.getPlayerScore(), 1);
    }

    @Test
    public void updateScore_playerScoreis0andDieRoll6_playerScore6shouldReturnTrue() {
        player.updateScore(6);
        assertEquals("The score should be 6", player.getPlayerScore(),6);
    }

}
