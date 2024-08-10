import java.io.*;
import java.util.*;

public class Main {

    static class Edge {
        int to, cost;

        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static final int INF = Integer.MAX_VALUE;
    static List<Edge>[] adj;
    static long[] dist;
    static boolean[] inQueue;
    static int[] count;
    static int n, m, w;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < tc; i++) {

            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken()); // 지점 수
            m = Integer.parseInt(st.nextToken()); // 도로 수
            w = Integer.parseInt(st.nextToken()); // 웜홀 수

            adj = new ArrayList[n + 1];
            for (int j = 1; j <= n; j++) {
                adj[j] = new ArrayList<>();
            }

            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());

                adj[s].add(new Edge(e, t));
                adj[e].add(new Edge(s, t));
            }

            for (int j = 0; j < w; j++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = -Integer.parseInt(st.nextToken());

                adj[s].add(new Edge(e, t));
            }

            if (spfa()) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }

        System.out.print(sb);
    }

    static boolean spfa() {
        dist = new long[n + 1];
        inQueue = new boolean[n + 1];
        count = new int[n + 1];
        Arrays.fill(dist, INF);

        Queue<Integer> queue = new LinkedList<>();

        // 모든 노드에서 시작 (음의 사이클이 어느 노드에서 시작될지 모르므로)
        for (int i = 1; i <= n; i++) {
            dist[i] = 0;
            queue.offer(i);
            inQueue[i] = true;
        }

        while (!queue.isEmpty()) {
            int u = queue.poll();
            inQueue[u] = false;

            for (Edge edge : adj[u]) {
                int v = edge.to;
                if (dist[u] != INF && dist[u] + edge.cost < dist[v]) {
                    dist[v] = dist[u] + edge.cost;

                    if (!inQueue[v]) {
                        queue.offer(v);
                        inQueue[v] = true;
                        count[v]++;
                        if (count[v] >= n) {
                            return true; // 음의 사이클 발견
                        }
                    }
                }
            }
        }

        return false;
    }
}
