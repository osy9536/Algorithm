
import java.io.*;
import java.util.StringTokenizer;

// 배열 돌리기 3
// gold 5
public class Main {

    static int[][] arr, copyArr;
    static int[] orders;
    static int N, M, R;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        copyArr = new int[N][M];
        orders = new int[R];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int a = Integer.parseInt(st.nextToken());
                arr[i][j] = a;
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < R; i++) {
            int a = Integer.parseInt(st.nextToken());
            orders[i] = a;
        }

        boolean next = false;
        for (int i = 0; i < R; i++) {
            int order = orders[i];
            if (order == 1) {
                if (next) {
                    copyArr = one(copyArr);
                } else arr = one(arr);
            }
            if (order == 2) {
                if (next) {
                    copyArr = two(copyArr);
                } else arr = two(arr);
            }
            if (order == 3) {
                if (next) {
                    arr = three(copyArr);
                } else {
                    copyArr = three(arr);
                }

                next = !next;
            }
            if (order == 4) {
                if (next) {
                    arr = four(copyArr);
                } else {
                    copyArr = four(arr);
                }

                next = !next;
            }
            if (order == 5) {
                if (next) {
                    copyArr = five(copyArr);
                } else arr = five(arr);
            }
            if (order == 6) {
                if (next) {
                    copyArr = six(copyArr);
                } else arr = six(arr);
            }
        }
        System.out.println(print(next));
    }

    private static String print(boolean next) {
        StringBuilder sb = new StringBuilder();
        if (!next) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    sb.append(arr[i][j]);
                    if (j != arr[i].length - 1) sb.append(" ");
                }
                sb.append("\n");
            }
        } else {
            for (int i = 0; i < copyArr.length; i++) {
                for (int j = 0; j < copyArr[i].length; j++) {
                    sb.append(copyArr[i][j]);
                    if (j != copyArr[i].length - 1) sb.append(" ");
                }
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    static int[][] one(int[][] now) {
        int[][] next = new int[now.length][now[0].length];
        for (int i = 0; i < now.length; i++) {
            for (int j = 0; j < now[i].length; j++) {
                next[now.length - i - 1][j] = now[i][j];
            }
        }
        return next;
    }

    static int[][] two(int[][] now) {
        int[][] next = new int[now.length][now[0].length];
        for (int i = 0; i < now.length; i++) {
            for (int j = 0; j < now[i].length; j++) {
                next[i][now[i].length - j - 1] = now[i][j];
            }
        }
        return next;
    }

    static int[][] three(int[][] now) {
        int[][] next = new int[now[0].length][now.length];
        for (int i = 0; i < now.length; i++) {
            for (int j = 0; j < now[i].length; j++) {
                next[j][now.length - i - 1] = now[i][j];
            }
        }
        return next;
    }

    static int[][] four(int[][] now) {
        int[][] next = new int[now[0].length][now.length];
        for (int i = 0; i < now.length; i++) {
            for (int j = 0; j < now[i].length; j++) {
                next[now[i].length - j - 1][i] = now[i][j];
            }
        }
        return next;
    }

    // N,M = 6, 8
    // 0,0 = 0, 4
    // 0,3 = 0, 7
    // 0,4 =
    static int[][] five(int[][] now) {
        int[][] next = new int[now.length][now[0].length];
        for (int i = 0; i < now.length / 2; i++) {
            for (int j = 0; j < now[i].length / 2; j++) {
                next[i][j + now[i].length / 2] = now[i][j];
            }
        }
        for (int i = 0; i < now.length / 2; i++) {
            for (int j = now[i].length / 2; j < now[i].length; j++) {
                next[i + now.length / 2][j] = now[i][j];
            }
        }
        for (int i = now.length / 2; i < now.length; i++) {
            for (int j = now[i].length / 2; j < now[i].length; j++) {
                next[i][j - now[i].length / 2] = now[i][j];
            }
        }
        for (int i = now.length / 2; i < now.length; i++) {
            for (int j = 0; j < now[i].length / 2; j++) {
                next[i - now.length / 2][j] = now[i][j];
            }
        }
        return next;
    }

    static int[][] six(int[][] now) {
        int[][] next = new int[now.length][now[0].length];
        for (int i = 0; i < now.length / 2; i++) {
            for (int j = 0; j < now[i].length / 2; j++) {
                next[i + now.length / 2][j] = now[i][j];
            }
        }
        for (int i = now.length / 2; i < now.length; i++) {
            for (int j = 0; j < now[i].length / 2; j++) {
                next[i][j + now[i].length / 2] = now[i][j];
            }
        }
        for (int i = now.length / 2; i < now.length; i++) {
            for (int j = now[i].length / 2; j < now[i].length; j++) {
                next[i - now.length / 2][j] = now[i][j];
            }
        }
        for (int i = 0; i < now.length / 2; i++) {
            for (int j = now[i].length / 2; j < now[i].length; j++) {
                next[i][j - now[i].length / 2] = now[i][j];
            }
        }
        return next;
    }
}
