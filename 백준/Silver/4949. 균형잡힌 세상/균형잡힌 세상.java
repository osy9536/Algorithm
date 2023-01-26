
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String s = br.readLine();
            Stack<Integer> stack = new Stack<>();
            if (s.equals(".")) {
                break;
            }
            for (int i = 0; i <s.length() ; i++) {
                if (s.charAt(i) == '(') {
                    stack.push(1);
                }
                else if (s.charAt(i) == '[') {
                    stack.push(2);
                }
                else if (s.charAt(i) == ')') {
                    if(stack.empty()){
                        stack.push(0);
                        break;
                    }
                    if (stack.peek() == 1) {
                        stack.pop();
                    }
                    else {
                        break;
                    }
                }

                else if (s.charAt(i) == ']') {
                    if(stack.empty()){
                        stack.push(0);
                        break;
                    }
                    if (stack.peek() == 2) {
                        stack.pop();
                    }
                    else {
                        break;
                    }
                }
            }
            if(stack.empty()) System.out.println("yes");
            else System.out.println("no");

        }
    }
}
