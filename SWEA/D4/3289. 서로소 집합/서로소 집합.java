
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 서로소 집합
// D4
public class Solution {
	static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			int[] parent = new int[n+1];
			System.out.print("#"+tc+" ");
			int m = Integer.parseInt(st.nextToken());
			make(parent);
			for(int i =0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int oper = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if(oper == 0 ) {
					union(parent,a,b);
				}else {
					if(find(parent, a)==find(parent, b)) {
						System.out.print(1);
					}else System.out.print(0);
				}
			}
			System.out.println();
		}
		
		
	}
	private static void make(int[] parent) {
		for(int i=0; i<=n; i++) {
			parent[i] = i;
		}
	}
	private static int find(int[] parent, int x) {
		if(parent[x]==x)return x;	
		parent[x]=find(parent, parent[x]);
		return parent[x];
	}
	private static void union(int[] parent, int a, int b) {
		int pa = find(parent, a);
		int pb = find(parent, b);
		if(a>b) parent[pa] = pb;
		else parent[pb] = pa;
	}
}
