import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] num;
    static boolean[] visited;
    static boolean[] finished;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tc; i++) {
            int n = Integer.parseInt(br.readLine());
            num = new int[n];
            visited = new boolean[n];
            finished = new boolean[n];
            answer = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int a = Integer.parseInt(st.nextToken()) - 1;
                num[j] = a;
            }

            for (int j = 0; j < n; j++) {
                if (!visited[j]) {
                    dfs(j);
                }
            }
            sb.append(n - answer).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int start) {
        visited[start] = true;
        int next = num[start];

        if (!visited[next]) {
            dfs(next);
        } else {
            if (!finished[next]) {
                for (int i = next;true; i = num[i]) {
                    answer++;
                    if(i==start)break;
                }
            }
        }
        finished[start] = true;
    }
}
