package ac.nz.eit;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class ConstructorTest {

    @Test
    public void gameEngineConstructor_shouldReturnTrue() {
        GameEngine testGameEngine = new GameEngine();
        assertThat("Should be an instance of the GameEngine class", testGameEngine, instanceOf(GameEngine.class));
    }

    @Test
    public void dieConstructor_shouldReturnTrue() {
        Die testDie = new Die();
        assertThat("Should be an instance of the Die class", testDie, instanceOf(Die.class));
    }

    @Test
    public void playerConstructor_shouldReturnTrue() {
        Player testPlayer = new Player();
        assertThat("Should be an instance of the Player class", testPlayer, instanceOf(Player.class));
    }

    @Test
    public void playerConstructor_getPlayerScore_shouldReturn0() {
        Player testPlayer = new Player();
        assertEquals("On initialisation of Player class, score should be set to 0", testPlayer.getPlayerScore(), 0);
    }
}
