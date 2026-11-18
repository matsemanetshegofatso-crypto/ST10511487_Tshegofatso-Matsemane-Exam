/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 *
 * @author Student
 */
public class ProductTest {
    // Test data (same as the sample screenshot) shared by both tests
    private final String[] names = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
    private final int[][] sales = {
        {25, 18, 20},   // Cozy Nights Monarch: total 63
        {15, 10, 12},   // Restonic Barbados:   total 37
        {18, 15, 20}    // Sealy Phuket:        total 53
    };                  // Grand total = 153

    /**
     * Unit Test 1
     * Checks that GetTotalProductsSold returns the correct total.
     */
    @Test
    public void GetTotalProductSales_WithValidData_ReturnsCorrectValue() {
        // Arrange: create the object with the test data
        Product product = new Product(names, sales);

        // Act + Assert: 63 + 37 + 53 = 153
        assertEquals(153, product.GetTotalProductsSold());
    }

    /**
     * Unit Test 2
     * Checks that GetAverageProductSold returns the correct average.
     */
    @Test
    public void GetAverageSales_WithValidData_ReturnsCorrectValue() {
        // Arrange: create the object with the test data
        Product product = new Product(names, sales);

        // Act + Assert: 153 / 9 = 17.0
        // The 0.001 is the allowed difference (delta) when comparing doubles
        assertEquals(17.0, product.GetAverageProductSold(), 0.001);
    }
}
