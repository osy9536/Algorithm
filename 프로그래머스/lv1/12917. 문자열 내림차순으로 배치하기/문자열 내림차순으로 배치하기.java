import java.util.*;

import static java.util.Collections.sort;

/*string 받고 각 인덱스 추출 후 정렬, 정렬된 인덱스와 */
class Solution {
    public static StringBuilder solution(String s) {
        char[] c = s.toCharArray();
        Arrays.sort(c);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(c[i]);
        }
        return sb.reverse();

    }
}



