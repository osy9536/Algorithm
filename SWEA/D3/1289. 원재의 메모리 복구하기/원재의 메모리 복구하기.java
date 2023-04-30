
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            char c = '0';
            int cnt = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) != c) {
                    cnt++;
                    c = s.charAt(j);
                }
            }
            System.out.println("#" + (i + 1) + " " + cnt);
        }
    }
}
