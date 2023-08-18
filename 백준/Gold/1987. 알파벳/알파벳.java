
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 알파벳
// gold 4
public class Main {
	static char[][] map;
	static boolean[] visited = new boolean[26];
	static int cnt = 0,R,C;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for(int i = 0; i<R ; i++) {
			String s = br.readLine();
			map[i] = s.toCharArray();
		}
		dfs(1,0,0);
		
		System.out.println(cnt);
	}
	static void dfs(int depth, int x, int y) {
		if(!visited[map[x][y]-'A']) {
			visited[map[x][y]-'A'] = true;
			for(int i = 0; i<4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(nx>=0&&ny>=0&&nx<R&&ny<C&&!visited[map[nx][ny]-'A']) {
					dfs(depth+1,nx,ny);
					visited[map[nx][ny]-'A']=false;
				}
			}if(depth>cnt)cnt = depth;
		}
		
	}
}
