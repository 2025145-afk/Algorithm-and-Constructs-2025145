# Algorithms & Constructs — Storage (Stack/Queue)

**Student:** Diego (ID 2025145) — **GitHub:** 2025145-afk  
**Repository:** Algorithm-and-Constructs-2025145 — **Branch:** `main`

## Overview
Fixed-capacity storage (**8 items**) that can behave as a **STACK (LIFO)** or **QUEUE (FIFO)**.  
Items are `FoodItem` with: `name`, `weightGrams`, `bestBefore (≤ 2 weeks)`, `placedAt`.  
Console menu: Add / Remove / Show / Peek / Switch mode / Exit.

## Structure
- `FoodItem`: validations (weight > 0, allowed names, best-before ≤ 2 weeks).
- `Storage`: array-backed storage, `CAPACITY = 8`, modes:
  - **STACK (LIFO):** `remove()` is O(1).
  - **QUEUE (FIFO):** `remove()` shifts elements → O(n) (didactic choice).
- `App`: CLI (`main`) to interact with the structure.

## How to Run
1. Open in NetBeans.
2. Set **Main Class**: `cct.algorithms.storage.App`.
3. Run (F6) and use the menu.

## Complexity (Big-O)
| Operation              | STACK | QUEUE (with shift) |
|------------------------|-------|--------------------|
| add                    | O(1)  | O(1)               |
| remove                 | O(1)  | O(n)               |
| peek                   | O(1)  | O(1)               |
| toArray                | O(n)  | O(n)               |
| space (capacity 8)     | O(n)  | O(n)               |

> Note: A circular-buffer deque would make FIFO `remove()` O(1). Kept shift for clarity.

## Sample Session

## Notes
- Allowed items: Burger, Pizza, Fries, Sandwich, Hotdog.
- Best-before defaults to **today + 2 weeks**; explicit date is validated.

