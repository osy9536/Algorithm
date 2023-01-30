import java.util.Arrays;

class Solution {
    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        for (int i = 0; i < lost.length ; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if(lost[i] == reserve[j])
                {
                    lost[i] = -2;
                    reserve[j]= -2;
                }
            }
        }
        answer = n - lost.length;
        for (int i = 0; i < reserve.length; i++) {
            for (int j = 0; j < lost.length; j++) {
                if (reserve[i] -1 == lost[j]) {
                    lost[j] = -2;
                    reserve[i] = -2;
                }
                if (reserve[i] + 1 == lost[j]) {
                    lost[j]=-2;
                    reserve[i]=-2;
                }
            }
        }
        for (int i = 0; i < lost.length; i++) {
            if (lost[i] == -2) {
                answer++;
            }
        }

//        System.out.println("lost = " + lost);
//        System.out.println("answer = " + answer);


        return answer;
    }
}