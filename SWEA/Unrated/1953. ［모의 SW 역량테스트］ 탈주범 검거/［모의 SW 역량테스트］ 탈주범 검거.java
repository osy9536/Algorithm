
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, M, R, C, L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            visited = new boolean[N][M];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int result = bfs();
            System.out.println("#" + tc + " " + result);
        }
    }

    private static int bfs() {
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(R, C));
        visited[R][C] = true;
        int time = 0;
        int count = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                Point current = queue.poll();
                count++;

                for (int i = 0; i < 4; i++) {
                    int nx = current.x + dx[i];
                    int ny = current.y + dy[i];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny] || map[nx][ny] == 0) {
                        continue;
                    }

                    if (canMove(map[current.x][current.y], i, map[nx][ny])) {
                        queue.offer(new Point(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }

            time++;
            if (time == L) {
                break;
            }
        }

        return count;
    }

    private static boolean canMove(int from, int direction, int to) {
        if (direction == 0) {
            return (from == 1 || from == 2 || from == 4 || from == 7) && (to == 1 || to == 2 || to == 5 || to == 6);
        } else if (direction == 1) {
            return (from == 1 || from == 2 || from == 5 || from == 6) && (to == 1 || to == 2 || to == 4 || to == 7);
        } else if (direction == 2) {
            return (from == 1 || from == 3 || from == 6 || from == 7) && (to == 1 || to == 3 || to == 4 || to == 5);
        } else {
            return (from == 1 || from == 3 || from == 4 || from == 5) && (to == 1 || to == 3 || to == 6 || to == 7);
        }
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
