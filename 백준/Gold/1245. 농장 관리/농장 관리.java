import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] farm;
    static boolean[][] visited;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        farm = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                farm[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int peakCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    if (isPeak(i, j)) {
                        peakCount++;
                    }
                }
            }
        }

        System.out.println(peakCount);
    }

    static boolean isPeak(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        boolean isPeak = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int curX = current[0];
            int curY = current[1];

            for (int d = 0; d < 8; d++) {
                int nx = curX + dx[d];
                int ny = curY + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                if (farm[nx][ny] > farm[curX][curY]) {
                    isPeak = false;
                }

                if (!visited[nx][ny] && farm[nx][ny] == farm[curX][curY]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        return isPeak;
    }
}
