
package com.mycompany.donutshop;
import javax.swing.*;

public class DonutHole{
        
    public enum holeType{
        CHOCOLATE,
        VANILLA
    }

    public holeType selectedType;
    double price = .10;
    
    public void setHoleType(holeType selectedType){
        this.selectedType = selectedType;
    }
    
    public double getPrice() {
        return price;
    }
    
    public double printItemReceipt() {
        double price = getPrice();
        System.out.println("Donut Hole - Price: $" + String.format("%.2f", price));
        System.out.println( selectedType + " donut-hole ");
        return price;
    }
    
    holeType showHoleTypeOptions(){
        holeType[] options = {holeType.CHOCOLATE, holeType.VANILLA};
        
        Object selectedOption = JOptionPane.showInputDialog(null, "Chocolate or Vanilla donut-hole?", "Donut-Hole Selection", JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
        
        if (selectedOption != null) {
            return (holeType) selectedOption;
        } else {
            return holeType.VANILLA;
        }
    }
    DonutHole orderHole(){
        holeType selectedType = showHoleTypeOptions();
        
        DonutHole myDonutHole = new DonutHole();
        myDonutHole.setHoleType(selectedType);
        
        return myDonutHole;
    }
}
