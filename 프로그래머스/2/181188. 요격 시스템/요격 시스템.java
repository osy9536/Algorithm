import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets, (o1,o2) -> (o1[1]-o2[1]));
        
        int value = -1;
        for(int[] target : targets){
            if(value==-1){
                answer++;
                value = target[1] -1;
                continue;
            }
            if(target[0]<=value && target[1]>=value) continue;
            
            answer++;
            value = target[1]-1;
        }        
        return answer;
    }
}