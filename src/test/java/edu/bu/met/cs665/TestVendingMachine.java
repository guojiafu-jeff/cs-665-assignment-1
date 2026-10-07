/**
 * Name: JIAFU GUO
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/04/2026
 * File Name: TestVendingMachine.java
 * Description: Tests of the user interaction sequences with the vending machine:
 * select a beverage, add condiments, brew, and the error cases in between.
 */

package edu.bu.met.cs665;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;

import edu.bu.met.cs665.beverage.Beverage;
import edu.bu.met.cs665.beverage.BlackTea;
import edu.bu.met.cs665.beverage.Espresso;
import edu.bu.met.cs665.beverage.GreenTea;
import edu.bu.met.cs665.beverage.LatteMacchiato;
import edu.bu.met.cs665.condiment.Milk;
import edu.bu.met.cs665.condiment.Sugar;
import edu.bu.met.cs665.machine.VendingMachine;

/**
 * Each test plays one customer using the machine.
 * These tests only call VendingMachine and read the Beverage it hands back.
 */
public class TestVendingMachine {
    private static final double DELTA = 0.001;

    /**
     * A complete order: select, add condiments, brew, then the machine becomes idle again.
     */
    @Test
    public void testCompleteOrder() {
        VendingMachine machine = new VendingMachine();
        assertFalse(machine.hasSelection());

        machine.selectBeverage(new LatteMacchiato());
        assertTrue(machine.hasSelection());
        machine.addCondiment(new Milk(), 1);
        machine.addCondiment(new Sugar(), 2);
        Beverage drink = machine.brew();

        assertEquals("Latte Macchiato", drink.getName());
        assertEquals(1, drink.getCondimentUnits(new Milk()));
        assertEquals(2, drink.getCondimentUnits(new Sugar()));
        assertEquals(3.0 + 3 * 0.5, drink.getPrice(), DELTA);
        assertFalse(machine.hasSelection());
    }

    /**
     * Brewing without selecting a beverage first is refused, and the machine stays idle.
     */
    @Test
    public void testBrewWithoutSelection() {
        VendingMachine machine = new VendingMachine();

        try {
            machine.brew();
            fail("Brewing without a selected beverage should have thrown an exception");
        } catch (IllegalStateException e) {}

        assertFalse(machine.hasSelection());
    }

    /**
     * Adding condiments without selecting a beverage first is refused.
     */
    @Test
    public void testAddCondimentWithoutSelection() {
        VendingMachine machine = new VendingMachine();

        try {
            machine.addCondiment(new Milk(), 1);
            fail("Adding a condiment without a selected beverage should have thrown an exception");
        } catch (IllegalStateException e) {}

        assertFalse(machine.hasSelection());
    }

    /**
     * Selecting null is refused.
     */
    @Test
    public void testSelectNullIsRefused() {
        VendingMachine machine = new VendingMachine();

        try {
            machine.selectBeverage(null);
            fail("Selecting null should have thrown an exception");
        } catch (IllegalArgumentException e) {}

        assertFalse(machine.hasSelection());
    }

    /**
     * An exceeding condiment is rejected by the beverage, and the exception passes through the machine.
     * And the order can still be finished with 3 units.
     */
    @Test
    public void testExceedingLimitKeepOrderUsable() {
        VendingMachine machine = new VendingMachine();
        machine.selectBeverage(new Espresso());
        machine.addCondiment(new Sugar(), 3);

        try {
            machine.addCondiment(new Sugar(), 1);
            fail("An exceeding condiment should have been rejected.");
        } catch (IllegalArgumentException e) {}

        assertTrue(machine.hasSelection());
        Beverage drink = machine.brew();
        assertEquals(3, drink.getCondimentUnits(new Sugar()));
        assertEquals(2.0 + 3 * 0.5, drink.getPrice(), DELTA);
    }

    /**
     * After brewing, the next customer starts from a clean order.
     */
    @Test
    public void testMachineIsResetAfterBrewing() {
        VendingMachine machine = new VendingMachine();
        machine.selectBeverage(new BlackTea());
        machine.addCondiment(new Milk(), 1);
        machine.brew();

        machine.selectBeverage(new GreenTea());
        Beverage drink = machine.brew();

        assertEquals("Green Tea", drink.getName());
        assertEquals(0, drink.getCondimentUnits(new Milk()));
        assertEquals(1.5, drink.getPrice(), DELTA);
    }

    /**
     * Selecting again replaces the previous choice.
     */
    @Test
    public void testSelectingAgainReplacePreviousChoice() {
        VendingMachine machine = new VendingMachine();
        machine.selectBeverage(new Espresso());
        machine.addCondiment(new Milk(), 1);

        machine.selectBeverage(new BlackTea());
        Beverage drink = machine.brew();

        assertEquals("Black Tea", drink.getName());
        assertEquals(0, drink.getCondimentUnits(new Milk()));
    }

}
