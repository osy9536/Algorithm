
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 촌수계산
// silver 2
public class Main {
    static int end, answer = -1;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); // 양방향 인접리스트
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); //전체 사람의 수
        visited = new boolean[n + 1];
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine()); //부모 자식들 간의 관계의 개수
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            // 양방향
            graph.get(from).add(to);  //from -> to
            graph.get(to).add(from);  // to -> from
        }
        // 시작 정점, 촌 수
        dfs(start, 0);
        System.out.println(answer);
    }

    private static void dfs(int point, int cnt) {
        visited[point] = true;
        for (int x : graph.get(point)) {
            if (!visited[x]) { 
                if (x == end) { 
                    answer = cnt + 1;
                    return;
                }
                dfs(x, cnt + 1);
            }
        }
    }
}
