
import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int[] arr = new int[n];
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                answer[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < answer.length; i++) {
            bw.write(answer[i] + " ");
        }
        bw.close();
        br.close();
    }
}
