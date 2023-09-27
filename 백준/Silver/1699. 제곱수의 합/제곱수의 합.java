import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int dp[] = new int[N+1];
		for(int i=1;i<=N;i++)
			dp[i]=i;
		for(int i=2;i<=N;i++) {
			for(int j=2;j*j<=i;j++) {
				dp[i]=dp[i]<dp[i-j*j]+1?dp[i]:dp[i-j*j]+1;
			}
		}
		System.out.println(dp[N]);
	}
}
