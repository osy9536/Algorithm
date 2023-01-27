import java.util.*;

import static java.util.Collections.sort;

class Solution {
    public static int solution(int[] nums) {
        int answer = 0;
        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i+1; j < nums.length - 1; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    if (sol(nums[i] + nums[j] + nums[k])) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }

    public static boolean sol(int n ){
        boolean bol = false;
        for (int i = 2; i < n; i++) {
            if(n%i==0){
                bol=false;
                break;
            }
            else bol=true;

        }
        return bol;

    }
}




