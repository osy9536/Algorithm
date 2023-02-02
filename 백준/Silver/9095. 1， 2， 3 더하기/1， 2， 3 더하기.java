import java.util.Scanner;

public class Main {
    static Integer dp[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new Integer[11];
        dp[0]=0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            
            if (a < 11) {
                test(a);
                System.out.println(dp[a]);
            }
            else break;
        }
    }

    static int test(int n) {
        if (dp[n] == null) {
            dp[n] = test(n - 1) + test(n - 2) + test(n - 3);
        }
        return dp[n];
    }
}