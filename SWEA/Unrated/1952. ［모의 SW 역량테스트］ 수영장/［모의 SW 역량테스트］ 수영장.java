
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int minPay;
	static int[] pays,plan;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			pays = new int[4];
			plan = new int[12];
			minPay = Integer.MAX_VALUE;
			for(int i = 0; i<4; i++) {
				pays[i]=Integer.parseInt(st.nextToken());
			}
			st=new StringTokenizer(br.readLine());
			for(int i = 0; i<12; i++) {
				plan[i]=Integer.parseInt(st.nextToken());
			}
			
			dfs(0,0);
			System.out.println("#"+tc+" "+Math.min(minPay, pays[3]));
			
		}
		
	}

	private static void dfs(int sum, int cnt) {
		if(cnt>=12) {
			if(sum<minPay)minPay=sum;
			return;
		}
		else {
			if(plan[cnt]!=0) {
				dfs(sum+(pays[0]*plan[cnt]),cnt+1);
				dfs(sum+pays[1],cnt+1);
				dfs(sum+pays[2],cnt+3);
			}else {
				dfs(sum,cnt+1);
			}
		}
	}
}
