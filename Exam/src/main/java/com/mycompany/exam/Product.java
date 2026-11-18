/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exam;

/**
 *
 * @author Student
 */
public class Product implements IProduct {
    // Single-dimensional array: holds the name of each product
    private final String[] names;

    // Two-dimensional array: holds the sales figures
    // Rows = products, columns = months, e.g. sales[0][1] = product 1, month 2
    private final int[][] sales;

    /**
     * Constructor: receives the product names and the sales data
     * @param names the product names
     * @param sales the monthly sales for each product
     */
    public Product(String[] names, int[][] sales) {
        this.names = names;
        this.sales = sales;
    }

    /**
     * Helper method: adds up the sales for ONE product over all months.
     * Private because it is only used inside this class.
     * @param productIndex the row number of the product in the sales array
     * @return the total sales for that product
     */
    private int getProductTotal(int productIndex) {
        int total = 0;

        // Loop through each month (column) for this product (row)
        for (int month = 0; month < sales[productIndex].length; month++) {
            total += sales[productIndex][month];
        }
        return total;
    }

    /**
     * Calculates the total number of products sold (all products, all months).
     * @return the grand total
     */
  
    public int GetTotalProductsSold() {
        int total = 0;

        // Add the total of every product together
        for (int p = 0; p < sales.length; p++) {
            total += getProductTotal(p);
        }
        return total;
    }

    /**
     * Calculates the average number of products sold per entry.
     * With 3 products and 3 months there are 9 entries.
     * @return the average as a double
     */
  
    public double GetAverageProductSold() {
        // Number of entries = number of products x number of months
        int entries = sales.length * sales[0].length;

        // Cast to double so the division keeps its decimal places
        return (double) GetTotalProductsSold() / entries;
    }

    /**
     * Finds the product with the highest total sales.
     * @return the product name followed by its total in brackets
     */
   
    public String GetMostPopularProduct() {
        // Assume the first product is the best, then compare it with the others
        int bestIndex = 0;

        for (int p = 1; p < sales.length; p++) {
            // If this product's total is higher, it becomes the new best
            if (getProductTotal(p) > getProductTotal(bestIndex)) {
                bestIndex = p;
            }
        }
        return names[bestIndex] + "(" + getProductTotal(bestIndex) + ")";
    }
}
