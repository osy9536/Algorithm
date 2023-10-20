import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, adjMatrix[][], baconIdx, baconNum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		adjMatrix = new int[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adjMatrix[a][b] = adjMatrix[b][a] = 1;
		}
		baconIdx = -1;
		baconNum = Integer.MAX_VALUE;
		for(int i=1;i<=N;i++) {
			BFS(i);
		}
		System.out.println(baconIdx);
	}

	static void BFS(int idx) {
		Queue<Integer> q = new ArrayDeque<>();
		boolean visited[] = new boolean[N+1];
		int sum=0;
		int level=1;
		
		q.offer(idx);
		visited[idx]=true;
		while(!q.isEmpty()) {
			int size=q.size();
			for(int i=0;i<size;i++) {
				int cur = q.poll();
				for(int j=1;j<=N;j++) {
					if(adjMatrix[cur][j]==0 || visited[j])
						continue;
					q.offer(j);
					visited[j]=true;
					sum+=level;
				}
			}
			level++;
		}
		if(sum<baconNum) {
			baconIdx=idx;
			baconNum=sum;
		}
	}
}
