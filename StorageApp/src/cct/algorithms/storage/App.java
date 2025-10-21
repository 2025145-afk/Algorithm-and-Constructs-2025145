/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cct.algorithms.storage;
import java.time.LocalDate;
import java.util.Scanner;
/**
 *
 * @author diego
 */
public class App {
   private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Storage storage = new Storage();
        System.out.println("Storage started. Mode = " + storage.mode() + " (default: STACK/LIFO)");
        while (true) {
            System.out.println("\n--- Storage Menu ---");
            System.out.println("1) Add item");
            System.out.println("2) Remove item");
            System.out.println("3) Show items");
            System.out.println("4) Exit");
            System.out.print("Choose: ");

            int op = readInt();
            switch (op) {
                case 1 -> addItem(storage);
                case 2 -> removeItem(storage);
                case 3 -> showItems(storage);
                case 4 -> {
                    System.out.println("Bye!");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private static void addItem(Storage storage) {
        try {
            System.out.print("Name (Burger/Pizza/Fries/Sandwich/Hotdog): ");
            String name = in.nextLine().trim();

            System.out.print("Weight (grams): ");
            int weight = readInt();

            // usa o construtor padrão (bestBefore = hoje + 2 semanas)
            FoodItem f = new FoodItem(name, weight);
            if (storage.add(f)) {
                System.out.println("OK: added -> " + f);
            } else {
                System.out.println("Storage is FULL (capacity " + Storage.CAPACITY + ").");
            }
        } catch (IllegalArgumentException ex) {
            System.out.println("Validation error: " + ex.getMessage());
        }
    }

    private static void removeItem(Storage storage) {
        FoodItem out = storage.remove();
        if (out == null) {
            System.out.println("Storage is EMPTY.");
        } else {
            System.out.println("Removed -> " + out);
        }
    }

    private static void showItems(Storage storage) {
        FoodItem[] arr = storage.toArray();
        if (arr.length == 0) {
            System.out.println("(empty)");
            return;
        }
        System.out.println("Items (" + arr.length + "/" + Storage.CAPACITY + ") mode=" + storage.mode() + ":");
        for (int i = 0; i < arr.length; i++) {
            System.out.println("  [" + i + "] " + arr[i]);
        }
    }

    private static int readInt() {
        while (true) {
            String s = in.nextLine().trim();
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.print("Enter an integer: ");
            }
        }
    }
}  

