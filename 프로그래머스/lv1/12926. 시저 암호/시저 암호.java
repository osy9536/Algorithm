import java.util.*;

class Solution {
    public static StringBuilder solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isUpperCase(c)) {
                c= (char) ((c-'A'+n)%26+'A');
            }
            if (Character.isLowerCase(c)) {
                c= (char) ((c-'a'+n)%26+'a');
            }
            sb.append(c);
        }
        return sb;

    }
}




