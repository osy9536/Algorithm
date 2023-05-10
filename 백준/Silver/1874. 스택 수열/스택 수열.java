
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int idx = 1;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num >= idx) {
                while (num >= idx) {
                    stack.push(idx++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            }  else {
                if (!stack.isEmpty() && num == stack.peek()) {
                    stack.pop();
                    sb.append("-\n");
                } else {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.print(sb);
    }
}