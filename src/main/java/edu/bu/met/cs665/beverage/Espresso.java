/**
 * Name: JIAFU GUO
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/04/2026
 * File Name: Espresso.java
 * Description: The espresso drink.
 */

package edu.bu.met.cs665.beverage;

/**
 * An espresso. Created with new Espresso() by the user of the machine (tests and Main),
 * and handed to VendingMachine.selectBeverage().
 */
public class Espresso extends Coffee {
    private static final String NAME = "Espresso";
    private static final double BASE_PRICE = 2.0;

    public Espresso() {
        super(NAME, BASE_PRICE);
    }

    /**
     * Describe how an espresso is brewed.
     *
     * @return the brewing steps
     */
    @Override
    public String getBrewingProcess() {
        return "Grind the beans finely and extract a 30 ml shot with hot water under high pressure.";
    }
}
