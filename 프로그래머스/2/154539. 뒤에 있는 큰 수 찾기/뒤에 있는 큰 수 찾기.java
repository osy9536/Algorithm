import java.util.*;
import java.math.*;
class Solution {
    public int[] solution(int[] numbers) {
         int[] answer = {};
        
        int len = numbers.length;
        answer = new int[len];
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<len; i++){
            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]){
                answer[stack.pop()] = numbers[i]; 
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()){
            answer[stack.pop()] = -1;
        }
        
        return answer;
    }
}