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
		int F = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int U = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int ans = BFS(F, S, G, U, D);
		if(ans==-1)
			System.out.println("use the stairs");
		else
			System.out.println(ans);
	}

	static int BFS(int F, int S, int G, int U, int D) {
		Queue<Integer> q = new ArrayDeque<>();
		boolean visited[] = new boolean[F+1];
		q.offer(S);
		visited[S]=true;
		int cnt=0;
		while(!q.isEmpty()) {
			int size=q.size();
			for(int i=0;i<size;i++) {
				int curPos = q.poll();
				if(curPos==G)
					return cnt;
				int upPos = curPos+U;
				if(upPos<=F && !visited[upPos]) {
					q.offer(upPos);
					visited[upPos]=true;
				}
				int downPos = curPos-D;
				if(downPos>0 && !visited[downPos]) {
					q.offer(downPos);
					visited[downPos]=true;
				}
			}
			cnt++;
		}
		return -1;
	}
}
