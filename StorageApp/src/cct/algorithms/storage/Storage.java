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

    public enum Mode { STACK, QUEUE }

    public static final int CAPACITY = 8;

    private final FoodItem[] items = new FoodItem[CAPACITY];
    private int n = 0;                 // quantity used 
    private Mode mode = Mode.STACK;    //LIFO

    // estado
    public boolean isEmpty() { return n == 0; }
    public boolean isFull()  { return n == CAPACITY; }
    public int size()        { return n; }
    public Mode mode()       { return mode; }

    // alterna o modo
    public void switchMode() {
        mode = (mode == Mode.STACK) ? Mode.QUEUE : Mode.STACK;
    }

    // add: same for both sides.
    public boolean add(FoodItem f) {
        if (isFull()) return false;
        items[n++] = f;
        return true;
    }

    // remove: depends of the mode.
    public FoodItem remove() {
        if (isEmpty()) return null;

        if (mode == Mode.STACK) {
            // LIFO
            FoodItem out = items[n - 1];
            items[--n] = null;
            return out;
        } else {
            // FIFO: take from the begining and "shift" to the left (O(n))
            FoodItem out = items[0];
            System.arraycopy(items, 1, items, 0, n - 1);
            items[--n] = null;
            return out;
        }
    }

    // peek: take the next without move
    public FoodItem peek() {
        if (isEmpty()) return null;
        return (mode == Mode.STACK) ? items[n - 1] : items[0];
    }

    // snapshot to list
    public FoodItem[] toArray() {
        FoodItem[] out = new FoodItem[n];
        System.arraycopy(items, 0, out, 0, n);
        return out;
    }
}

    
