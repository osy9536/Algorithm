
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] arr, used;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        used = new int[n + 1];
        dfs(0, 1);
        System.out.println(sb);
    }

    private static void dfs(int depth, int start) {

        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i <= n; i++) {
            if (used[i] == 1) {
                continue;
            }
            used[i] = 1;
            arr[depth] = i;
            dfs(depth + 1, i);
            used[i] = 0;
        }
    }
}