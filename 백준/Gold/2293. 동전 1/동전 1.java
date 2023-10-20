import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 동전 1
// gold 5
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] dp = new int[k+1];
        dp[0]=1;
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());
            for (int j = a; j <=k; j++) {
                dp[j]+=dp[j-a];
            }
        }
        System.out.println(dp[k]);
    }
}
