
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// TITLE DFS 연결 요소의 개수 구하기
public class Main {
    static List<Integer>[] a;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        a = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i < n + 1; i++) {
            a[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            a[s].add(e);
            a[e].add(s);
        }
        int cnt = 0;
        for (int i = 1; i < n + 1; i++) {
            if (!visited[i]) {
                cnt++;
                dfs(i);
            }
        }
        System.out.println(cnt);
    }

    private static void dfs(int v) {
        if (visited[v]) {
            return;
        }
        visited[v] = true;
        for (int i : a[v]) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }
}
