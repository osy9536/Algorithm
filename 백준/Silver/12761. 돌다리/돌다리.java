import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		System.out.println(BFS(A,B,N,M,new boolean[100001]));
		
	}
	static int BFS(int A, int B, int N, int M, boolean[] visited) {
		int move[] = {1, -1, A, -A, B, -B};
		int jump[] = {A, B};
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(N);
		int cnt=0;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0;i<size;i++) {
				int pos = q.poll();
				if(pos==M)
					return cnt;
				for(int j=0;j<6;j++) {
					int nextPos = pos+move[j];
					if(nextPos<0||nextPos>100000||visited[nextPos]) continue;
					visited[nextPos]=true;
					q.offer(nextPos);
				}
				for(int j=0;j<2;j++) {
					int nextPos = pos*jump[j];
					if(nextPos<0||nextPos>100000||visited[nextPos]) continue;
					visited[nextPos]=true;
					q.offer(nextPos);
				}
			}
			cnt++;
		}
		return 0;
	}
}
