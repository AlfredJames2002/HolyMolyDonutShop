
package com.mycompany.donutshop;
import javax.swing.*;

public class Donut {
    public enum Filling {
        CHOCOLATE,
        VANILLA,
        RASPBERRY,
        APPLE,
        LEMON,
        NONE
        }   
    public enum Frosting {
    CHOCOLATE,
    VANILLA,
    NONE
    }
    public enum Sprinkles{
        SPRINKLES,
        NO_SPRINKLES
    }

    public Filling filling;
    public Frosting frosting;
    public Sprinkles sprinkles;
        
    public double getPrice() {
        double basePrice = 0.99;

        // Add extra cost for frosting
        if (frosting != Frosting.NONE) {
            basePrice += 0.10;
        }

        // Add extra cost for filling
        if (filling != Filling.NONE) {
            basePrice += 0.10;
        }

        // Add extra cost for sprinkles
        if (sprinkles == Sprinkles.SPRINKLES) {
            basePrice += 0.10;
        }

        return basePrice;
    }
        
    public double printItemReceipt() {
        double price = getPrice();
        System.out.println("Donut - Price: $" + String.format("%.2f", price));
        System.out.print(filling+ " filling, ");
        System.out.print(frosting + " frosting, ");
        System.out.println("Sprinkles: " + sprinkles);
        return price;
    }
        
    Filling showDonutFillingOptions() {
        // Define the options for filling
        Filling[] options = {Filling.CHOCOLATE, Filling.VANILLA, Filling.RASPBERRY, Filling.APPLE, Filling.LEMON, Filling.NONE};

        // Display the combo box
        Object selectedOption = JOptionPane.showInputDialog(null, "Choose donut filling:", "Filling Selection", JOptionPane.QUESTION_MESSAGE, null, options, options[5]);

        // Check if the user made a selection
        if (selectedOption != null) {
            return (Filling) selectedOption;
        } else {
            // User canceled or closed the dialog, you may want to handle this case
            // For now, returning a default filling
            return Filling.NONE;
        }
    }
    Frosting showDonutFrostingOptions(){
        //define options for frosting
        Frosting[] options = {Frosting.CHOCOLATE, Frosting.VANILLA, Frosting.NONE};

        Object selectedOption = JOptionPane.showInputDialog(null, "Choose donut frosting:", "Frosting Selection", JOptionPane.QUESTION_MESSAGE, null, options, options[2]);

        if (selectedOption != null) {
            return (Frosting) selectedOption;
        } else {
            return Frosting.NONE;
        }
    }
        
    Sprinkles showSprinklesOption(){
        Sprinkles[] options = {Sprinkles.SPRINKLES, Sprinkles.NO_SPRINKLES};

        Object selectedOption = JOptionPane.showInputDialog(null, "Would you like sprinkles? ", "Sprinkles Selection", JOptionPane.QUESTION_MESSAGE, null, options, options[1]);

        if (selectedOption != null) {
            return (Sprinkles) selectedOption;
        } else {
            return Sprinkles.NO_SPRINKLES;
        }
    }
        
    public void setFilling(Filling filling) {
    this.filling = filling;
    }

    public void setFrosting(Frosting frosting) {
        this.frosting = frosting;
    }

    public void setSprinkles(Sprinkles sprinkles) {
        this.sprinkles = sprinkles;
    }
        
    Donut orderDonut() {
        Filling selectedDonutFilling = showDonutFillingOptions();
        Frosting selectedDonutFrosting = showDonutFrostingOptions();
        Sprinkles selectedSprinkles = showSprinklesOption();

        // Create Donut object with the selected options
        Donut myDonut = new Donut();
        myDonut.setFilling(selectedDonutFilling);
        myDonut.setFrosting(selectedDonutFrosting);
        myDonut.setSprinkles(selectedSprinkles);

        return myDonut;
    }
}
