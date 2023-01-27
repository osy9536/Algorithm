import java.util.*;

import static java.util.Collections.sort;

/*string 받고 각 인덱스 추출 후 정렬, 정렬된 인덱스와 */
class Solution {
     public static StringBuilder[] solution(String[] strings, int n) {
        StringBuilder[] sb = new StringBuilder[strings.length];
        for (int i = 0; i < strings.length; i++) {
            sb[i]= new StringBuilder(strings[i]);
        }
        for (int i = 0; i < sb.length; i++) {
            char c = sb[i].charAt(n);
            sb[i].reverse();
            sb[i].append(c);
            sb[i].reverse();
        }
        Arrays.sort(sb);
        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuilder(sb[i].substring(1, sb[i].length()));
        }
        return sb;
    }
}



