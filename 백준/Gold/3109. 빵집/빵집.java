
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 빵집
// gold 2
public class Main {
	static String[][] map;
	static int R,C;
	static boolean check;
	static int cnt = 0;
	static int[] dx = {-1,0,1};
	static int[] dy = {1,1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new String[R][C];
		for(int i = 0; i<R; i++) {
			String s = br.readLine();
			for(int j = 0; j<C; j++) {
				map[i][j] = Character.toString(s.charAt(j));
			}
		}
		for(int i = 0; i<R; i++) {
			check = false;
			dfs(i,0);
		}
		System.out.println(cnt);
	}
	
	static void dfs(int x, int y) {
		if(check) return;
		if(y==C-1) {
			cnt++;
			check = true;
			return;
		}
		map[x][y]="X";
		for(int i = 0; i<3; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx>=0&&ny>=0&&nx<R&&ny<C&&map[nx][ny].equals(".")) {
				dfs(nx,ny);
			}
		}
	}
}