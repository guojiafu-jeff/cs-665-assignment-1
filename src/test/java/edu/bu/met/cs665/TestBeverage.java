/**
 * Name: JIAFU GUO
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/04/2026
 * File Name: TestBeverage.java
 * Description: Unit tests for the Beverage class: condiment limits, price calculation,
 * and the basic properties of a drink.
 */

package edu.bu.met.cs665;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import edu.bu.met.cs665.beverage.Beverage;
import edu.bu.met.cs665.beverage.Espresso;
import edu.bu.met.cs665.beverage.Americano;
import edu.bu.met.cs665.beverage.BlackTea;
import edu.bu.met.cs665.beverage.GreenTea;
import edu.bu.met.cs665.beverage.LatteMacchiato;
import edu.bu.met.cs665.beverage.YellowTea;
import edu.bu.met.cs665.condiment.Condiment;
import edu.bu.met.cs665.condiment.Milk;
import edu.bu.met.cs665.condiment.Sugar;
import org.junit.Test;

/**
 * Tests the behavior every drink inherits from Beverage.
 * These tests talk to the drink directly (not through VendingMachine).
 */
public class TestBeverage {
    /** Tolerance for comparing doubles */
    private static final double DELTA = 0.001;

    /** Price of one unit of condiment (Milk or Sugar) */
    private static final double UNIT_PRICE = 0.5;

    /**
     * A new created drink has its fixed properties and no condiments.
     */
    @Test
    public void testNewDrinkNoCondiments() {
        Beverage drink = new Espresso();

        assertEquals("Espresso", drink.getName());
        assertEquals("Coffee", drink.getCategory() );
        assertEquals(2.00, drink.getBasePrice(), DELTA);
        assertEquals(0, drink.getCondimentUnits(new Milk()));
        assertEquals(0, drink.getCondimentUnits(new Sugar()));
        assertEquals(2.00, drink.getPrice(), DELTA);

        assertNotNull(drink.getBrewingProcess());
        assertFalse(drink.getBrewingProcess().isEmpty());
    }

    /**
     * Different condiments have separate limits, 3 units of each is allowed.
     */
    @Test
    public void testCondimentsCountedSeparately() {
        Beverage drink = new Espresso();
        Condiment milk = new Milk();
        Condiment sugar = new Sugar();

        drink.addCondiment(milk, Beverage.MAX_UNITS_PER_CONDIMENT);
        drink.addCondiment(sugar, Beverage.MAX_UNITS_PER_CONDIMENT);

        assertEquals(3, drink.getCondimentUnits(milk));
        assertEquals(3, drink.getCondimentUnits(sugar));
        assertEquals(2.00 + 6 * UNIT_PRICE, drink.getPrice(), DELTA);
    }

    /**
     * A request exceeding the limit is rejected and leaves the drink unchanged.
     */
    @Test
    public void testExceedingLimitRejectedAndUnchanged() {
        Beverage drink = new Espresso();
        Condiment milk = new Milk();
        drink.addCondiment(milk, 2);

        try {
            drink.addCondiment(milk, 2);
            fail("Adding an exceeding unit of milk should have thrown an exception");
        } catch (IllegalArgumentException e) {}

        assertEquals(2, drink.getCondimentUnits(milk));
        assertEquals(2.00 + 2*UNIT_PRICE, drink.getPrice(), DELTA);
    }

    /**
     * Adding 0 units is allowed and change nothing.
     */
    @Test
    public void testAddingZeroUnit() {
        Beverage drink = new Espresso();
        drink.addCondiment(new Milk(), 0);

        assertEquals(0, drink.getCondimentUnits(new Milk()));
        assertEquals(2.00, drink.getPrice(), DELTA);
    }

    /**
     * A negative number of units is rejected.
     */
    @Test
    public void testNegativeUnitsAreRejected() {
        Beverage drink = new Espresso();
        Condiment milk = new Milk();

        try {
            drink.addCondiment(milk, -1);
            fail("Adding a negative unit of milk should have thrown an exception");
        } catch (IllegalArgumentException e) {}
    }

    /**
     * A null condiment is rejected.
     */
    @Test
    public void testNullCondimentIsRejected() {
        Beverage drink = new Espresso();

        try {
            drink.addCondiment(null, 1);
            fail("Adding a null condiment should have thrown an exception");
        } catch (IllegalArgumentException e) {}
    }

    /**
     * Each of the six drinks reports its own name, category and base price, and has a brewing process.
     */
    @Test
    public void testAllDrinksHaveCorrectProperties() {
        assertDrink(new Espresso(), "Espresso", "Coffee", 2.0);
        assertDrink(new Americano(), "Americano", "Coffee", 2.5);
        assertDrink(new LatteMacchiato(), "Latte Macchiato", "Coffee", 3.0);
        assertDrink(new BlackTea(), "Black Tea", "Tea", 1.5);
        assertDrink(new GreenTea(), "Green Tea", "Tea", 1.5);
        assertDrink(new YellowTea(), "Yellow Tea", "Tea", 2.0);
    }

    /**
     * Check the fixed properties of a drink.
     * Used by testAllDrinksHaveCorrectProperties().
     *
     * @param drink the drink to check
     * @param name expected name
     * @param category expected category
     * @param basePrice expected base price
     */
    private void assertDrink(Beverage drink, String name, String category, double basePrice) {
        assertEquals(name, drink.getName());
        assertEquals(category, drink.getCategory());
        assertEquals(basePrice, drink.getBasePrice(), DELTA);
        assertEquals(basePrice, drink.getPrice(), DELTA);
        assertFalse(drink.getBrewingProcess().isEmpty());
    }


}
