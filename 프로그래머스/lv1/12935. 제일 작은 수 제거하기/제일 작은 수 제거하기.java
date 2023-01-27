import java.util.*;

class Solution {
    public int[] solution(int[] arr){
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        int[] answer;
        if (arr.length == 1) {
            answer = new int[]{-1};
        }
        else {
            int j = 0;
            answer=new int[arr.length-1];
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != min) {
                    answer[j]=arr[i];
                    j++;
                }
            }
        }
        return answer;
    }
}

