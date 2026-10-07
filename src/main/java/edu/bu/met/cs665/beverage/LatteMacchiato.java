/**
 * Name: JIAFU GUO
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/04/2026
 * File Name: LatteMacchiato.java
 * Description: The latte macchiato drink.
 */

package edu.bu.met.cs665.beverage;

/**
 * A latte macchiato. Created with new LatteMacchiato() by the user of the machine (tests and Main),
 * and handed to VendingMachine.selectBeverage().
 */
public class LatteMacchiato extends Coffee {
    private static final String NAME = "Latte Macchiato";
    private static final double BASE_PRICE = 3.0;

    public LatteMacchiato() {
        super(NAME, BASE_PRICE);
    }

    /**
     * Describe how a latte macchiato is brewed.
     *
     * @return the brewing steps
     */
    @Override
    public String getBrewingProcess() {
        return "Froth the milk, pour it into the glass, then slowly add an espresso shot on top.";
    }
}