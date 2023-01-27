import java.util.*;

import static java.util.Collections.sort;

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



