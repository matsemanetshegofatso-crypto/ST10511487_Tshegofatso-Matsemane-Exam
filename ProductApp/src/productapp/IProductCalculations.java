/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package productapp;

/**
 *
 * @author Student
 */
public interface IProductCalculations {
    // Returns the VAT amount (15% of the product price)
    double GetVat();
    
    //Returns the commission amount (5% of the product price)
    double GetCommission();
    
    // Returns the total sale amount (price + VAT + commission)
    double GetTotal();
}
