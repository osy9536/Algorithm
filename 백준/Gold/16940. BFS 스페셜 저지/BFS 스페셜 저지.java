import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static List<Integer>[] graph;
    static int[] bfsOrder;
    static int[] position;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        bfsOrder = new int[n];
        position = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            bfsOrder[i] = Integer.parseInt(st.nextToken());
            position[bfsOrder[i]] = i;
        }

        for (int i = 1; i <= n; i++) {
            graph[i].sort(Comparator.comparingInt(a -> position[a]));
        }

        if (isValidBFS()) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    static boolean isValidBFS() {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];

        queue.offer(1);
        visited[1] = true;

        int idx = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (bfsOrder[idx++] != node) {
                return false;
            }

            for (int next : graph[node]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }

        return true;
    }
}
