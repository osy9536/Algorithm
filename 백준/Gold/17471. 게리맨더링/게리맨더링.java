
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 게리맨더링
// gold 4
public class Main {
	static class Node {
		int V, num;

		Node(int V, int num) {
			this.V = V;
			this.num = num;
		}
	}

	static Node[] node;
	static List<Integer>[] list;
	static int N;
	static boolean[] selected, visited;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		list = new ArrayList[N + 1];
		selected = new boolean[N + 1];
		for (int i = 0; i < N + 1; i++) {
			list[i] = new ArrayList<>();
		}
		node = new Node[N + 1];
		for (int i = 1; i <= N; i++) {
			node[i] = new Node(i, Integer.parseInt(st.nextToken()));
		}
		// 인접 리스트 생성
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			while (st.hasMoreTokens()) {
				list[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		solve(1);
		System.out.println(answer==Integer.MAX_VALUE?-1:answer);
	}

	static void solve(int depth) {
		if (depth == N+1) {
			List<Integer> a = new ArrayList<>();
			List<Integer> b = new ArrayList<>();
			int aSum = 0;
			int bSum = 0;
			for (int i = 1; i <= N; i++) {
				if (selected[i])
					a.add(i);
				else
					b.add(i);
			}
			if (a.size() == 0 || b.size() == 0)
				return;
			
			if(check(a)&&check(b)) {
				for(int i = 0; i<a.size(); i++) {
					aSum+=node[a.get(i)].num;
				}
				for(int i = 0; i<b.size(); i++) {
					bSum+=node[b.get(i)].num;
				}
				answer = Math.min(answer, Math.abs(aSum-bSum));
			}
			return;
		}
		selected[depth] = true;
		solve(depth + 1);
		selected[depth] = false;
		solve(depth + 1);
	}

	static boolean check(List<Integer> l) {
		Queue<Integer> q = new LinkedList<>();
		q.add(l.get(0));
		visited = new boolean[N+1];
		visited[l.get(0)] = true;
		int cnt = 1;
		while (!q.isEmpty()) {
			int now = q.poll();
			for (int i = 0; i < list[now].size(); i++) {
				if (l.contains(list[now].get(i)) && !visited[list[now].get(i)]) {
					visited[list[now].get(i)] = true;
					q.add(list[now].get(i));
					cnt++;
				}
			}
		}
		if (cnt == l.size())
			return true;
		else
			return false;
	}
}
