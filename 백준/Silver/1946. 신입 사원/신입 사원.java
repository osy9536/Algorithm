import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t=0; t<T; t++) {
			// 지원자 수
			int n = Integer.parseInt(br.readLine());
			
			// 서류심사, 면접 성적
			int[][] scores = new int[n][2];
		
			for (int i=0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				scores[i] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			}
			
			// 성적 정렬
			Arrays.sort(scores, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[0] - o2[0]; // 서류심사 성적 오름차순
				}	
			});
			
			
			int answer = 0;
			int s = n+1; // 기준이 될 면접 성적
			
			for (int i=0; i<n; i++) {
				// 면접 성적이 더 좋은 경우
				if (scores[i][1] < s) {
					answer++;
					s = scores[i][1]; // 기준 갱신
				}
			}
			
			sb.append(answer).append("\n");
			
		}
		
		System.out.print(sb);
	}
}
