
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// TITLE DFS와 BFS프로그램
public class Main {
    static ArrayList<Integer>[] A;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeNum = Integer.parseInt(st.nextToken());
        int edgeNum = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(st.nextToken());

        A = new ArrayList[nodeNum+1];
        for (int i = 1; i <= nodeNum; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < edgeNum; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            A[start].add(end);
            A[end].add(start);
        }
        for (int i = 1; i <= nodeNum; i++) {
            Collections.sort(A[i]);
        }

        visited = new boolean[nodeNum + 1];
        DFS(startNode);
        System.out.println();
        visited = new boolean[nodeNum + 1];
        BFS(startNode);
        System.out.println();
    }

    private static void DFS(int startNode) {
        System.out.print(startNode + " ");
        visited[startNode] = true;
        for (int i : A[startNode]) {
            if (!visited[i]) {
                DFS(i);
            }
        }
    }

    private static void BFS(int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        visited[startNode] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            System.out.print(now + " ");
            for (int i : A[now]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}

