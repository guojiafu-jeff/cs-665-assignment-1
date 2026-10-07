/**
 * Name: JIAFU GUO
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/04/2026
 * File Name: BlackTea.java
 * Description: The black tea drink.
 */

package edu.bu.met.cs665.beverage;

/**
 * A black tea. Created with new BlackTea() by the user of the machine (tests and Main),
 * and handed to VendingMachine.selectBeverage().
 */
public class BlackTea extends Tea {
    private static final String NAME = "Black Tea";
    private static final double BASE_PRICE = 1.5;

    public BlackTea() {
        super(NAME, BASE_PRICE);
    }

    /**
     * Describe how a black tea is brewed.
     *
     * @return the brewing steps
     */
    @Override
    public String getBrewingProcess() {
        return "Heat water to 100 degrees Celsius and steep the black tea leaves for 4 minutes.";
    }
}