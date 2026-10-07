/**
 * Name: JIAFU GUO
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/04/2026
 * File Name: Tea.java
 * Description: Abstract base for all tea drinks. It names the category.
 * Each concrete tea supplies its own name, base price and brewing process.
 */

package edu.bu.met.cs665.beverage;

/**
 * This class holds what all teas share: the category name.
 * BlackTea, GreenTea and YellowTea extend it.
 */
public abstract class Tea extends Beverage {
    private static final String CATEGORY = "Tea";

    /**
     * Create a tea.
     *
     * @param name name of the tea, such as "Green Tea"
     * @param basePrice base price of the tea
     */
    protected Tea(String name, double basePrice) {
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
