import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<Integer> stack = new Stack<>();
        int expectedNumber = 1;
        boolean possible = true;

        for (int i = 0; i < n; i++) {
            int currentNumber = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty() && stack.peek() == expectedNumber) {
                stack.pop();
                expectedNumber++;
            }

            if (currentNumber == expectedNumber) {
                expectedNumber++;
            } else {
                stack.push(currentNumber);
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == expectedNumber) {
                stack.pop();
                expectedNumber++;
            } else {
                possible = false;
                break;
            }
        }

        if (possible) {
            System.out.println("Nice");
        } else {
            System.out.println("Sad");
        }
    }
}
