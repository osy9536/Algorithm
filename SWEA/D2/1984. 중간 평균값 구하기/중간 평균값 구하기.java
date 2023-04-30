
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int sum = 0;
            int firstToken = sc.nextInt();
            int secondToken = sc.nextInt();
            int max, min;
            if (firstToken > secondToken) {
                max = firstToken;
                min = secondToken;
            } else {
                max = secondToken;
                min = firstToken;
            }

            for (int j = 0; j < 8; j++) {
                int nowToken = sc.nextInt();
                if (nowToken >= max) {
                    sum += max;
                    max = nowToken;
                } else if (nowToken <= min) {
                    sum += min;
                    min = nowToken;
                } else sum += nowToken;
            }
            System.out.println("#" + (i + 1) + " " + Math.round((float) sum / 8.0f));
        }
    }
}