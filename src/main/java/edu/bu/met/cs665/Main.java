/**
 * Name: JIAFU GUO
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/04/2026
 * File Name: Main.java
 * Description: Entry point of the program. Runs a short demo of the vending machine on the console.
 * The real demonstration of the functionality is in the JUnit tests.
 */

package edu.bu.met.cs665;

import edu.bu.met.cs665.beverage.Beverage;
import edu.bu.met.cs665.beverage.GreenTea;
import edu.bu.met.cs665.beverage.LatteMacchiato;
import edu.bu.met.cs665.condiment.Milk;
import edu.bu.met.cs665.condiment.Sugar;
import edu.bu.met.cs665.machine.VendingMachine;

/**
 * Demo of two customers using the machine: a normal order, a rejected 4th unit of sugar.
 * And the machine being ready for the next customer.
 */
public class Main {
    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine();

        machine.selectBeverage(new LatteMacchiato());
        machine.addCondiment(new Milk(), 1);
        machine.addCondiment(new Sugar(), 3);
        try {
            machine.addCondiment(new Sugar(), 1);
        } catch(IllegalArgumentException e) {
            System.out.println("The machine shows: " + e.getMessage());
        }
        printOrder(machine.brew());

        machine.selectBeverage(new GreenTea());
        printOrder(machine.brew());
    }

    /**
     * Print the information about a finished drink.
     *
     * @param drink the beverage handed out by the machine
     */
    private static void printOrder(Beverage drink) {
        System.out.println(drink.getCategory() + ": " + drink.getName());
        System.out.println("    Brewing: " + drink.getBrewingProcess());
        System.out.println("    Milk: " + drink.getCondimentUnits(new Milk()));
        System.out.println("    Sugar: " + drink.getCondimentUnits(new Sugar()));
        System.out.printf("    Price: $%.2f %n", drink.getPrice());
    }

}
