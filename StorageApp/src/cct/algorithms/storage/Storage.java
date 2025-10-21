/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cct.algorithms.storage;

/**
 *
 * @author diego
 */
public class Storage {

    public static final int CAPACITY = 8;

    private final FoodItem[] items = new FoodItem[CAPACITY];
    private int top = -1; // empty

    public boolean isEmpty() { return top == -1; }
    public boolean isFull()  { return top == CAPACITY - 1; }
    public int size()        { return top + 1; }

    // LIFO
    public boolean add(FoodItem f) {
        if (isFull()) return false;
        items[++top] = f;
        return true;
    }

    public FoodItem remove() {
        if (isEmpty()) return null;
        FoodItem out = items[top];
        items[top--] = null;
        return out;
    }

    public FoodItem peek() {
        return isEmpty() ? null : items[top];
    }

    public FoodItem[] toArray() {
        FoodItem[] out = new FoodItem[size()];
        System.arraycopy(items, 0, out, 0, size());
        return out;
    }
}


