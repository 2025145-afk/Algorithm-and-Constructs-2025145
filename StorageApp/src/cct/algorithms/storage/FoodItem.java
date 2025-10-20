/*Project:   CCT – Algorithms & Constructs (Storage)
 Student:   Diego — ID 2025145 (2025145-afk)
 Email:     2025145@student.cct.ie
 Lecturer:  Taufique Ahmed
 Date:      2025-10-17
Course:    Higher diploma science Computing — Algorithms & Constructs
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cct.algorithms.storage;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

/**
 *
 * @author diego
 */

public class FoodItem {
    // allowed items
    public static final Set<String> ALLOWED =
            Set.of("Burger", "Pizza", "Fries", "Sandwich", "Hotdog");

    public final String name;
    public final int weightGrams;
    public final LocalDate bestBefore;
    public final LocalDateTime placedAt;

    // default: today + 2 weeks
    public FoodItem(String name, int weightGrams) {
        this(name, weightGrams, LocalDate.now().plusWeeks(2));
    }

    // explicit date + validations
    public FoodItem(String name, int weightGrams, LocalDate bestBefore) {
        if (weightGrams <= 0)
            throw new IllegalArgumentException("Weight must be > 0");
        if (!ALLOWED.contains(name))
            throw new IllegalArgumentException("Invalid item. Allowed: " + ALLOWED);

        LocalDate max = LocalDate.now().plusWeeks(2);
        if (bestBefore.isAfter(max))
            throw new IllegalArgumentException("Best-before cannot exceed 2 weeks from today.");

        this.name = name;
        this.weightGrams = weightGrams;
        this.bestBefore = bestBefore;
        this.placedAt = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "FoodItem{name='" + name + "', weight=" + weightGrams +
                "g, bestBefore=" + bestBefore + ", placedAt=" + placedAt + "}";
    }
}
