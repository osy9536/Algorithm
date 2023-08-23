
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 최소 스패닝 트리
// D4
public class Solution {
	static class Node implements Comparable<Node> {
		int a, b, c;

		Node(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}

		@Override
		public int compareTo(Node o) {
			return this.c - o.c;
		}
	}
	
	static Node[] node;
	static boolean[] visited;
	static int V;
	static long cnt;
	static int[] parent;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			node = new Node[E];
			visited = new boolean[V+1];
			make();
			cnt= 0;
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				node[i] = new Node(a,b,c);
			}
			
			Arrays.sort(node);
			kruskal();
			System.out.println("#"+tc+" "+cnt);
		}
	}
	// 0 1 2 3 4 5 6
	// 0 1 2 5 4 5 6
	// 0 1 1 5 4 5 6
	// 0 1 1 5 4 5 1
	// 0 0 1 5 4 5 1
	// 
	static void kruskal() {
		for(Node n : node) {
			if(find(n.a)!=find(n.b)) {
				union(n.a,n.b);
				cnt+=n.c;
			}
		}
	}
	static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot==bRoot) return;
		parent[bRoot] = aRoot;
	}
	static int find(int a) {
		if(parent[a] == a) return a;
		return parent[a] = find(parent[a]);
	}
	static void make() {
		parent = new int[V+1];
		for(int i = 1; i<V+1; i++) {
			parent[i] = i;
		}
	}
}
