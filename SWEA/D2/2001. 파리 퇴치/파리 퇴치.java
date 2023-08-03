
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 파리 퇴치
// D2
public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[][] arr = new int[n][n];

			for (int j = 0; j < n; j++) {
				arr[j] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}
			int max = 0;

			for (int j = 0; j < n - m+1 ; j++) {
				for (int k = 0; k < n - m+1 ; k++) {
					int sum = 0;
					for (int mj = 0; mj < m; mj++) {
						for (int mk = 0; mk < m; mk++) {
							sum += arr[j + mj][k + mk];
						}
					}
					if (sum > max)
						max = sum;
				}
			}
			bw.write("#"+i+" "+max+"\n");
		}
		bw.flush();
	}
}
