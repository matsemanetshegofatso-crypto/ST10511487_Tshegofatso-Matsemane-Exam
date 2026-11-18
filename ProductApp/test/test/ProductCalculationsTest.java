/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import productapp.ProductCalculations;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 *
 * @author Student
 */
public class ProductCalculationsTest {
   // Test price (same as the sample screenshot)
    private final double price = 3500;

    /**
     * Unit Test 1
     * Checks that GetVat returns 15% of the price.
     */
    @Test
    public void GetVat_WithValidData_ReturnsCorrectValue() {
        // Arrange: create the object with the test price
        ProductCalculations calc = new ProductCalculations(price);

        // Act + Assert: 15% of 3500 = 525.0
        // The 0.001 is the allowed difference (delta) when comparing doubles
        assertEquals(525.0, calc.GetVat(), 0.001);
    }

    /**
     * Unit Test 2
     * Checks that GetTotal returns price + VAT + commission.
     */
    @Test
    public void GetTotal_WithValidData_ReturnsCorrectValue() {
        // Arrange: create the object with the test price
        ProductCalculations calc = new ProductCalculations(price);

        // Act + Assert: 3500 + 525 + 175 = 4200.0
        assertEquals(4200.0, calc.GetTotal(), 0.001);
    } 
}
