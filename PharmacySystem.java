import java.util.Scanner;

// ==========================================
// 1. LINKED LIST - For Pharmacy Inventory
// ==========================================
class MedicineNode {
    String name;
    double price;
    int quantity;
    MedicineNode next;

    public MedicineNode(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.next = null;
    }
}

class InventoryLinkedList {
    private MedicineNode head = null;

    // Add medicine to inventory
    public void addMedicine(String name, double price, int quantity) {
        MedicineNode newNode = new MedicineNode(name, price, quantity);
        if (head == null) {
            head = newNode;
        } else {
            MedicineNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println(">>> " + name + " successfully added to inventory.");
    }

    // Display all medicines
    public void displayInventory() {
        if (head == null) {
            System.out.println("Inventory is empty!");
            return;
        }
        System.out.println("\n===== Current Pharmacy Inventory =====");
        MedicineNode temp = head;
        while (temp != null) {
            System.out.println("Name: " + temp.name + " | Price: LKR " + temp.price + " | Quantity: " + temp.quantity);
            temp = temp.next;
        }
    }
}

// ==========================================
// 2. BINARY SEARCH TREE (BST) - For Fast Search
// ==========================================
class TreeNode {
    String medicineName;
    TreeNode left, right;

    public TreeNode(String name) {
        this.medicineName = name;
        this.left = this.right = null;
    }
}

class SearchBST {
    private TreeNode root = null;

    public void insert(String name) {
        root = insertRec(root, name);
    }

    private TreeNode insertRec(TreeNode root, String name) {
        if (root == null) {
            root = new TreeNode(name);
            return root;
        }
        if (name.compareToIgnoreCase(root.medicineName) < 0) {
            root.left = insertRec(root.left, name);
        } else if (name.compareToIgnoreCase(root.medicineName) > 0) {
            root.right = insertRec(root.right, name);
        }
        return root;
    }

    public boolean search(String name) {
        return searchRec(root, name);
    }

    private boolean searchRec(TreeNode root, String name) {
        if (root == null) return false;
        if (root.medicineName.equalsIgnoreCase(name)) return true;
        
        if (name.compareToIgnoreCase(root.medicineName) < 0) {
            return searchRec(root.left, name);
        }
        return searchRec(root.right, name);
    }
}

// ==========================================
// 3. QUEUE - For Customer Billing Queue
// ==========================================
class CustomerNode {
    String name;
    CustomerNode next;

    public CustomerNode(String name) {
        this.name = name;
        this.next = null;
    }
}

class CustomerQueue {
    private CustomerNode front = null;
    private CustomerNode rear = null;

    // Enqueue customer
    public void enqueue(String name) {
        CustomerNode newNode = new CustomerNode(name);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        System.out.println(">>> Customer " + name + " joined the queue.");
    }

    // Dequeue customer
    public void dequeue() {
        if (front == null) {
            System.out.println("No customers in the queue!");
            return;
        }
        System.out.println(">>> Customer " + front.name + " served and removed from queue.");
        front = front.next;
        if (front == null) {
            rear = null;
        }
    }

    // Display queue
    public void displayQueue() {
        if (front == null) {
            System.out.println("Queue is empty!");
            return;
        }
        System.out.println("\n===== Current Customer Queue =====");
        CustomerNode temp = front;
        int pos = 1;
        while (temp != null) {
            System.out.println(pos + ". " + temp.name);
            temp = temp.next;
            pos++;
        }
    }
}

// ==========================================
// MAIN SYSTEM CLASS WITH MENU
// ==========================================
public class PharmacySystem {
    public static void main(String[] args) {
        InventoryLinkedList inventory = new InventoryLinkedList();
        SearchBST searchTree = new SearchBST();
        CustomerQueue queue = new CustomerQueue();
        Scanner scanner = new Scanner(System.in);

        // Sample Data
        inventory.addMedicine("Paracetamol", 15.0, 500);
        searchTree.insert("Paracetamol");
        inventory.addMedicine("Amoxicillin", 45.0, 150);
        searchTree.insert("Amoxicillin");
        inventory.addMedicine("Vitamin-C", 8.5, 1000);
        searchTree.insert("Vitamin-C");

        while (true) {
            System.out.println("\n─────────────────────────────────");
            System.out.println("    PHARMACY MANAGEMENT SYSTEM   ");
            System.out.println("─────────────────────────────────");
            System.out.println("1. Add Medicine");
            System.out.println("2. View Inventory");
            System.out.println("3. Search Medicine (BST)");
            System.out.println("4. Add Customer to Queue");
            System.out.println("5. Serve Customer (Billing)");
            System.out.println("6. View Customer Queue");
            System.out.println("7. Exit");
            System.out.print("Enter your choice (1-7): ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter Medicine Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Price (LKR): ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter Quantity: ");
                    int qty = scanner.nextInt();
                    inventory.addMedicine(name, price, qty);
                    searchTree.insert(name);
                    break;
                case 2:
                    inventory.displayInventory();
                    break;
                case 3:
                    System.out.print("Enter Medicine Name to Search: ");
                    String searchName = scanner.nextLine();
                    if (searchTree.search(searchName)) {
                        System.out.println(">>> Status: Medicine is Available in stock.");
                    } else {
                        System.out.println(">>> Status: Out of Stock / Not Found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter Customer Name: ");
                    String custName = scanner.nextLine();
                    queue.enqueue(custName);
                    break;
                case 5:
                    queue.dequeue();
                    break;
                case 6:
                    queue.displayQueue();
            
                    break;
                case 7:
                    System.out.println("Exiting System. Thank you!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}