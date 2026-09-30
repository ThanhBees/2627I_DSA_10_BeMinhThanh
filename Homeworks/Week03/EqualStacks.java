import java.util.*;

public class EqualStacks {
    public static int equalStacks(int[] h1, int[] h2, int[] h3) {
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        Stack<Integer> st3 = new Stack<>();

        int sum1 = 0; int sum2 = 0; int sum3 = 0;

        for (int i = h1.length - 1; i >= 0; i--) {
            st1.push(h1[i]);
            sum1 += h1[i];
        }
        for (int i = h2.length - 1; i >= 0; i--) {
            st2.push(h2[i]);
            sum2 += h2[i];
        }
        for (int i = h3.length - 1; i >= 0; i--) {
            st3.push(h3[i]);
            sum3 += h3[i];
        }

        while (sum1 != sum2 || sum2 != sum3) {
            if (sum1 >= sum2 && sum1 >= sum3) {
                sum1 -= st1.pop();
            } else if (sum2 >= sum1 && sum2 >= sum3) {
                sum2 -= st2.pop();
            } else if (sum3 >= sum1 && sum3 >= sum2) {
                sum3 -= st3.pop();
            }
        }

        return sum1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNext()) return;

        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int n3 = sc.nextInt();

        int[] h1 = new int[n1];
        for (int i = 0; i < n1; i++){
            h1[i] = sc.nextInt();
        }
        int[] h2 = new int[n2];
        for (int i = 0; i < n2; i++){
            h2[i] = sc.nextInt();
        }
        int[] h3 = new int[n3];
        for (int i = 0; i < n3; i++){
            h3[i] = sc.nextInt();
        }

        System.out.println(equalStacks(h1, h2, h3));

        sc.close();
    }
}
