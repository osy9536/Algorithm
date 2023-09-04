
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    static class Node {
        int x, y, depth, canBreak;

        Node(int x, int y, int depth, int canBreak) {
            this.x = x;
            this.y = y;
            this.depth = depth;
            this.canBreak = canBreak;
        }
    }

    static int N, M, answer;
    static int[][] map;
    static boolean[][][] visited; // 벽을 부순 여부를 고려한 방문 여부 배열

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = -1;
        map = new int[N][M];
        visited = new boolean[N][M][2]; // 벽을 부수고 방문한 경우와 부수지 않고 방문한 경우를 고려

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        bfs();

        System.out.println(answer);
    }

    static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 1, 0)); // 시작점을 큐에 추가
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.x == N - 1 && cur.y == M - 1) {
                answer = cur.depth;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    // 벽이 없는 경우
                    if (map[nx][ny] == 0 && !visited[nx][ny][cur.canBreak]) {
                        visited[nx][ny][cur.canBreak] = true;
                        q.add(new Node(nx, ny, cur.depth + 1, cur.canBreak));
                    }
                    // 벽이 있는 경우
                    else if (map[nx][ny] == 1 && cur.canBreak == 0 && !visited[nx][ny][1]) {
                        visited[nx][ny][1] = true;
                        q.add(new Node(nx, ny, cur.depth + 1, 1));
                    }
                }
            }
        }
    }
}
