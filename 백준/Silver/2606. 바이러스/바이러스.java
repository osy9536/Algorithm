
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 바이러스
// silver 3
public class Main {
    static int[] com;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int pair = Integer.parseInt(br.readLine());
        com = new int[N];
        list = new ArrayList[N+1];
        visited= new boolean[N+1];
        for(int i = 1; i<=N; i++){
            list[i] = new ArrayList<>();
        }
        for(int i = 0; i<pair; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        bfs(1);
        System.out.println(cnt);
    }

    static void bfs(int idx) {
        Queue<List<Integer>> q = new LinkedList<>();
        q.add(list[idx]);
        visited[idx] = true;
        while(!q.isEmpty()){
            List<Integer> now = q.poll();
            while (!now.isEmpty()) {
                if(visited[now.get(0)]) {
                    now.remove(0);
                    continue;
                }
                q.add(list[now.get(0)]);
                visited[now.get(0)]=true;
                now.remove(0);
                cnt++;
            }
        }
    }
}
