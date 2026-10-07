/**
 * Name: JIAFU GUO
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/04/2026
 * File Name: Milk.java
 * Description: The milk condiment. One unit of milk costs $0.50.
 */

package edu.bu.met.cs665.condiment;

/**
 * This represents Milk that can be added to a beverage.
 * The user of the vending machine creates it and passes it to VendingMachine.addCondiment().
 */
public class Milk extends Condiment {
    /** The name and unit price are fixed here and handed to the Condiment constructor */
    private static final String NAME = "Milk";
    private static final double UNIT_PRICE = 0.50;

    /**
     * Create a Milk condiment
     */
    public Milk() {
        super(NAME, UNIT_PRICE);
    }
}
