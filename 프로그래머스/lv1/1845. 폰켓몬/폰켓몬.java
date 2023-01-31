import java.util.HashMap;
import java.util.Map;
class Solution {
    public static int solution(int[] nums) {
        int answer = 0;
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], true);
        }
        if (map.size() > nums.length / 2) {
            answer = nums.length / 2;
        } else answer = map.size();
        return answer;
    }
}