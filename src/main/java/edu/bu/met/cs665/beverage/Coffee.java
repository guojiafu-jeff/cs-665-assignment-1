/**
 * Name: JIAFU GUO
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/04/2026
 * File Name: Coffee.java
 * Description: Abstract base for all coffee drinks. It names the category.
 * Each concrete coffee supplies its own name, base price and brewing process.
 */

package edu.bu.met.cs665.beverage;

/**
 * This class holds what all coffees share: the category name.
 * Espresso, Americano and LatteMacchiato extend it.
 */
public abstract class Coffee extends Beverage{
    private static final String CATEGORY = "Coffee";

    /**
     * Create a coffee.
     *
     * @param name name of the coffee, such as "Espresso"
     * @param basePrice base price of the coffee
     */
    protected Coffee(String name, double basePrice) {
        super(name, basePrice);
    }

    /**
     * Get category
     *
     * @return the category name
     */
    @Override
    public String getCategory() {
        return CATEGORY;
    }

}
