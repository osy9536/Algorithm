
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 파이프 옮기기 2
// gold 4
public class Main {

    static long[][] map;
    static long[][][] dp;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new long[N][N];
        dp = new long[N][N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int a = Integer.parseInt(st.nextToken());
                map[i][j] = a;
            }
        }
        dp[0][1][0] = 1;
        dp();
        System.out.println(dp[N-1][N-1][0]+dp[N-1][N-1][1]+dp[N-1][N-1][2]);
    }

    private static void dp() {
        for (int i = 0; i < N; i++) {
            for (int j = 1; j < N; j++) {
                if(map[i][j]==1)continue;
                dp[i][j][0] += dp[i][j - 1][0] + dp[i][j - 1][2];
                if (i == 0) continue;
                dp[i][j][1] += dp[i - 1][j][1] + dp[i - 1][j][2];
                if (map[i - 1][j] != 1 && map[i][j - 1] != 1) {
                    dp[i][j][2] += dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
                }
            }
        }
    }
}
