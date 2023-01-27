import java.util.*;


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



