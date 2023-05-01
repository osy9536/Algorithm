
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int a1 = sc.nextInt() - 1;
            int a2 = sc.nextInt() - 1;
            int a3 = sc.nextInt() - 1;

            int x = a1;

            while (x % 24 != a2 || x % 29 != a3) {
                x += 365;
            }
            System.out.println("#" + (i + 1) + " " + (x + 1));
        }
    }
}