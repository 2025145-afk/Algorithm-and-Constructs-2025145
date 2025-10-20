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
/**
 *
 * @author diego
 */
public class fooditem {
    
      public final String name;
    public final int weightGrams;
    public final LocalDate bestBefore;      // hoje + 2 semanas (default)
    public final LocalDateTime placedAt;    // carimbo de hora

    public FoodItem(String name, int weightGrams) {
        this.name = name;
        this.weightGrams = weightGrams;
        this.bestBefore = LocalDate.now().plusWeeks(2);
        this.placedAt = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "FoodItem{name='" + name + "', weight=" + weightGrams +
                "g, bestBefore=" + bestBefore + ", placedAt=" + placedAt + "}";
    }
}
