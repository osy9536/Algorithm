
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 다리 놓기
// silver 5
public class Main {
	static int[][] dp;
	static int n,m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc =1 ; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			dp= new int[30][30];DP();
			System.out.println(dp[m][n]);
		}
	}
	static void DP() {
		for(int i = 1; i<30; i++) {
			dp[i][i] = 1;
			dp[i][0]=1;
		}
		for(int i = 2; i<30; i++) {
			for(int j = 1; j<30; j++) {
				dp[i][j] = dp[i-1][j-1]+dp[i-1][j];
			}
		}
	}
}
