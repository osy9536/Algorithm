
import java.util.ArrayList;
import java.util.List;

// TITLE 큰 수 만들기

class Solution {
    public static String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();

        int cnt = number.length() - k;
        int left = 0;
        int maxIdx = 0;

        while (cnt > 0) {
            char maxDigit = '0';
            for (int i = left; i <= number.length() - cnt; i++) {
                if (number.charAt(i) > maxDigit) {
                    maxDigit = number.charAt(i);
                    maxIdx = i;
                }
            }
            sb.append(maxDigit);
            left = maxIdx + 1;
            cnt--;
        }

        return sb.toString();
    }
}