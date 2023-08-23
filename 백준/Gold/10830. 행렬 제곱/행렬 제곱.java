
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] matrix;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		matrix = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken())%1000;
			}
		}
		int[][] result = matrixMul(matrix, B);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				sb.append(result[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.print(sb.toString().trim());
	}
	// B = 20 -> 1 2 4 8 16 
	static int[][] matrixMul(int[][] matr, long b) {
		if(b == 1L) {
			return matr;
		}
		int[][] p = matrixMul(matr, b/2);
		p = mul(p,p);
		if(b%2==1L) {
			p = mul(p,matrix);
		}
		return p;
	}

	
	static int[][] mul(int[][] p1, int[][] p2) {
		int[][] now = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for(int k = 0; k<N; k++) {
					now[i][j] +=p1[i][k] * p2[k][j];
					now[i][j]%=1000;
				}
			}
		}
		return now;
	}
}
