import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static int[][] map, operations;
    static boolean[] used;
    static ArrayList<Integer> order = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        operations = new int[K][3];
        used = new boolean[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            operations[i][0] = Integer.parseInt(st.nextToken());
            operations[i][1] = Integer.parseInt(st.nextToken());
            operations[i][2] = Integer.parseInt(st.nextToken());
        }

        // 순열을 통해 모든 회전 연산 순서를 구함
        permutation(0);

        System.out.println(answer);
    }

    // 순열 생성
    static void permutation(int depth) {
        if (depth == K) {
            int[][] copiedMap = new int[N][M];
            for (int i = 0; i < N; i++) {
                System.arraycopy(map[i], 0, copiedMap[i], 0, M);
            }

            // 순서대로 회전 연산을 수행하며 결과를 갱신
            for (int i : order) {
                rotate(operations[i][0] - 1, operations[i][1] - 1, operations[i][2], copiedMap);
            }

            // 최솟값 갱신
            for (int i = 0; i < N; i++) {
                int rowSum = 0;
                for (int j = 0; j < M; j++) {
                    rowSum += copiedMap[i][j];
                }
                answer = Math.min(answer, rowSum);
            }

            return;
        }

        for (int i = 0; i < K; i++) {
            if (!used[i]) {
                used[i] = true;
                order.add(i);
                permutation(depth + 1);
                order.remove(order.size() - 1);
                used[i] = false;
            }
        }
    }

    // 회전 연산 수행
    static void rotate(int r, int c, int s, int[][] arr) {
        for (int size = 1; size <= s; size++) {
            int temp = arr[r - size][c - size];

            // 왼쪽 변 이동
            for (int i = r - size; i < r + size; i++) {
                arr[i][c - size] = arr[i + 1][c - size];
            }
            // 아래쪽 변 이동
            for (int i = c - size; i < c + size; i++) {
                arr[r + size][i] = arr[r + size][i + 1];
            }
            // 오른쪽 변 이동
            for (int i = r + size; i > r - size; i--) {
                arr[i][c + size] = arr[i - 1][c + size];
            }
            // 위쪽 변 이동
            for (int i = c + size; i > c - size + 1; i--) {
                arr[r - size][i] = arr[r - size][i - 1];
            }

            arr[r - size][c - size + 1] = temp;
        }
    }
}
