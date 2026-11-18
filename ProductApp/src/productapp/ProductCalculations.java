/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productapp;

/**
 *
 * @author Student
 */
public class ProductCalculations implements IProductCalculations {
    
// Rates stored as constants so they are easy to change and not "magic numbers"
    private static final double VAT_RATE = 0.15;
    private static final double COMMISSION_RATE = 0.05;
    
    //The price of the product that the calculations are based on
    private final double price;
    
    //Constructor: receives the product price
    public ProductCalculations(double price) {
        this.price = price;
    }


@Override
public double GetVat(){
    return price * VAT_RATE;
}

@Override
public double GetCommission(){
    return price * COMMISSION_RATE;
}

@Override
public double GetTotal(){
    return price + GetVat() + GetCommission();
}
}