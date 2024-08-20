import java.io.*;

public class Main {

    static int[] dx = {0, 0, 1, -1}; 
    static int[] dy = {1, -1, 0, 0};
    static double[] percent;
    static boolean[][] visited;
    static double result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);

        percent = new double[4];
        for (int i = 0; i < 4; i++) {
            percent[i] = Integer.parseInt(input[i + 1]) * 0.01;
        }

        visited = new boolean[30][30];
        result = 0;

        dfs(15, 15, 0, n, 1);

        System.out.println(result);
    }

    public static void dfs(int x, int y, int depth, int n, double probability) {
        if (depth == n) {
            result += probability;
            return;
        }

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (!visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny, depth + 1, n, probability * percent[i]);
                visited[nx][ny] = false;
            }
        }

        visited[x][y] = false;
    }
}
