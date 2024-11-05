
package com.mycompany.donutshop;
import javax.swing.*;

public class Drink {
    public enum Size{
        SMALL,
        MEDIUM,
        LARGE
    }
    public enum TypeDrink{
        WATER,
        BLACK_COFFEE,
        ICED_COFFEE,
        ICED_TEA,
        CHOCOLATE_MILK,
        CAPPUCCINO,
        STRAWBERRY_MILK
    }
    
    private Size size;
    private TypeDrink drinktype;
    
    public double getPrice(){
        double baseprice = 1.00;
        if(size == Size.MEDIUM){
            baseprice += .50;
        }
        if(size ==Size.LARGE){
            baseprice += 1.00;
        }
        
        if(drinktype == TypeDrink.CAPPUCCINO || drinktype == TypeDrink.ICED_COFFEE){
            baseprice += .50;
        }
        
        if(drinktype == TypeDrink.WATER){
            baseprice = 0;
        }
        
        return baseprice;
    }
    
    public double printItemReceipt() {
        double price = getPrice();
        System.out.println("Drink - Price: $" + String.format("%.2f", price));
        System.out.println( size +" "+drinktype);
        return price;
    }
    
    Size showSizeOptions(){
        Size[] options = {Size.SMALL, Size.MEDIUM, Size.LARGE};
        
        Object selectedOption = JOptionPane.showInputDialog(null, "Choose drink size:", "Size Selection", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        
        if (selectedOption != null) {
            return (Size) selectedOption;
        } else {
            return Size.SMALL;
        }
    }
    
    TypeDrink showDrinkTypeOptions(){
        TypeDrink[] options = {TypeDrink.WATER, TypeDrink.BLACK_COFFEE, TypeDrink.CAPPUCCINO, TypeDrink.ICED_COFFEE, TypeDrink.ICED_TEA, TypeDrink.CHOCOLATE_MILK, TypeDrink.STRAWBERRY_MILK};
        
        Object selectedOption = JOptionPane.showInputDialog(null, "Choose drink:", "Drink Selection", JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
        
        if (selectedOption != null) {
            return (TypeDrink) selectedOption;
        } else {
            return TypeDrink.BLACK_COFFEE;
        }
        
    }
    
    public void setSize(Size size){
        this.size = size;
    }
    
    public void setDrink(TypeDrink drinktype){
        this.drinktype = drinktype;
    }
    
    Drink orderDrink(){
        TypeDrink selectedDrink = showDrinkTypeOptions();
        Size selectedSize = showSizeOptions();
        
        Drink myDrink = new Drink();
        myDrink.setDrink(selectedDrink);
        myDrink.setSize(selectedSize);
        
        return myDrink;
    }
}
