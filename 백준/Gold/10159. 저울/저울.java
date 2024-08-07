import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 987654321;
    static int N, M;
    static int[][] compare;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        compare = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            Arrays.fill(compare[i], INF);
            compare[i][i] = 0;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            compare[a][b] = 1; // a is lighter than b
        }

        // 플로이드-워셜 알고리즘
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (compare[i][j] > compare[i][k] + compare[k][j]) {
                        compare[i][j] = compare[i][k] + compare[k][j];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            int count = 0;
            for (int j = 1; j <= N; j++) {
                if (i != j && compare[i][j] == INF && compare[j][i] == INF) {
                    count++;
                }
            }
            sb.append(count).append("\n");
        }

        System.out.print(sb);
    }
}
