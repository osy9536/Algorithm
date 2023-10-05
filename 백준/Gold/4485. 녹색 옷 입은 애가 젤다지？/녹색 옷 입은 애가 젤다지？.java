
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 녹색 옷 입은 애가 젤다지?
// gold 4
public class Main {

	static class Node {
		int x, y, sum;

		Node(int x, int y, int sum) {
			this.x = x;
			this.y = y;
			this.sum = sum;
		}
	}

	static int[][] map;
	static int[][] sums;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int N, answer;
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		while (true) {
			cnt++;
			N = Integer.parseInt(br.readLine());
			if (N == 0)
				break;
			map = new int[N][N];
			sums = new int[N][N];
			for(int i = 0; i<N; i++) {
				Arrays.fill(sums[i], Integer.MAX_VALUE);
			}
			answer = Integer.MAX_VALUE;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			BFS();
			System.out.println("Problem "+cnt+": "+sums[N-1][N-1]);
		}
	}
	
	static void BFS(){
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0, 0, map[0][0]));
		sums[0][0] = map[0][0];
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			if(cur.x==N-1&&cur.y==N-1)continue;
			
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if(nx>=0&&ny>=0&&nx<N&&ny<N) {
					if(sums[nx][ny]>cur.sum+map[nx][ny]) {
						sums[nx][ny] = cur.sum+map[nx][ny];
						q.add(new Node(nx,ny,cur.sum+map[nx][ny]));
					}
				}
			}
			
		}
	}
}
