/**
 * Name: JIAFU GUO
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/04/2026
 * File Name: GreenTea.java
 * Description: The green tea drink.
 */

package edu.bu.met.cs665.beverage;

/**
 * A green tea. Created with new GreenTea() by the user of the machine (tests and Main),
 * and handed to VendingMachine.selectBeverage().
 */
public class GreenTea extends Tea {
    private static final String NAME = "Green Tea";
    private static final double BASE_PRICE = 1.5;

    public GreenTea() {
        super(NAME, BASE_PRICE);
    }

    /**
     * Describe how a green tea is brewed.
     *
     * @return the brewing steps
     */
    @Override
    public String getBrewingProcess() {
        return "Heat water to 80 degrees Celsius and steep the green tea leaves for 2 minutes.";
    }
}
