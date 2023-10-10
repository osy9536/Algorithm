import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int R, C, T, air;
	static int[][] map, copyMap;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		air = 0;

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				int a = Integer.parseInt(st.nextToken());
				map[i][j] = a;
				if (a == -1)
					air = i - 1;
			}
		}

		for (int i = 0; i < T; i++) {
			copyMap = new int[R][C];
			deffusion();
			circulation(air, 1, 1, 0, copyMap[air][1]);
			circulation(air+1, 1, 1, 1, copyMap[air+1][1]);
			copyMap();
		}
		int answer = 0;
		for(int i = 0; i<R; i++) {
			for(int j = 0; j<C; j++) {
				if(map[i][j]==-1) continue;
				answer+=map[i][j];
			}
		}
		System.out.println(answer);
	}

	// up = 0, down = 1
	private static void circulation(int x, int y, int dir, int updown, int nowMise) {
		if(x == air+updown && y == 0) {
			copyMap[x][y]= -1;
			return;
		}
		int nx = x+dx[dir];
		int ny = y+dy[dir];
		if(updown==0) {
			if(nx==air&&ny==C-1) dir=0;
			else if(nx==0&&ny==C-1)dir = 3;
			else if(nx==0&&ny==0) dir = 2;
		}else {
			if(nx==air+1&&ny==C-1)dir = 2;
			else if(nx==R-1&&ny==C-1) dir = 3;
			else if(nx==R-1&&ny==0) dir = 0;
		}
		int nextMise = copyMap[nx][ny];
		copyMap[x][y] -= nowMise;
		copyMap[nx][ny]+=nowMise;
		circulation(nx, ny, dir, updown, nextMise);
	}

	private static void deffusion() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == -1) {
					copyMap[i][j] = -1;
					continue;
				}
				int cnt = 0;
				int num = map[i][j] / 5;
				for (int k = 0; k < 4; k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];

					if (nx >= 0 && ny >= 0 && nx < R && ny < C && map[nx][ny] != -1) {
						copyMap[nx][ny] += num;
						cnt++;
					}
				}

				copyMap[i][j] += map[i][j] - cnt * num;
			}
		}
	}

	private static void copyMap() {
		for (int i = 0; i < R; i++) {
			map[i] = copyMap[i].clone();
		}
	}
}
