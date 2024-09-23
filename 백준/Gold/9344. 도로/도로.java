import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int node, W;

        Node(int node, int W) {
            this.node = node;
            this.W = W;
        }

        @Override
        public int compareTo(Node n) {
            return this.W - n.W;
        }
    }

    static List<Node>[] lists;
    static boolean[] visited;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 도시의 수
            int M = Integer.parseInt(st.nextToken()); // 길의 수
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken()); // p, q 사이에 도로를 지어도 되는지 판단

            int pqPrim = 0;
            int prim = 0;
            lists = new List[N + 1];
            for (int i = 1; i < N + 1; i++) {
                lists[i] = new ArrayList<>();
            }
            visited = new boolean[N + 1];

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());

                // u와 v를 잇는 비용 w
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                lists[u].add(new Node(v, w));
                lists[v].add(new Node(u, w));

                if (u == p && q == v) {
                    visited[p] = true;
                    pqPrim = prim(p, q, w);
                }
            }

            visited = new boolean[N + 1];
            prim = prim(0, 1, 0);

//            System.out.println("pqPrim = " + pqPrim + ", prim = " + prim);

            if (prim == pqPrim) sb.append("YES").append('\n');
            else sb.append("NO").append('\n');
        }

        System.out.print(sb);
    }

    private static int prim(int p, int q, int w) {

        Queue<Node> pq = new PriorityQueue<>();

        int[] arr = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            arr[i] = Integer.MAX_VALUE;
        }
        if (p != 0) {
            for (Node next : lists[p]) {
                if(next.node == q) continue;
                arr[next.node] = next.W;
            }

            for (Node next : lists[q]) {
                if(next.node==p) continue;
                if (arr[next.node] > next.W) {
                    arr[next.node] = next.W;
                }
            }
        } else pq.add(new Node(q, 0));

        for (int i = 0; i < N + 1; i++) {
            if (arr[i] == Integer.MAX_VALUE) continue;

            pq.add(new Node(i, arr[i]));
        }

        int sum = w;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (visited[cur.node]) continue;
            visited[cur.node] = true;

            for (Node next : lists[cur.node]) {
                if (!visited[next.node]) {
                    pq.add(new Node(next.node, next.W));
                }
            }

            sum += cur.W;
        }
        return sum;
    }
}