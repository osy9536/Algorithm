
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// TITLE [S/W 문제해결 기본] 3일차 - String
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            int n = Integer.parseInt(br.readLine());
            String small = br.readLine();
            String big = br.readLine();
            int cnt = 0;
            for (int j = 0; j < big.length() - 1; j++) {
                if (big.charAt(j) == small.charAt(0)) {
                    String s = big.substring(j, j + small.length());
                    if (small.equals(s)) cnt++;
                }
            }

            System.out.println("#" + (i + 1) + " " + cnt);
        }
    }
}
