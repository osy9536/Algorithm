
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 괄호 짝짓기
// D4
public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 1; i<=10; i++) {
			int n = Integer.parseInt(br.readLine());
			String s =br.readLine();
			
			Stack<Character> stack = new Stack<>();
			for(int j = 0; j<s.length(); j++) {
				char now = s.charAt(j);
				if(now=='('||now=='['||now=='{'||now=='<') {
					stack.add(now);
				}else {
					if(stack.size()!=0) {
						if(now==')'&&stack.peek()=='(') {
							stack.pop();
						}
						else if(now=='}'&&stack.peek()=='{') {
							stack.pop();
						}
						else if(now==']'&&stack.peek()=='[') {
							stack.pop();
						}
						else if(now=='>'&&stack.peek()=='<') {
							stack.pop();
						}else {
							System.out.println("#" + i+" "+0);
							break;
						}
					}else {
						System.out.println("#" + i+" "+0);
						break;
					}
				}
			}
			if(stack.size()==0) System.out.println("#" + i+" "+ 1);
		}
	}
}
