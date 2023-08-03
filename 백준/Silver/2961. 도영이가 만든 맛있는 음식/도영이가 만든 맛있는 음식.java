
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 도영이가 만든 맛있는 음식
// silver 2
public class Main {
	static int min = Integer.MAX_VALUE;
	static int[] sArr, bArr;
	static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		sArr = new int[n];
		bArr = new int[n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sArr[i] = a;
			bArr[i] = b;
		}
		sol(0, 0, 1, 0);
		System.out.println(min);
	}

	public static void sol(int input_cnt, int cnt, int sMul, int bSum) {
		if (cnt == n) {
			if (input_cnt != 0) {
				min = Math.min(min, Math.abs(sMul - bSum));
			}
			return;
		}
		sol(input_cnt, cnt + 1, sMul, bSum); // cnt번째 있는 재료 넣지 않은 것
		sol(input_cnt + 1, cnt + 1, sMul * sArr[cnt], bSum + bArr[cnt]);

	}
}
