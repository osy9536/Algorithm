
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 연구소
// gold 4
public class Main {
    static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] map;
    static int N, M, answer;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        answer = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0);
        System.out.println(answer);
    }

    static void bfs() {
        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2) {
                    q.add(new Node(i, j));
                }
            }
        }

        int[][] copyMap = new int[N][M];
        for(int i = 0; i<N; i++){
            copyMap[i] = map[i].clone();
        }

        while (!q.isEmpty()) {
            Node cur = q.poll();
            for(int i = 0; i<4; i++){
                int nx = cur.x+dx[i];
                int ny = cur.y+dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if(copyMap[nx][ny]==0){
                        q.add(new Node(nx, ny));
                        copyMap[nx][ny]=2;
                    }
                }
            }
        }

        countNum(copyMap);
    }
    static void countNum(int[][] copyMap){
        int cnt = 0;
        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                if(copyMap[i][j]==0){
                    cnt++;
                }
            }
        }
        answer = Math.max(answer, cnt);
    }

    static void dfs(int cnt) {
        if (cnt == 3) {
            bfs();
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(cnt + 1);
                    map[i][j] = 0;
                }
            }
        }
    }
}
