import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class Main {

    static int n, l, r;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int days = 0;
        boolean moved;
        do {
            moved = false;
            visited = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        int totalPopulation = BFS(i, j);
                        if (totalPopulation > 1) {
                            moved = true;
                        }
                    }
                }
            }

            if (moved) {
                days++;
            }
        } while (moved);

        System.out.println(days);
    }

    static int BFS(int x, int y) {
        List<Point> union = new ArrayList<>();
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        visited[x][y] = true;
        union.add(new Point(x, y));

        int sum = map[x][y];

        while (!q.isEmpty()) {
            Point p = q.poll();
            int cx = p.x;
            int cy = p.y;

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny]) {
                    int populationDiff = Math.abs(map[cx][cy] - map[nx][ny]);
                    if (populationDiff >= l && populationDiff <= r) {
                        visited[nx][ny] = true;
                        q.add(new Point(nx, ny));
                        union.add(new Point(nx, ny));
                        sum += map[nx][ny];
                    }
                }
            }
        }

        if (union.size() > 1) {
            int newPopulation = sum / union.size();
            for (Point p : union) {
                map[p.x][p.y] = newPopulation;
            }
            return union.size();
        }

        return 0;
    }
}
