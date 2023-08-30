
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 파이프 옮기기1
// gold 5
public class Main {
	static int[][][] dp;
	static int[][] map;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[N][N][3];
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp[0][1][0]=1;
		dp();
		System.out.println(dp[N-1][N-1][0]+dp[N-1][N-1][1]+dp[N-1][N-1][2]);
	}

	static void dp() {
		for (int x = 0; x < N; x++) {
			for (int y = 1; y < N; y++) {
				if (map[x][y] != 1) {
					dp[x][y][0] += dp[x][y - 1][0] + dp[x][y - 1][2];
					if(x==0)continue;
					dp[x][y][1] += dp[x - 1][y][1] + dp[x - 1][y][2];
					if(map[x-1][y]==0&&map[x][y-1]==0) {
						dp[x][y][2]+=dp[x-1][y-1][0]+dp[x-1][y-1][1]+dp[x-1][y-1][2];
					}
				}
			}
		}
	}
}
