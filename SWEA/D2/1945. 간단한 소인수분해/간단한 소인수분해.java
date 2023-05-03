
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 간단한 소인수분해
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            int a = 0, b = 0, c = 0, d = 0, e = 0;
            while (num % 2 == 0) {
                num/=2;
                a++;
            }
            while (num % 3 == 0) {
                num/=3;
                b++;
            }
            while (num % 5 == 0) {
                num/=5;
                c++;
            }
            while (num % 7 == 0) {
                num/=7;
                d++;
            }
            while (num % 11 == 0) {
                num/=11;
                e++;
            }
            System.out.println("#" + (i + 1) + " " + a + " " + b + " " + c + " " + d + " " + e);
        }
    }
}
