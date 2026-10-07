/**
 * Name: JIAFU GUO
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/04/2026
 * File Name: VendingMachine.java
 * Description: The control panel of the vending machine. Users only interact with this class.
 * It runs one order at a time: select a beverage, add condiments, brew, then reset for the next customer.
 */

package edu.bu.met.cs665.machine;

import edu.bu.met.cs665.beverage.Beverage;
import edu.bu.met.cs665.condiment.Condiment;

/**
 * The only class the user talks to (in this project is through Main).
 * It works with the abstract types Beverage and Condiment only.
 */
public class VendingMachine {
    /** The beverage of the order in progress; null when the machine is idle */
    private Beverage selectedBeverage;

    /**
     * Start an order by choosing a drink.
     *
     * @param beverage the drink to choose
     * @throws IllegalArgumentException when beverage is null
     */
    public void selectBeverage(Beverage beverage) {
        if(beverage == null) {
            throw new IllegalArgumentException("Beverage can not be null.");
        }
        selectedBeverage = beverage;
    }

    /**
     * Add condiments to the current drink.
     *
     * @param condiment the kind of condiment
     * @param units how many units to add
     * @throws IllegalStateException if no drink has been selected
     * @throws IllegalArgumentException if the beverage (Beverage class) rejects the request.
     */
    public void addCondiment(Condiment condiment, int units) {
        requireSelection();
        selectedBeverage.addCondiment(condiment, units);
    }

    /**
     * Make the drink and reset the machine.
     *
     * @return the finished drink with its condiments
     * @throws IllegalStateException if no beverage has been selected
     */
    public Beverage brew() {
        requireSelection();
        Beverage finished = selectedBeverage;
        selectedBeverage = null;
        return finished;
    }

    /**
     * Tell whether an order is in process.
     *
     * @return true if a beverage has been selected and not yet brewed
     */
    public boolean hasSelection() {
        return selectedBeverage != null;
    }

    /**
     * Shared check for addCondiment() and brew(): the machine must not be idle.
     *
     * @throws IllegalStateException if no beverage has been selected
     */
    private void requireSelection() {
        if (selectedBeverage == null) {
            throw new IllegalStateException("No beverage selected. Select a beverage first.");
        }
    }

}
