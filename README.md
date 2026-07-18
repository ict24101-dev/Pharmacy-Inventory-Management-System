# Pharmacy Management System

A console-based Java application that demonstrates the practical use of three core data structures — **Linked List**, **Binary Search Tree**, and **Queue** — to solve a real-world pharmacy inventory and customer billing workflow.

Developed as the practical assignment for **Data Structures and Algorithms (ICT 143-2)**, Department of Information and Communication Technology, Faculty of Technological Studies, Uva Wellassa University of Sri Lanka.

## Overview

Manual pharmacy record-keeping breaks down as scale grows — searching for a medicine is slow, stock changes constantly, and customers are served out of order. This project automates all three problems in a single menu-driven Java console application:

| Problem | Data Structure | Result |
|---|---|---|
| Dynamic, ever-changing stock | **Linked List** | Add and view medicines with no fixed-size limit |
| Slow medicine lookup | **Binary Search Tree** | Check availability in O(log n) average time |
| Unfair customer service | **Queue** | Serve customers strictly in arrival order (FIFO) |

## Features

- **Add Medicine** – insert a new medicine (name, price, quantity) into the inventory
- **View Inventory** – display the full list of current stock
- **Search Medicine (BST)** – quickly check whether a medicine is in stock
- **Add Customer to Queue** – enqueue a customer for billing
- **Serve Customer (Billing)** – dequeue and serve the next customer, FIFO
- **View Customer Queue** – display customers currently waiting
- **Exit** – safely close the application

## Data Structures & Algorithms

### 1. Linked List — Medicine Inventory (`InventoryLinkedList`, `MedicineNode`)
Each medicine is stored as a node (`name`, `price`, `quantity`, `next`). New medicines are appended to the tail — O(n) — with no shifting or resizing needed, unlike an array.

### 2. Binary Search Tree — Fast Medicine Search (`SearchBST`, `TreeNode`)
Medicine names are inserted and searched recursively, comparing left/right using `compareToIgnoreCase`. A reasonably balanced tree reduces average search time from O(n) to **O(log n)** by discarding half the remaining names at every comparison.

### 3. Queue — Customer Billing (`CustomerQueue`, `CustomerNode`)
Customers are enqueued at the `rear` and served from the `front`, enforcing strict First-In-First-Out order — both `enqueue()` and `dequeue()` run in O(1).

## Tech Stack

- **Language:** Java (JDK 8+)
- **Interface:** Console / command-line (menu-driven)
- **Dependencies:** None — pure Java, no external libraries

## Project Structure

```
PharmacySystem.java   # Single-file application containing:
                       #   - MedicineNode, InventoryLinkedList   (Linked List)
                       #   - TreeNode, SearchBST                 (Binary Search Tree)
                       #   - CustomerNode, CustomerQueue          (Queue)
                       #   - PharmacySystem (main)                (Console menu)
```

## How to Run

1. **Clone the repository**
   ```bash
   git clone https://github.com/<your-username>/<your-repo-name>.git
   cd <your-repo-name>
   ```

2. **Compile**
   ```bash
   javac PharmacySystem.java
   ```

3. **Run**
   ```bash
   java PharmacySystem
   ```

4. Use the on-screen menu (1–7) to add medicines, search stock, manage the customer queue, and exit.

> The application starts with three sample medicines pre-loaded (Paracetamol, Amoxicillin, Vitamin-C) so you can try search and queue features immediately.

## Sample Usage

```
─────────────────────────────────
    PHARMACY MANAGEMENT SYSTEM
─────────────────────────────────
1. Add Medicine
2. View Inventory
3. Search Medicine (BST)
4. Add Customer to Queue
5. Serve Customer (Billing)
6. View Customer Queue
7. Exit
Enter your choice (1-7): 3
Enter Medicine Name to Search: Vitamin-C
>>> Status: Medicine is Available in stock.
```

## Author

**H.K. Sandaruwan**
Index No: UWU/ICT/24/101
Data Structures and Algorithms (ICT 143-2)
Faculty of Technological Studies, Uva Wellassa University of Sri Lanka

## License

This project was developed for academic purposes as part of the ICT 143-2 practical assignment.
