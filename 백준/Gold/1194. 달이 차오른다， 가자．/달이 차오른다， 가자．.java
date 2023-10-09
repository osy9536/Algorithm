
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 달이 차오른다, 가자.
// gold 1
public class Main {

    static class Node {
        int alphabet, x, y, depth;
        boolean[] hasKey;

        Node(int x, int y, int alphabet, int depth, boolean[] hasKey) {
            this.x = x;
            this.y = y;
            this.alphabet = alphabet;
            this.depth = depth;
            this.hasKey = hasKey;
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
        visited = new boolean[rowN][colN][92];
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


        System.out.print(BFS(startX, startY, 0, 0));
    }

    private static int BFS(int startX, int startY, int alphabet, int depth) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(startX, startY, alphabet, depth, new boolean[7]));
        visited[startX][startY][alphabet] = true;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (map[cur.x][cur.y] == '1') {
                return cur.depth;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                int alpha = cur.alphabet;
                boolean[] keys = cur.hasKey.clone();
                if (nx >= 0 && ny >= 0 && nx < rowN && ny < colN && map[nx][ny] != '#') {
                    if (map[nx][ny] >= 'a' && map[nx][ny] <= 'f') {
                        if(!keys[map[nx][ny]-'a']) alpha += (map[nx][ny] - 'a'+1)*(map[nx][ny] - 'a'+1);
                        keys[map[nx][ny] - 'a'] = true;
                    }
                    if (map[nx][ny] >= 'A' && map[nx][ny] <= 'F') {
                        if (!cur.hasKey[map[nx][ny] - 'A']) {
                            continue;
                        }
                    }
                    if (visited[nx][ny][alpha]) continue;
                    visited[nx][ny][alpha] = true;
                    q.add(new Node(nx, ny, alpha, cur.depth + 1,keys));
                }
            }
        }
        return -1;
    }
}
