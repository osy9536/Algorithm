import java.util.HashMap;
import java.util.Map;
class Solution {
    public static int solution(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], true);
        }
        if (map.size() > nums.length / 2) {
            return nums.length / 2;
        } else return map.size();
    }
}