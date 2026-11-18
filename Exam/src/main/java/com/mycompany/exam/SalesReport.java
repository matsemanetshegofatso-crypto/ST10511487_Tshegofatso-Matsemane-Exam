/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exam;
import java.util.Scanner;
/**
 *
 * @author Student
 */
public class SalesReport {
     public static void main(String[] args) {
        // Scanner reads the user's input from the keyboard
        Scanner input = new Scanner(System.in);

        // Single-dimensional array: the three top-performing products
        String[] names = {
            "Cozy Nights Monarch",
            "Restonic Barbados",
            "Sealy Phuket"
        };

        // Two-dimensional array: 3 products (rows) x 3 months (columns)
        int[][] sales = new int[names.length][3];

        // Outer loop: goes through each product
        for (int p = 0; p < names.length; p++) {

            // Inner loop: goes through each of the 3 months
            for (int m = 0; m < 3; m++) {
                // (m + 1) so the user sees months 1-3 instead of 0-2
                System.out.print("Enter number of sales for month " + (m + 1)
                        + " for " + names[p] + " mattress: ");
                sales[p][m] = input.nextInt();   // store the value in the array
            }
            System.out.println();   // blank line between products
        }

        // Create the Product object with the data the user entered.
        // Declared as IProduct because Product implements that interface.
        IProduct product = new Product(names, sales);

        // Create the printer and give it the product to report on
        PrintProduct printer = new PrintProduct(product);

        // Print the report
        printer.printHeader();
        printer.printTotalProductSales();
        printer.printAverageProductSales();
        printer.printMostPopularProduct();

        // Close the Scanner to free up resources
        input.close();
    }
}
