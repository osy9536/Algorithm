import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 5000000;
    static int[][] map;
    static int[][] dp;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dp = new int[n][1 << n]; // 비트마스킹

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(dfs(0, 1));
    }

    // 최단 거리 구하기
    private static int dfs(int city, int visited) {
        if (visited == (1 << n) - 1) {
            if (map[city][0] == 0) {
                return 11000000;
            }
            return map[city][0];
        }

        if (dp[city][visited] != 0) {
            return dp[city][visited];
        }

        int minDistance = INF;
        for (int i = 0; i < n; i++) {
            if ((visited & (1 << i)) == 0 && map[city][i] != 0) {
                int distance = dfs(i, visited | (1 << i)) + map[city][i];
                minDistance = Math.min(minDistance, distance);
            }
        }

        dp[city][visited] = minDistance;
        return minDistance;
    }
}
