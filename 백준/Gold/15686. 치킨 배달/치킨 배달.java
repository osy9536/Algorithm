
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

// 치킨 배달
// gold 5
public class Main {

    static class Node {
        int x, y, dis;

        Node(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }

    static int[][] map;
    static int N, M, num, answer;
    static int[] select;
    static boolean[] visited;
    static List<Point> chick;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        select = new int[M];
        chick = new ArrayList<>();
        num = 0;
        answer = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int a = Integer.parseInt(st.nextToken());
                map[i][j] = a;
                if (a == 2) {
                    num++;
                    chick.add(new Point(i, j));
                }
            }
        }
        visited = new boolean[num];
        combi();
        System.out.println(answer);
    }

//    static void combi(int depth) {
//        if (depth == M) {
//            Distance();
//            return;
//        }
//
//        for (int i = 0; i < num; i++) {
//            if (visited[i]) continue;
//            visited[i] = true;
//            select[depth] = i;
//            combi(depth + 1);
//            visited[i] = false;
//        }
//    }
    static void combi() {
        for (int i = 0; i < (1 << num); i++) {
            if (Integer.bitCount(i) == M) {
                int idx = 0;
                for (int j = 0; j < num; j++) {
                    if ((i & (1 << j)) != 0) {
                        select[idx++] = j;
                    }
                }
                Distance();
            }
        }
    }
    private static void Distance() {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    int oneDis = Integer.MAX_VALUE;
                    for (int k = 0; k < M; k++) {
                        Point cur = chick.get(select[k]);
                        int dis = Math.abs(cur.x - i) + Math.abs(cur.y - j);
                        oneDis = Math.min(oneDis, dis);
                    }
                    sum += oneDis;
                    if(sum>answer) return;
                }
            }
        }
        answer = Math.min(answer, sum);
    }
}
