
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int start;
	static boolean check;
	static int[][] arr = new int[100][100];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		for (int k = 1; k <= 10; k++) {
			check=false;
			start=0;
			br.readLine();
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			isX(0, 0, 0);
			System.out.println("#"+k+" "+start);
		}	
	}

	// left = 1, right =2
	static void isX(int i, int j, int dir) {
		if (check)
			return;
		if (j<100&&j>=0&&i == 0 && arr[0][j] == 0) {
			start = j + 1;
			isX(0, start, 0);
		}
		if (i == 99) {
			if (arr[i][j] != 2) {
				start++;
				isX(0, start, 0);
			} else {
				check = true;
				return;
			}
		}
		if (isRight(i, j) && dir != 1) {
			isX(i, j + 1, 2);
		}
		if (isLeft(i, j) && dir != 2) {
			isX(i, j - 1, 1);
		}
		if (check)
			return;
		isX(i + 1, j, 0);
		if (check)
			return;
	}

	static boolean isRight(int i, int j) {
		if (j < 99 && arr[i][j + 1] == 1)
			return true;
		else
			return false;
	}

	static boolean isLeft(int i, int j) {
		if (j > 0 && arr[i][j - 1] == 1)
			return true;
		else
			return false;
	}
}
