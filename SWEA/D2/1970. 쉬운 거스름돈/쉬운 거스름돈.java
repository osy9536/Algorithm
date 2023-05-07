
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 쉬운 거스름돈
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println("#" + (i + 1));
            System.out.print(n / 50000 + " ");
            n %= 50000;
            System.out.print(n / 10000 + " ");
            n %= 10000;
            System.out.print(n / 5000 + " ");
            n %= 5000;
            System.out.print(n / 1000 + " ");
            n %= 1000;
            System.out.print(n / 500 + " ");
            n %= 500;
            System.out.print(n / 100 + " ");
            n %= 100;
            System.out.print(n / 50 + " ");
            n %= 50;
            System.out.print(n / 10 +"\n");
        }
    }
}