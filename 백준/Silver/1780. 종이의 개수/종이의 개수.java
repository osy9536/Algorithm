import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int paper[][], N;
	static int minus;
	static int zero;
	static int plus;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		paper = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		minus = 0;
		zero = 0;
		plus = 0;
		cut(0, N, 0, 0);
		StringBuilder sb = new StringBuilder();
		sb.append(minus).append("\n").append(zero).append("\n").append(plus);
		System.out.println(sb);
	}

	static void cut(int cnt, int n, int x, int y) {
		if (cnt == 0) {
			if (!check(0, 0, n))
				cut(cnt + 1, n / 3, 0, 0);
			return;
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				int curX = x + i * n;
				int curY = y + j * n;
				if (!check((curX), (curY), n))
					cut(cnt + 1, n / 3, curX, curY);
			}
		}
	}

	static boolean check(int x, int y, int n) {
		int cur = paper[x][y];
		boolean isPaper = true;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (paper[x + i][y + j] != cur) {
					isPaper = false;
					return false;
				}
			}
		}
		if (isPaper) {
			switch (cur) {
			case -1:
				minus++;
				break;
			case 0:
				zero++;
				break;
			case 1:
				plus++;
			}
			return true;
		}
		return false;
	}
}