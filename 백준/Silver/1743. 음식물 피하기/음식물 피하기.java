import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static boolean trash[][];
	static boolean visited[][];
	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { 1, 0, -1, 0 };

	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		trash = new boolean[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			trash[r - 1][c - 1] = true;
		}
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (trash[i][j] && !visited[i][j]) {
					int val = BFS(i, j);
					max = max > val ? max : val;
				}
			}
		}
		System.out.println(max);
	}

	static int BFS(int x, int y) {
		Queue<Node> q = new ArrayDeque<>();
		q.offer(new Node(x, y));
		visited[x][y]=true;
		int cnt = 1;
		while (!q.isEmpty()) {
			Node curPos = q.poll();
			int curX = curPos.getX();
			int curY = curPos.getY();
			for (int i = 0; i < 4; i++) {
				int nextX = curX + dx[i];
				int nextY = curY + dy[i];
				if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M 
						|| visited[nextX][nextY] || !trash[nextX][nextY])
					continue;
				q.offer(new Node(nextX, nextY));
				visited[nextX][nextY]=true;
				cnt++;
			}
		}
		return cnt;
	}
}
