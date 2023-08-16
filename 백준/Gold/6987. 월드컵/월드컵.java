
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 월드컵
// gold 4
public class Main {
	static boolean check;
	static int[] wins, loses, draws;
	static int[] t1, t2;

	static void dfs(int idx) {
		if (check)
			return;
		if (idx == 15) {
			check = true;
			return;
		}
		int a = t1[idx];
		int b = t2[idx];
		if (wins[a] > 0 && loses[b] > 0) {
			wins[a]--;
			loses[b]--;
			dfs(idx + 1);
			wins[a]++;
			loses[b]++;
		}
		if (draws[a] > 0 && draws[b] > 0) {
			draws[a]--;
			draws[b]--;
			dfs(idx + 1);
			draws[a]++;
			draws[b]++;
		}
		if (loses[a] > 0 && wins[b] > 0) {
			loses[a]--;
			wins[b]--;
			dfs(idx + 1);
			loses[a]++;
			wins[b]++;
		}
		

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t1 = new int[15];
		t2 = new int[15];
		int cnt = 0;
		for(int i=0;i<5;i++) {
			for(int j=i+1;j<6;j++) {
				t1[cnt]=i;
				t2[cnt++]=j;
			}
		}
		for(int tc = 0; tc<4; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			wins = new int[6];
			loses = new int[6];
			draws = new int[6];
			int win = 0;
			int lose = 0;
			int draw = 0;
			check = false;
			for(int i = 0; i<6; i++) {
				win+=wins[i] =Integer.parseInt(st.nextToken());
				draw+=draws[i] =Integer.parseInt(st.nextToken());
				lose+=loses[i] =Integer.parseInt(st.nextToken());
			}
			if(win+lose+draw!=30)check = false;
			else dfs(0);
			
			if(check) System.out.print(1+" ");
			else System.out.print(0+" ");
		}
	}
}
