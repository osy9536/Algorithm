import java.util.*;

class Solution {
    public long solution(long n) {
        StringBuilder answer = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        while (n > 0) {
            list.add((int) (n % 10));
            n/=10;
        }
        list.sort(Collections.reverseOrder());
        for (int i = 0; i < list.size(); i++) {
            answer.append(list.get(i));
        }
        return Long.parseLong(String.valueOf(answer));
    }
}