
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i = 1; i<=T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int max = 0;
			int[] arr = new int[n];
			
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<n; j++) {
				arr[j]=Integer.parseInt(st.nextToken());
			}
			for(int j = 0; j<n-1; j++) {
				for(int k = j+1; k<n; k++) {
					int sum = arr[j]+arr[k];
					if(sum>max&&sum<=m)max=sum;
				}
			}
			if(max ==0) System.out.println("#"+i+" "+ "-1");
			else System.out.println("#"+i+" "+max);
		}
	}
}
