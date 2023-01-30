import java.util.*;

import static java.util.Collections.reverseOrder;
import static java.util.Collections.sort;
// 1, 2, 2, 2, 3, 3, 4, 6,
class Solution {
    public static int[] solution(int N, int[] stages) {
        int[] answer;
        Arrays.sort(stages);
        Double[] result = new Double[N];
        for (int i = 0; i < N; i++) {
            int cnt=0;
            for (int j = 0; j < stages.length; j++) {
                if (stages[j] >= i+1) {
                    cnt++;
                }
            }
            result[i] = (double) cnt;
        }

        for (int i = 0; i < N; i++) {
            int cnt = 0;
            for (int j = 0; j < stages.length; j++) {
                if (stages[j] == i + 1) {
                    cnt++;
                }
            }
            result[i]=cnt/result[i];
        }
        for (int i = 0; i < result.length; i++) {
            if (result[i].isNaN()) {
                result[i]= (double) 0;
            }
        }
        System.out.println(Arrays.toString(result));
        Double[] result2 = result.clone();
        Arrays.sort(result2, Comparator.reverseOrder());
        answer = new int[result2.length];
        for (int i = 0; i < result2.length; i++) {
            for (int j = 0; j < result2.length; j++) {
                if (Objects.equals(result2[i], result[j])) {
                    answer[i]=j+1;
                    result[j]= (double) -1;
                    break;
                }
            }
        }

        return answer;
    }
}





