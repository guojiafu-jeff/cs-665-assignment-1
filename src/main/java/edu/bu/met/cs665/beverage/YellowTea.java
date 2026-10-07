/**
 * Name: JIAFU GUO
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/04/2026
 * File Name: YellowTea.java
 * Description: The yellow tea drink.
 */

package edu.bu.met.cs665.beverage;

/**
 * A yellow tea. Created with new YellowTea() by the user of the machine (tests and Main),
 * and handed to VendingMachine.selectBeverage().
 */
public class YellowTea extends Tea {
    private static final String NAME = "Yellow Tea";
    private static final double BASE_PRICE = 2.0;

    public YellowTea() {
        super(NAME, BASE_PRICE);
    }

    /**
     * Describe how a yellow tea is brewed.
     *
     * @return the brewing steps
     */
    @Override
    public String getBrewingProcess() {
        return "Heat water to 85 degrees Celsius and steep the yellow tea leaves for 3 minutes.";
    }
}
