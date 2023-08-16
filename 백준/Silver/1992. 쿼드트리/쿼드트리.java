
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 쿼드트리
// silver 1
public class Main {
	static int[][] map;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i = 0; i<N; i++) {
			String s = br.readLine();
			for(int j = 0; j<N; j++) {
				map[i][j] = s.charAt(j)-48;
			}
		}
		divide(N,0,0);
		System.out.println(sb.toString());
	}
	static void divide(int n, int a,int b) {
		int zeroCnt = 0;
		int oneCnt = 0;
		if(checkNum(n,a,b)) {
			sb.append(map[a][b]);
		}else {
			sb.append("(");
			divide(n/2,a,b);
			divide(n/2,a,b+n/2);
			divide(n/2,a+n/2,b);
			divide(n/2,a+n/2,b+n/2);
			sb.append(")");
		}
	}
	static boolean checkNum(int n , int a, int b) {
		int num = map[a][b];
		for(int i = a; i< a+n; i++) {
			for(int j =b; j< b+n; j++) {
				if(map[i][j]!=num) return false;
			}
		}
		return true;
	}
}
