/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exam;

/**
 *
 * @author Student
 */
public class PrintProduct {
   // Uses the IProduct interface type so any IProduct implementation can be printed
    private final IProduct product;

    /**
     * Constructor: receives the product whose data must be printed
     * @param product an object that implements IProduct
     */
    public PrintProduct(IProduct product) {
        this.product = product;
    }

    // Prints the report title and the line of stars underneath it
    public void printHeader() {
        System.out.println("\nPRODUCT SALES REPORT - 2026\n");
        System.out.println("*********************************************");
    }

    // Prints the total number of products sold
    public void printTotalProductSales() {
        System.out.println("TOTAL PRODUCT SALES: " + product.GetTotalProductsSold());
    }

    // Prints the average, rounded to a whole number to match the sample output
    public void printAverageProductSales() {
        System.out.println("AVERAGE PRODUCT SALES: " + Math.round(product.GetAverageProductSold()));
    }

    // Prints the most popular product (name and total sales)
    public void printMostPopularProduct() {
        System.out.println("MOST POPULAR PRODUCT: " + product.GetMostPopularProduct());
    } 
}
