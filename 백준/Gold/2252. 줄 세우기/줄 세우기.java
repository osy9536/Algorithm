
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] check = new int[N + 1];
		StringBuilder sb = new StringBuilder();
		ArrayList<ArrayList<Integer>> line = new ArrayList<>();
		for (int i = 0; i < N + 1; i++) {
			line.add(new ArrayList<>());
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			line.get(a).add(b);
			check[b]++;
		}

		bfs(check, sb, line);
		System.out.println(sb.toString().trim());
	}

	private static void bfs(int[] check, StringBuilder sb, ArrayList<ArrayList<Integer>> line) {
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i < check.length; i++) {
			if (check[i]==0) {
				q.add(i);
			}
		}
		while (!q.isEmpty()) {
			int now = q.poll();
			sb.append(now + " ");
			List<Integer> list = line.get(now);

			for (int i = 0; i < list.size(); i++) {
				int tmp = list.get(i);
				check[tmp]--;
				if(check[tmp]==0) {
					q.add(tmp);
				}
			}
		}
	}
}