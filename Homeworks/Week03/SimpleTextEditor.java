import java.util.*;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int q = sc.nextInt();
        StringBuilder s = new StringBuilder();
        Stack<String> history = new Stack<>();

        for (int i = 0; i < q; i++) {
            int type = sc.nextInt();

            if (type == 1) {
                String w = sc.next();
                history.push(s.toString());
                s.append(w);
            } else if (type == 2) {
                int k = sc.nextInt();
                history.push(s.toString());
                s.delete(s.length() - k, s.length());
            } else if (type == 3) {
                int k = sc.nextInt();
                System.out.println(s.charAt(k - 1));
            } else if (type == 4) {
                if (!history.isEmpty()) {
                    s = new StringBuilder(history.pop());
                }
            }
        }
        sc.close();
    }
}
