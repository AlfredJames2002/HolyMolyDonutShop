//Alfred James
//Enes Yildiz
package com.mycompany.donutshop;
import javax.swing.*;

public class DonutShop {
   
    //recursive input validation method
    private static int InputValidation(String input) {
        try {
            int numDonuts = Integer.parseInt(input);
            //positive integers only
            if (numDonuts >= 0) {
                return numDonuts;
            } else {
                JOptionPane.showMessageDialog(null, "That is not an amount you can purchase.");
                String newInput = JOptionPane.showInputDialog(null, "Try again. How many would you like?");
                // Recursive call until user input is positive integer 
                return InputValidation(newInput);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "That is not an amount you can purchase.");
            String newInput = JOptionPane.showInputDialog(null, "Try again. How many would you like?");
            // Recursive call until integer is input
            return InputValidation(newInput);
        }
    }
    public static void main(String[] args) {
        
        JOptionPane.showMessageDialog(null, "At Holy Moly Donut Shop, we have the best yeast donuts, cake donuts,"
                + " donut-holes, and drinks! Get ready to order!");
        
        String Donutsinput = JOptionPane.showInputDialog(null, "How many yeast donuts would you like?");
        int numDonuts = InputValidation(Donutsinput);
        
        String DonutHolesinput = JOptionPane.showInputDialog(null, "How many donut-holes Would you like?");
        int numDonutHoles = InputValidation(DonutHolesinput);
        
        String CakeDonutinput = JOptionPane.showInputDialog(null, "How many cake donuts would you like?");
        int numCakeDonuts = InputValidation(CakeDonutinput);
        
        String Drinksinput = JOptionPane.showInputDialog(null, "How many drinks would you like?");
        int numDrinks = InputValidation(Drinksinput);
        
        Order customersOrder = new Order(numDonuts, numDonutHoles, numCakeDonuts, numDrinks);
        
    }
}
