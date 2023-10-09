import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 달이 차오른다, 가자.
// gold 1
public class Main {

    static class Node {
        int x, y, alphabet, depth;

        Node(int x, int y, int alphabet, int depth) {
            this.x = x;
            this.y = y;
            this.alphabet = alphabet;
            this.depth = depth;
        }
    }

    static char[][] map;
    static boolean[][][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int rowN, colN;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        rowN = Integer.parseInt(st.nextToken());
        colN = Integer.parseInt(st.nextToken());
        map = new char[rowN][colN];
        visited = new boolean[rowN][colN][1 << 7];
        int startX = 0;
        int startY = 0;
        for (int i = 0; i < rowN; i++) {
            char[] c = br.readLine().toCharArray();
            for (int j = 0; j < colN; j++) {
                if (c[j] == '0') {
                    startX = i;
                    startY = j;
                }
                map[i][j] = c[j];
            }
        }

        System.out.print(BFS(startX, startY));
    }

    private static int BFS(int startX, int startY) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(startX, startY, 0, 0));
        visited[startX][startY][0] = true;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (map[cur.x][cur.y] == '1') {
                return cur.depth;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                int alpha = cur.alphabet;

                if (nx >= 0 && ny >= 0 && nx < rowN && ny < colN && map[nx][ny] != '#') {
                    if (map[nx][ny] >= 'a' && map[nx][ny] <= 'f') {
                        int key = 1 << (map[nx][ny] - 'a');
                        alpha |= key;
                    }
                    if (map[nx][ny] >= 'A' && map[nx][ny] <= 'F') {
                        int door = 1 << (map[nx][ny] - 'A');
                        if ((alpha & door) == 0) {
                            continue;
                        }
                    }
                    if (visited[nx][ny][alpha]) continue;
                    visited[nx][ny][alpha] = true;
                    q.add(new Node(nx, ny, alpha, cur.depth + 1));
                }
            }
        }
        return -1;
    }
}