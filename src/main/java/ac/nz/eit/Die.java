package ac.nz.eit;

import java.lang.Math;

public class Die {
    private int value;

    // Constructor
    public Die(){}


    // Rolls a die and stores returns the value
    public int roll() {
        value=(int)(Math.random()*6)+1;
        return value;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
