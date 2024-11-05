
package com.mycompany.donutshop;
import javax.swing.*;
public class CakeDonut {
    
    public enum cakeType{
        CHOCOLATE,
        VANILLA,
        BIRTHDAYCAKE
    }
    
    double price = .99;
    private cakeType selectedCakeType;
    
    public void setCakeType(cakeType selectedCakeType){
        this.selectedCakeType = selectedCakeType;
    }
    
    public double getPrice() {
        return price;
    }
    
    public double printItemReceipt() {
        double price = getPrice();
        System.out.println("Cake Donut - Price: $" + String.format("%.2f", price));
        System.out.println( selectedCakeType + " cake donut");
        return price;
    }
    
    cakeType showCakeTypeOptions(){
        cakeType[] options = {cakeType.BIRTHDAYCAKE, cakeType.CHOCOLATE, cakeType.VANILLA};
        
        Object selectedOption = JOptionPane.showInputDialog(null, "Choose cake type:", "Cake Donut Selection", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        
        if (selectedOption != null) {
            return (cakeType) selectedOption;
        } else {
            return cakeType.VANILLA;
        }
    }
    
    CakeDonut orderCakeDonut(){
        cakeType selectedCakeType = showCakeTypeOptions();
        
        CakeDonut myCakeDonut = new CakeDonut();
        myCakeDonut.setCakeType(selectedCakeType);
        
        return myCakeDonut;
    }
    
    
}
