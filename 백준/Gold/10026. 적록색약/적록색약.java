
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static char[][] map;
	static boolean[][] visitedA, visitedB;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visitedA = new boolean[N][N];
		visitedB = new boolean[N][N];
		for(int i =0; i<N; i++) {
			String s = br.readLine();
			for(int j = 0; j<s.length(); j++) {
				map[i][j]=s.charAt(j);
			}
		}
		int aCnt = 0;
		int bCnt = 0;
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(!visitedA[i][j]) {
					dfs(i,j,map[i][j]);
					aCnt++;
				}
			}
		}
		for(int i =0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if((map[i][j]=='R'||map[i][j]=='G')&&!visitedB[i][j]) {
					dfsForA(i,j,map[i][j]);
					bCnt++;
				}
				else if(map[i][j]=='B'&&!visitedB[i][j]) {
					dfsForB(i, j);
					bCnt++;
				}
			}
		}
		System.out.println(aCnt+ " " +bCnt);
		
	}
	static void dfs(int x, int y, char c) {
		if(!visitedA[x][y]) {
			visitedA[x][y] = true;
			for(int i = 0; i<4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(nx>=0&&nx<N&&ny>=0&&ny<N&&!visitedA[nx][ny]) {
					if(map[nx][ny]==c) {
						dfs(nx, ny,c);
					}
				}
			}
		}
	}
	static void dfsForB(int x, int y) {
		if(!visitedB[x][y]) {
			visitedB[x][y] = true;
			for(int i = 0; i<4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(nx>=0&&nx<N&&ny>=0&&ny<N&&!visitedB[nx][ny]) {
					if(map[nx][ny]=='B') {
						dfsForB(nx, ny);
					}
				}
			}
		}
	}
	static void dfsForA(int x, int y, char c) {
		if(!visitedB[x][y]) {
			visitedB[x][y] = true;
			if(map[x][y]!=c) {
				map[x][y]=c;
			}
			for(int i = 0; i<4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(nx>=0&&nx<N&&ny>=0&&ny<N&&!visitedB[nx][ny]) {
					if(map[nx][ny]=='R'||map[nx][ny]=='G') {
						dfsForA(nx,ny, c);
					}
				}
			}
		}
	}
}
