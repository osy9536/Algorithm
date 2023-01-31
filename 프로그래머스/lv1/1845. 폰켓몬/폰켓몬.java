import java.util.HashMap;
import java.util.Map;
class Solution {
    public static int solution(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, true);
        }
        return Math.min(map.size(), nums.length / 2);
    }
}