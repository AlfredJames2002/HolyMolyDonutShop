
package com.mycompany.donutshop;
import javax.swing.*;

public class Order {
    
    private int numDonuts;
    private int numDonutHoles;
    private int numCakeDonuts;
    private int numDrinks;
    
    //Array of objects to store 
    private Donut[] donuts;
    private DonutHole[] donutHoles;
    private CakeDonut[] cakeDonuts;
    private Drink[] drinks;
    
        
    Order(int numDonuts, int numDonutHoles, int numCakeDonuts, int numDrinks){
        this.numDonuts = numDonuts;
        this.numDonutHoles = numDonutHoles;
        this.numCakeDonuts = numCakeDonuts;
        this.numDrinks = numDrinks;
        
        //sets the Array length
        donuts = new Donut[numDonuts];
        donutHoles = new DonutHole[numDonutHoles];
        cakeDonuts = new CakeDonut[numCakeDonuts];
        drinks = new Drink[numDrinks];
        
        processOrder();
    }
    
    private void processOrder() {
        for (int i = 0; i < numDonuts; i++) {
            donuts[i] = new Donut().orderDonut();
        }

        for (int i = 0; i < numDonutHoles; i++) {
            donutHoles[i] = new DonutHole().orderHole();
        }

        for (int i = 0; i < numCakeDonuts; i++) {
            cakeDonuts[i] = new CakeDonut().orderCakeDonut();
        }

        for (int i = 0; i < numDrinks; i++) {
            drinks[i] = new Drink().orderDrink();
        }
        
        printReceipt();
    }
    //console outputs the receipt
    public void printReceipt() {
        System.out.println("Receipt:");

        double subtotal = 0;

        for (Donut donut : donuts) {
            subtotal += donut.printItemReceipt();
        }

        for (DonutHole hole : donutHoles) {
            subtotal += hole.printItemReceipt();
        }

        for (CakeDonut cakeDonut : cakeDonuts) {
            subtotal += cakeDonut.printItemReceipt();
        }

        for (Drink drink : drinks) {
            subtotal += drink.printItemReceipt();
        }

        double totalWithTax = calculateTotalWithTax(subtotal);

        System.out.println("Subtotal: $" + String.format("%.2f", subtotal));
        System.out.println("Tax (8%): $" + String.format("%.2f", totalWithTax - subtotal));
        System.out.println("Total with Tax: $" + String.format("%.2f", totalWithTax));
    }   
    
    private double calculateTotalWithTax(double subtotal) {
        // Calculate 8% tax
        double tax = subtotal * 0.08;
        return subtotal + tax;
    }
}