
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

// [모의 SW 역량테스트] 특이한 자석
public class Solution {
	static Deque<Integer>[] magnet;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			int K = Integer.parseInt(br.readLine());
			magnet = new Deque[4];

			for (int i = 0; i < 4; i++) {
				magnet[i] = new ArrayDeque<>();
			}

			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) {
					int a = Integer.parseInt(st.nextToken());
					magnet[i].addLast(a);
				}
			}

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int n = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				visited = new boolean[4];
				visited[n-1] = true;
				rotate(n - 1, dir);
			}
			int answer = 0;

			for (int i = 0; i < 4; i++) {
				if (magnet[i].peekFirst() == 1)
					answer += Math.pow(2, i);
			}
			System.out.println("#" + tc + " " + answer);
		}
	}

	static void rotate(int start, int dir) {
		int nowL = 0;
		int nowR = 0;
		int nextL = 0;
		int nextR = 0;
		for (int i = 0; i < 8; i++) {
			int cur = magnet[start].pollFirst();
			magnet[start].addLast(cur);

			if (i == 2)
				nowR = cur;
			if (i == 6)
				nowL = cur;
		}
		if (dir != 1) {
			int cur = magnet[start].pollFirst();
			magnet[start].addLast(cur);
		} else {
			int cur = magnet[start].pollLast();
			magnet[start].addFirst(cur);
		}

		if (start == 0) {
			if (visited[start + 1])
				return;
			for (int i = 0; i < 8; i++) {
				int next = magnet[start + 1].pollFirst();
				magnet[start + 1].addLast(next);

				if (i == 6)
					nextL = next;
			}

			if (nowR != nextL) {
				visited[start + 1] = true;
				rotate(start + 1, dir == 1 ? -1 : 1);
			}
		} else if (start == 3) {
			if (visited[start - 1])
				return;
			for (int i = 0; i < 8; i++) {
				int pre = magnet[start - 1].pollFirst();
				magnet[start - 1].addLast(pre);

				if (i == 2)
					nextR = pre;
			}

			if (nowL != nextR) {
				visited[start - 1] = true;
				rotate(start - 1, dir == 1 ? -1 : 1);
			}
		} else {
			for (int i = 0; i < 8; i++) {
				int pre = magnet[start - 1].pollFirst();
				magnet[start - 1].addLast(pre);

				if (i == 2)
					nextR = pre;
			}
			for (int i = 0; i < 8; i++) {
				int next = magnet[start + 1].pollFirst();
				magnet[start + 1].addLast(next);

				if (i == 6)
					nextL = next;
			}

			if (!visited[start - 1] && nowL != nextR) {
				visited[start - 1] = true;
				rotate(start - 1, dir == 1 ? -1 : 1);
			}
			if (!visited[start + 1] && nowR != nextL) {
				visited[start + 1] = true;
				rotate(start + 1, dir == 1 ? -1 : 1);
			}
		}
	}
}
