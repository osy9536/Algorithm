import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int map[][];
	static Node wall[];
	static int N, M, min = Integer.MAX_VALUE;
	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { 1, 0, -1, 0 };
	static boolean visited[][][];

	static class Node {
		private int x;
		private int y;
		private int crush;

		public Node(int x, int y, int crush) {
			super();
			this.x = x;
			this.y = y;
			this.crush = crush;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

		public int getCrush() {
			return crush;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		wall = new Node[N * M];
		String[] str;
		int wallCnt = 0;
		for (int i = 0; i < N; i++) {
			str = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(str[j]);
				if (map[i][j] == 1) {
					wall[wallCnt] = new Node(i, j, 0);
					wallCnt++;
				}
			}
		}

		System.out.println(bfs());
	}

	static int bfs() {
		Queue<Node> q = new ArrayDeque<>();
		visited = new boolean[2][N][M];
		q.offer(new Node(0, 0, 0));
		visited[0][0][0] = true;
		visited[1][0][0] = true;
		int cnt = 1;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Node cur = q.poll();
				int curX = cur.getX();
				int curY = cur.getY();
				int curCrush = cur.getCrush();
				if (curX == N - 1 && curY == M - 1)
					return cnt;
				for (int j = 0; j < 4; j++) {
					int nextX = curX + dx[j];
					int nextY = curY + dy[j];
					if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && !visited[curCrush][nextX][nextY]) {
						if (map[nextX][nextY] == 0) {
							q.offer(new Node(nextX, nextY, curCrush));
							visited[curCrush][nextX][nextY] = true;
						} else {
							if(curCrush==1) continue;
							q.offer(new Node(nextX, nextY, 1));
							visited[1][nextX][nextY] = true;
						}
					}
				}
			}
			cnt++;
		}
		return -1;
	}
}