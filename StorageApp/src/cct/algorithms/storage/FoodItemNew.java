/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * Algorithms & Constructs – Storage (STACK/QUEUE)
 * Student: Diego (ID 2025145) – GitHub: 2025145-afk
 * Repo: Algorithm-and-Constructs-2025145 (branch main)
 * Description: CLI to add/remove/show/peek FoodItem with fixed capacity (8) and modes STACK/LIFO or QUEUE/FIFO.
 * Date: <put today’s date>
 */
package cct.algorithms.storage;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
/**
 *
 * @author diego
 */
public class FoodItemNew {
    // ---- Public, immutable data (simple record-style class) ----
    public final String name;            // e.g., "Burger"
    public final int    weightGrams;     // strictly positive
    public final LocalDate bestBefore;   // expiry date (max: +2 weeks)
    public final LocalDateTime placedAt; // creation timestamp

    // Allowed product names for this assignment (could come from config)
    private static final Set<String> ALLOWED =
            Set.of("Burger", "Pizza", "Fries", "Sandwich", "Hotdog");

    /**
     * Convenience constructor: best-before defaults to (today + 2 weeks).
     *
     * @param name         product name (must be in ALLOWED)
     * @param weightGrams  strictly > 0
     */
    public FoodItemNew(String name, int weightGrams) {
        this(name, weightGrams, LocalDate.now().plusWeeks(2));
    }

    /**
     * Full constructor with explicit best-before.
     * Validates all invariants and records a timestamp in placedAt.
     *
     * @param name         product name (must be in ALLOWED)
     * @param weightGrams  strictly > 0
     * @param bestBefore   must be ≤ (today + 2 weeks)
     *
     * @throws IllegalArgumentException if any invariant is violated
     */
    public FoodItemNew(String name, int weightGrams, LocalDate bestBefore) {
        // ---- Validation: O(1) checks ----
        if (weightGrams <= 0) {
            throw new IllegalArgumentException("Weight must be > 0");
        }
        if (!ALLOWED.contains(name)) {
            throw new IllegalArgumentException(
                "Invalid item. Allowed: " + ALLOWED);
        }

        LocalDate max = LocalDate.now().plusWeeks(2);
        if (bestBefore.isAfter(max)) {
            throw new IllegalArgumentException(
                "Best-before cannot exceed 2 weeks from today.");
        }

        // ---- Assign once (immutability) ----
        this.name = name;
        this.weightGrams = weightGrams;
        this.bestBefore = bestBefore;
        this.placedAt = LocalDateTime.now();
    }

    /**
     * Human-readable representation used in CLI lists.
     */
    @Override
    public String toString() {
        return "FoodItem{name='" + name + "', weight=" + weightGrams +
               "g, bestBefore=" + bestBefore + ", placedAt=" + placedAt + "}";
    }
}
    

