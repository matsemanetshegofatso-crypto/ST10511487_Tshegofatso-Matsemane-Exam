/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.exam;

/**
 *
 * @author Student
 */
public interface IProduct {
    // Returns the total number of products sold across all products and months
    int GetTotalProductsSold();

    // Returns the average number of products sold (total divided by number of entries)
    double GetAverageProductSold();

    // Returns the name and total sales of the product with the highest total sales
    String GetMostPopularProduct();
}
