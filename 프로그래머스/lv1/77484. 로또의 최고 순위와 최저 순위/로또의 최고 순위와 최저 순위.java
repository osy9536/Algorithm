import java.util.*;

class Solution {
    public static int[] solution(int[] lottos, int[] win_nums){
        int first = 0;
        int last = 0;
        int result= 6;
        int result2= 6;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <lottos.length; i++) {
            list.add(lottos[i]);
        }
        for (int i = 0; i < win_nums.length; i++) {
            if (list.contains(win_nums[i])) {
                first++;
                last++;
            }
            if (list.get(i)==0) {
                first++;
            }
        }
        if(first<2){
            result=6;
        }
        else result=result-first+1;
        if (last < 2) {
            result2=6;
        }
        else result2=result2-last+1;
        return new int[]{result, result2};
    }
}

