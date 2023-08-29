import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] cost = new int[3];
		int[][] home = new int[N+1][3];
		home[0][0] = home[0][1] = home[0][2] = 0;
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			cost[0] = Integer.parseInt(st.nextToken());
			cost[1] = Integer.parseInt(st.nextToken());
			cost[2] = Integer.parseInt(st.nextToken());
			home[i][0]=Math.min(home[i-1][1], home[i-1][2])+cost[0];
			home[i][1]=Math.min(home[i-1][2], home[i-1][0])+cost[1];
			home[i][2]=Math.min(home[i-1][0], home[i-1][1])+cost[2];
		}
		System.out.println(Math.min(home[N][0], Math.min(home[N][1], home[N][2])));
	}
}
