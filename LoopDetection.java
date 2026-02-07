import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LoopDetection {

    Node head;

    // Insert at end
    public void insert(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null)
            temp = temp.next;

        temp.next = newNode;
    }

    // Create loop: last node -> 2nd node
    public void createTestLoop() {
        if (head == null || head.next == null)
            return;

        Node last = head;
        while (last.next != null)
            last = last.next;

        last.next = head.next; // loop created
        System.out.println("Loop created successfully.");
    }

    // Floyd’s Cycle Detection Algorithm
    public boolean hasLoopFloyd() {
        Node slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                return true;
        }
        return false;
    }

    // MAIN METHOD
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LoopDetection list = new LoopDetection();

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        System.out.println("Enter node values:");
        for (int i = 0; i < n; i++) {
            list.insert(sc.nextInt());
        }

        System.out.println("Loop present before creation: " + list.hasLoopFloyd());

        System.out.print("Create loop? (1 = Yes, 0 = No): ");
        int choice = sc.nextInt();

        if (choice == 1) {
            list.createTestLoop();
        }

        System.out.println("Loop present after creation: " + list.hasLoopFloyd());

        sc.close();
    }
}
