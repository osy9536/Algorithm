
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 평범한 배낭
// gold 5
public class Main {
    static int[][] product;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        dp = new int[N+1][K+1];
        product= new int[N+1][2];
        for(int i = 1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            product[i][0] = Integer.parseInt(st.nextToken());
            product[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i<=N;i++){
            for(int j= 1; j<=K; j++){
                dp[i][j]=dp[i-1][j];
                if(j-product[i][0]>=0){
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - product[i][0]] + product[i][1]);
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}
