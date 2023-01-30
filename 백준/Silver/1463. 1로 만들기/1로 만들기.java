
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new Integer[n+1];
        dp[0] = dp[1]=0;
        System.out.println(sol(n));
    }
    static int sol(int n ) {
        if (n == 1) {
            return 0;
        }
        if (dp[n] == null) {
            if(n%6==0){
                dp[n]=Math.min(sol(n/3),Math.min(sol(n/2),sol(n-1)))+1;
            }
            else if(n%3==0){
                dp[n]=Math.min(sol(n/3),sol(n-1))+1;
            } else if (n % 2 == 0) {
                dp[n]=Math.min(sol(n/2),sol(n-1))+1;
            } else dp[n]=sol(n-1)+1;
        }
        return dp[n];
    }
}