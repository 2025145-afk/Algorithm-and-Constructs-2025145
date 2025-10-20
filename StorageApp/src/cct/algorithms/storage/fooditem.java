/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cct.algorithms.storage;

/**
 *
 * @author diego
 */
public class fooditem {
      public final String name;       // e.g., Burger, Pizza...
    public final int weightGrams;   // em gramas

    public FoodItem(String name, int weightGrams) {
        this.name = name;
        this.weightGrams = weightGrams;
    }

    @Override
    public String toString() {
        return "FoodItem{name='" + name + "', weight=" + weightGrams + "g}";
    }
}
