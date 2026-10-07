/**
 * Name: JIAFU GUO
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/04/2026
 * File Name: Beverage.java
 * Description: Abstract class for every drink the vending machine makes.
 * It holds what all drinks share: a name, a base price, the condiments added to the drink,
 * the 3-units-per-condiment rule and the price calculation.
 */

package edu.bu.met.cs665.beverage;

import edu.bu.met.cs665.condiment.Condiment;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is abstract, the concrete drinks(Espresso, Green Tea, ...) are subclasses.
 * VendingMachine works only with this type, so it never needs to know which concrete it is handling.
 */
public abstract class Beverage {
    public static final int MAX_UNITS_PER_CONDIMENT = 3;
    private final String name;
    private final double basePrice;

    /** Every unit of condiment added to this drink, one Condiment object per unit. */
    private final List<Condiment> condiments = new ArrayList<>();

    /**
     * Create a drink with no condiments. Called only by subclasses.
     *
     * @param name name of the drink
     * @param basePrice price of the drink without any condiment
     */
    protected Beverage(String name, double basePrice) {
        this.name = name;
        this.basePrice = basePrice;
    }

    /**
     * Get the name of the drink. Used by Main and the tests.
     *
     * @return the drink name
     */
    public String getName() {
        return name;
    }

    /**
     * Get the price of the drink without condiments. Used by tests.
     *
     * @return the base price
     */
    public double getBasePrice() {
        return basePrice;
    }

    /**
     * Add units of a condiment to this drink.
     * This is the only place where the condiment rule lives.
     * Called by VendingMachine.addCondiment() and directly by the tests.
     *
     * @param condiment the kind of condiment to add
     * @param units how many units to add
     * @throws IllegalArgumentException when condiment is null, unit is negative,
     * or the drink would end up with more than MAX_UNITS_PER_CONDIMENT units of that condiment.
     */
    public void addCondiment(Condiment condiment, int units) {
        if (condiment == null) {
            throw new IllegalArgumentException("Condiment must not be null.");
        }
        if (units < 0) {
            throw new IllegalArgumentException("Units must not be negative.");
        }
        int alreadyAdded = getCondimentUnits(condiment);
        if (units > MAX_UNITS_PER_CONDIMENT - alreadyAdded) {
            throw new IllegalArgumentException("At most " + MAX_UNITS_PER_CONDIMENT + " units of " + condiment.getName() + " are allowed. The drink already has " + alreadyAdded+".");
        }
        for (int i=0; i<units; i++) {
            condiments.add(condiment);
        }
    }

    /**
     * Count how many units of a kind of condiment this drink contains.
     * Used by addCondiment() to enforce the limit, and by tests and Main to read the amounts.
     *
     * @param condiment the kind of condiment to count
     * @return the number of units of that kind in this drink
     */
    public int getCondimentUnits(Condiment condiment) {
        int count = 0;
        for (Condiment added : condiments) {
            if (added.isSameKindAs(condiment)) {
                count++;
            }
        }
        return count;
    }

    /**
     * Calculate the final price of the drink
     *
     * @return the total price of the drink (including added condiments)
     */
    public double getPrice() {
        double price = basePrice;
        for (Condiment added : condiments) {
            price = price + added.getUnitPrice();
        }
        return price;
    }

    /**
     * Describe how the machine brews the drink. Each concrete drink implements it with its own steps.
     *
     * @return a short description of the brewing process
     */
    public abstract String getBrewingProcess();

    /**
     * Get the category of this drink, "Coffee" or "Tea".
     *
     * @return the category name
     */
    public abstract String getCategory();

}
