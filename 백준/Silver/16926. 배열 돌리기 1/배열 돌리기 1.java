
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 배열 돌리기 1
// silver 1
public class Main {
    static int N, M, R;
    static int min;
    static int[][] map;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        min = Math.min(N, M); 

        for (int i = 1; i <= R; i++) { 
            rotate();
        }

        print();
    }

    static void rotate() {

        for (int t = 0; t < min / 2; t++) { 
            int x = t;
            int y = t;

            int temp = map[x][y]; 

            int idx = 0; // 우, 하, 좌, 상 방향으로 이동하며 반시계 방향으로 값 넣을 인덱스
            while (idx < 4) { // 왼쪽으로 넣는, 위로 넣는, 오른쪽으로 넣는, 아래로 넣는 연산을 차례로 수행
                int nx = x + dx[idx];
                int ny = y + dy[idx];

                if (nx < N - t && ny < M - t && nx >= t && ny >= t) {
                    map[x][y] = map[nx][ny];
                    x = nx;
                    y = ny;
                }
                else {
                    idx++;
                }

            }

            map[t + 1][t] = temp; 
        }

    }

    static void print() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
