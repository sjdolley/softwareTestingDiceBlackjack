package ac.nz.eit;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {
    private Player player;

    @Before
    public void setup() {
        player = new Player();
        player.setPlayerScore(0);
    }

    // boundary cases for current score and rolled score, 4 permutations

    @Test
    public void ifPlayerScoreis0_andDieRoll1_shouldReturnTrue() {
        player.updateScore(1);
        assertTrue("The score should be 1", player.getPlayerScore()==1);
    }

    @Test
    public void ifPlayerScoreis0_andDieRoll6_shouldReturnTrue() {
        player.updateScore(6);
        assertTrue("The score should be 6", player.getPlayerScore()==6);
    }

    @Test
    public void ifPlayerScoreis20_andDieRoll1_shouldReturnTrue() {
        player.setPlayerScore(20);
        player.updateScore(1);
        assertTrue("The score should be 6", player.getPlayerScore()==21);
    }

    @Test
    public void ifPlayerScoreis20_andDieRoll6_shouldReturnTrue() {
        player.setPlayerScore(20);
        player.updateScore(6);
        assertTrue("The score should be 6", player.getPlayerScore()==26);
    }

    // standard test of valid data

    @Test
    public void ifPlayerScoreis10_andDieRoll3_shouldReturnTrue() {
        player.setPlayerScore(10);
        player.updateScore(3);
        assertTrue("The score should be 6", player.getPlayerScore()==13);
    }
}
