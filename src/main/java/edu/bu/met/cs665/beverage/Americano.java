/**
 * Name: JIAFU GUO
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/04/2026
 * File Name: Americano.java
 * Description: The americano drink.
 */

package edu.bu.met.cs665.beverage;

/**
 * An americano. Created with new Americano() by the user of the machine (tests and Main),
 * and handed to VendingMachine.selectBeverage().
 */
public class Americano extends Coffee {
    private static final String NAME = "Americano";
    private static final double BASE_PRICE = 2.5;

    public Americano() {
        super(NAME, BASE_PRICE);
    }

    /**
     * Describe how an americano is brewed.
     *
     * @return the brewing steps
     */
    @Override
    public String getBrewingProcess() {
        return "Grind the beans, extract an espresso shot, then top it up with 120 ml of hot water.";
    }
}
