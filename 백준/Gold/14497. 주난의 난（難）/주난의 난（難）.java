import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int x, y, jumpCount;

        public Node(int x, int y, int jumpCount) {
            this.x = x;
            this.y = y;
            this.jumpCount = jumpCount;
        }
    }

    static int N, M;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        st = new StringTokenizer(br.readLine());
        int startY = Integer.parseInt(st.nextToken()) - 1;
        int startX = Integer.parseInt(st.nextToken()) - 1;
        int endY = Integer.parseInt(st.nextToken()) - 1;
        int endX = Integer.parseInt(st.nextToken()) - 1;

        for (int y = 0; y < N; y++) {
            String line = br.readLine();
            for (int x = 0; x < M; x++) {
                char ch = line.charAt(x);
                if (ch == '#') {
                    map[y][x] = -1;  // 범인의 위치는 장애물로 취급하지 않음.
                } else if (ch == '*') {
                    map[y][x] = -1;  // 주난이의 시작 위치는 장애물로 취급하지 않음.
                } else {
                    map[y][x] = ch - '0';
                }
            }
        }

        int result = bfs(startX, startY, endX, endY);
        System.out.println(result);
    }

    static int bfs(int startX, int startY, int endX, int endY) {
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(startX, startY, 0));
        visited[startY][startX] = true;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.x == endX && current.y == endY) {
                return current.jumpCount;
            }

            for (int i = 0; i < 4; i++) {
                int newX = current.x + dx[i];
                int newY = current.y + dy[i];

                if (isInBounds(newX, newY) && !visited[newY][newX]) {
                    visited[newY][newX] = true;
                    if (map[newY][newX] == 0) {
                        ((ArrayDeque<Node>) queue).offerFirst(new Node(newX, newY, current.jumpCount));
                    } else {
                        queue.offerLast(new Node(newX, newY, current.jumpCount + 1));
                    }
                }
            }
        }

        return -1;  // 도달할 수 없는 경우
    }

    static boolean isInBounds(int x, int y) {
        return x >= 0 && x < M && y >= 0 && y < N;
    }
}
