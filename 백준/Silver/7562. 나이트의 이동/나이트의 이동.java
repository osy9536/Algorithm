
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 나이트의 이동
// silver 1
public class Main {
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
    static boolean[][] visited;
    static int answer, N;
    static int[] end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] start = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

            st = new StringTokenizer(br.readLine());
            end = new int[2];
            end[0] = Integer.parseInt(st.nextToken());
            end[1] = Integer.parseInt(st.nextToken());

            visited = new boolean[N][N];
            answer = Integer.MAX_VALUE;
            bfs(start[0], start[1]);
            System.out.println(answer);
        }
    }

    private static void bfs(int startX, int startY) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(startX, startY,0));

        while (!q.isEmpty()) {
            Point p = q.poll();
            if (p.x == end[0] && p.y == end[1]) {
                answer = Math.min(answer, p.cnt);
            }
            if (!visited[p.x][p.y]) {
                visited[p.x][p.y]=true;
                for(int i = 0; i<8; i++){
                    int nx = p.x + dx[i];
                    int ny = p.y + dy[i];
                    if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
                        q.add(new Point(nx, ny, p.cnt+1));
                    }
                }
            }
        }
    }

    private static class Point{
        int x;
        int y;
        int cnt;
        Point(int x, int y, int cnt){
            this.x=x;
            this.y=y;
            this.cnt = cnt;
        }
    }
}
