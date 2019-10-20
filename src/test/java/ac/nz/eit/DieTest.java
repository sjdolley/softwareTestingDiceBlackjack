package ac.nz.eit;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DieTest {
    private Die die;


    @Before
    public void setup() {
        die = new Die();
    }


    // single test to check the math.random() function produces a result between 1 and 6
    @Test
    public void checkDie_whileRollIsBetween1and6_shouldReturnTrue() {
        die.roll();
        int result = die.getValue();
        assertTrue("A single Die roll should produce a result of 1-6", result >=1 && result <= 6);

    }
}
