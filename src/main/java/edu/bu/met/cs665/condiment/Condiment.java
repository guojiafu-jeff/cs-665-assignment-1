/**
 * Name: JIAFU GUO
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/04/2026
 * File Name: Condiment.java
 * Description: Abstract base class for the condiments (milk, sugar, ...) that a customer
 * can add to a beverage. A condiment knows its display name and its price per unit.
 */

package edu.bu.met.cs665.condiment;

/** A Condiment object does not store how many units were added, Beverage keeps that count. */
public abstract class Condiment {
    private final String name;
    private final double unitPrice;

    /**
     * The constructor
     *
     * @param name name of the condiment
     * @param unitPrice price charged for one unit of this condiment
     */
    protected Condiment(String name, double unitPrice) {
        this.name = name;
        this.unitPrice = unitPrice;
    }

    /**
     * Get the name of the condiment. Used by Main and the tests when
     * printing or checking what was added to a drink.
     *
     * @return name of the condiment
     */
    public String getName() {
        return name;
    }

    /**
     * Get the unit price of the condiment. Used by Beverage.getPrice(),
     * which adds the unit price of every condiment unit in the drink.
     *
     * @return unit price of the condiment
     */
    public double getUnitPrice() {
        return unitPrice;
    }

    /**
     * Check whether another condiment is the same kind as this one.
     * Used by Beverage.getCondimentUnits() to count the units of the same condiment.
     *
     * @param other the condiment to compare with, could be null
     * @return true if other is not null and has the same name as this condiment
     */
    public boolean isSameKindAs(Condiment other) {
        return (other != null) && (name.equals(other.name));
    }

}
