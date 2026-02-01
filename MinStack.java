import java.util.*;

public class MinStack {

    private Stack<Integer> mainStack;
    private Stack<Integer> minStack;

    public MinStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        mainStack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (mainStack.isEmpty()) return;

        int poppedValue = mainStack.pop();
        if (!minStack.isEmpty() && poppedValue == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        if (mainStack.isEmpty()) return -1;
        return mainStack.peek();
    }

    public int getMin() {
        if (minStack.isEmpty()) return -1;
        return minStack.peek();
    }

    // MAIN METHOD
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MinStack ms = new MinStack();

        System.out.print("Enter number of operations: ");
        int n = sc.nextInt();

        System.out.println("Enter operations:");
        System.out.println("1 x -> push x");
        System.out.println("2   -> pop");
        System.out.println("3   -> getMin");

        for (int i = 0; i < n; i++) {
            int op = sc.nextInt();

            if (op == 1) {          // push
                int x = sc.nextInt();
                ms.push(x);
            } 
            else if (op == 2) {     // pop
                ms.pop();
            } 
            else if (op == 3) {     // getMin
                System.out.println(ms.getMin());
            }
        }

        sc.close();
    }
}
