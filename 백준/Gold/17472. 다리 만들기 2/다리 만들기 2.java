import java.awt.*;
import java.io.*;
import java.util.*;

// 다리 만들기 2
// gold 1
public class Main {

    static int[][] map;
    static int N, M, answer;
    static boolean[][] giveNumVisited;
    static boolean[] adjVisited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] adjMatrix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        giveNumVisited = new boolean[N][M];
        answer = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 섬에 번호 부여하기
        int islandNum = islandNum();
        adjMatrix = new int[islandNum][islandNum];

        for (int i = 0; i < adjMatrix.length; i++) {
            Arrays.fill(adjMatrix[i], Integer.MAX_VALUE);
        }

        // 섬과 섬 사이에 가장 가까운 인접 행렬 만들기
        adjMatrix();

        adjVisited = new boolean[islandNum];
        int cnt = connBridge(islandNum);
        if (cnt != islandNum-2) {
            System.out.println(-1);
        }else System.out.println(answer);
    }

    private static int connBridge(int bridgeNum) {
        Queue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));

        for (int i = 2; i < bridgeNum; i++) {
            if (adjMatrix[1][i] != Integer.MAX_VALUE) {
                q.add(new int[]{1, i, adjMatrix[1][i]});
            }
        }
        adjVisited[1] = true;
        int cnt = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int start = cur[0];
            int end = cur[1];
            int length = cur[2];
            if(!adjVisited[end]){
                answer += length;
                cnt++;
            }
            adjVisited[end] = true;
            for (int i = 1; i < adjMatrix[end].length; i++) {
                if(i==end) continue;
                int next = adjMatrix[end][i];
                if (next != Integer.MAX_VALUE) {
                    if (!adjVisited[i]) {

                        q.add(new int[]{end, i, next});
                    }
                }
            }
        }
        return cnt;
    }

    private static void adjMatrix() {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0) {
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                            if (map[nx][ny] == 0) {
                                bridgeLength(map[i][j], i, j, 0, k);
                            }
                        }
                    }
                }
            }
        }
    }

    // 두 다리 사이 간에 길이 구하기
    private static void bridgeLength(int startNum, int x, int y, int depth, int dir) {
        int nx = x + dx[dir];
        int ny = y + dy[dir];

        if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
            if (map[nx][ny] == 0) {
                bridgeLength(startNum, nx, ny, depth + 1, dir);
            } else {
                if (depth > 1) {
                    if (adjMatrix[startNum][map[nx][ny]] > depth) {
                        adjMatrix[startNum][map[nx][ny]] = depth;
                    }
                    if (adjMatrix[map[nx][ny]][startNum] > depth) {
                        adjMatrix[map[nx][ny]][startNum] = depth;
                    }
                    return;
                }
            }
        }
    }

    static int islandNum() {
        int cnt = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && !giveNumVisited[i][j]) {
                    giveNumVisited[i][j] = true;
                    giveNum(i, j, cnt);
                    cnt++;
                }
            }

        }
        return cnt;
    }

    static void giveNum(int x, int y, int num) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));

        while (!q.isEmpty()) {
            Point cur = q.poll();
            map[cur.x][cur.y] = num;
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M && !giveNumVisited[nx][ny]) {
                    if (map[nx][ny] == 0) continue;
                    giveNumVisited[nx][ny] = true;

                    q.add(new Point(nx, ny));
                }
            }
        }
    }
}
