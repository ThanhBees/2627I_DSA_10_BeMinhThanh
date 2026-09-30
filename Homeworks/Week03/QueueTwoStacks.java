import java.util.*;

public class QueueTwoStacks {
    private static Stack<Integer> stackPush = new Stack<>();
    private static Stack<Integer> stackPop = new Stack<>();

    private static void shiftStacks() {
        if (stackPop.isEmpty()) {
            while(!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
    }

    public static void enqueue(int x) {
        stackPush.push(x);
    }

    public static void dequeue() {
        shiftStacks();
        stackPop.pop();
    }

    public static int peek() {
        shiftStacks();
        return stackPop.peek();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int type = sc.nextInt();
            if (type == 1) {
                int x = sc.nextInt();
                enqueue(x);
            } else if (type == 2) {
                dequeue();
            } else if (type == 3) {
                System.out.println(peek());
            }
        }
        sc.close();
    }
}
