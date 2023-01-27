import java.util.*;

class Solution {
    public static boolean solution(int n ){
        boolean answer = true;
        int sum = 0;
        int tmp = n;
        while(n>0){
            sum+=n%10;
            n/=10;
        }
        if(tmp%sum==0){
            answer=true;
        }
        else answer=false;
        return answer;
    }
}

