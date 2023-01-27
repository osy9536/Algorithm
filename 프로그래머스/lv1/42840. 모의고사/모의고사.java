import java.util.*;

class Solution {
    public static List<Integer> solution(int[] answers){
        List<Integer> list = new ArrayList<>();
        int[] num1={1,2,3,4,5};
        int[] num2={2,1,2,3,2,4,2,5};
        int[] num3={3,3,1,1,2,2,4,4,5,5};
        int n1 = 0, n2 = 0, n3 = 0;
        for (int i = 0; i < answers.length; i++) {
            if (num1[i % num1.length] == answers[i]) n1++;
            if (num2[i % num2.length] == answers[i]) n2++;
            if (num3[i % num3.length] == answers[i]) n3++;
        }
        int max = Math.max(n1, Math.max(n2, n3));
        if(max==n1) list.add(1);
        if(max==n2) list.add(2);
        if(max==n3) list.add(3);

        return list;
    }
}



