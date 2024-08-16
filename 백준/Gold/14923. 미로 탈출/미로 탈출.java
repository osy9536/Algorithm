import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static class Node {
        int x, y, cnt, dis;

        public Node(int x, int y, int cnt, int dis) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.dis = dis;
        }

    }
    
    static int N, M, Hx, Hy, Ex, Ey, ans = Integer.MAX_VALUE;
    static int map[][];
    static boolean[][][] visited;
    static PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.dis));
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[2][N][M];

        st = new StringTokenizer(br.readLine());
        Hx = Integer.parseInt(st.nextToken())-1;
        Hy = Integer.parseInt(st.nextToken())-1;

        queue.offer(new Node( Hx, Hy, 0, 0 ));

        st = new StringTokenizer(br.readLine());

        Ex = Integer.parseInt(st.nextToken());
        Ey = Integer.parseInt(st.nextToken());


        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        bfs();
        System.out.println(ans==Integer.MAX_VALUE? -1 : ans);

    }

    public static void bfs() {
        visited[0][Hx][Hy] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (cur.x == Ex-1 && cur.y == Ey-1) {
                ans = cur.dis;
                return;
            }

            for (int i = 0; i < 4; i++) {
                
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (range(nx, ny)) {
                    if (map[nx][ny] == 0 && !visited[cur.cnt][nx][ny]) {
                        visited[cur.cnt][nx][ny] = true;
                        queue.offer(new Node( nx, ny, cur.cnt, cur.dis+1 ));

                    } else if (map[nx][ny] == 1 && cur.cnt==0) {
                        visited[1][nx][ny] = true;
                        queue.offer(new Node( nx, ny, 1, cur.dis+1));
                    }
                }
            }

        }
    }

    public static boolean range(int x, int y) {
        return x >= 0 && y >= 0 && x <N && y <M;
    }
}