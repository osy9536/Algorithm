import java.util.*;

class Solution {
    public static int[] solution(int[] numbers) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                map.put(numbers[i] + numbers[j], true);
            }
        }
        int[] answer = new int[map.size()];
        int a = 0;
        for (int key : map.keySet()) {
            answer[a]=key;
            a++;
        }
        Arrays.sort(answer);
        return answer;
    }
}