import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int map[][], temp[][];
	static Node wall[];
	static int N, M, min = Integer.MAX_VALUE;
	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { 1, 0, -1, 0 };
	static boolean visited[][][];

	static class Node {
		private int x;
		private int y;
		private boolean crush;

		public Node(int x, int y, boolean crush) {
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

		public boolean getCrush() {
			return crush;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		temp = new int[N][M];
		wall = new Node[N * M];
		String[] str;
		int wallCnt = 0;
		for (int i = 0; i < N; i++) {
			str = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(str[j]);
				if (map[i][j] == 1) {
					wall[wallCnt] = new Node(i, j, false);
					wallCnt++;
				}
			}
		}

		copy();
		bfs();
		if (min == Integer.MAX_VALUE)
			min = -1;
		System.out.println(min);
	}

	static void copy() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++)
				temp[i][j] = map[i][j];
		}
	}

	static void bfs() {
		Queue<Node> q = new ArrayDeque<>();
		visited = new boolean[2][N][M];
		q.offer(new Node(0, 0, false));
		visited[0][0][0] = true;
		visited[1][0][0] = true;
		int cnt = 1;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Node cur = q.poll();
				int curX = cur.getX();
				int curY = cur.getY();
				boolean curCrush = cur.getCrush();
				if (curX == N - 1 && curY == M - 1) {
					min = min < cnt ? min : cnt;
					return;
				}
				for (int j = 0; j < 4; j++) {
					int nextX = curX + dx[j];
					int nextY = curY + dy[j];
					if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
						if (temp[nextX][nextY] == 0 ) {
							if(!visited[0][nextX][nextY] && !curCrush) {
								q.offer(new Node(nextX, nextY, false));
								visited[0][nextX][nextY] = true;
							} else if(!visited[1][nextX][nextY]) {
								q.offer(new Node(nextX, nextY, true));
								visited[1][nextX][nextY] = true;
							}
						} else if (temp[nextX][nextY] == 1 && !visited[1][nextX][nextY] && !curCrush) {
							q.offer(new Node(nextX, nextY, true));
							visited[1][nextX][nextY] = true;
						}
					}
				}
			}
			cnt++;
		}
	}
}