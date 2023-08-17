
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static Point[] clients;
    static int N, min;
    static Point home, office;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            clients = new Point[N];
            home = new Point(st.nextToken(), st.nextToken());
            office = new Point(st.nextToken(), st.nextToken());

            for (int i = 0; i < N; i++) {
                clients[i] = new Point(st.nextToken(), st.nextToken());
            }
            min = Integer.MAX_VALUE;
            visited = new boolean[N];
            dfs(0, home.x, home.y, 0);

            System.out.println("#" + tc + " " + min);
        }
    }

    private static void dfs(int depth, int x, int y, int distance) {
        if(distance>min)return;

        if (depth == N) {
            distance += getDistance(x, y, office.x, office.y);
            min = Math.min(min, distance);
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;

                dfs(depth + 1, clients[i].x, clients[i].y, distance + getDistance(x, y, clients[i].x, clients[i].y));
                visited[i] = false;
            }
        }
    }


    static class Point {
        int x;
        int y;

        Point(String x, String y) {
            this.x = Integer.parseInt(x);
            this.y = Integer.parseInt(y);
        }
    }

    private static int getDistance(int x, int y, int x2, int y2) {
        return Math.abs(x - x2) + Math.abs(y - y2);
    }
}
