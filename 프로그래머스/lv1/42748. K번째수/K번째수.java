import java.util.*;

import static java.util.Collections.sort;
class Solution {
    public static int[] solution(int[] array, int[][] commands) {

        int[] answer = new int[commands.length]; // {0, 0, 0}

        for (int i = 0; i < commands.length; i++) {

            int a = commands[i][0];
            int b = commands[i][1];
            int c = commands[i][2];

            int[] arr1 = Arrays.copyOfRange(array, a-1, b);

            Arrays.sort(arr1); // 2,3,5,6

            answer[i] = arr1[c - 1]; // c =3 , -> 2
        }

        return answer;

    }
}




