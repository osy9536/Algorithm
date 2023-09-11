import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int now, depth;

        Node(int now, int depth) {
            this.now = now;
            this.depth = depth;
        }
    }

    static int answer;
    static int K;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        answer = Integer.MAX_VALUE;
        BFS(N);
        System.out.println(answer);
    }

    static void BFS(int start) {
        boolean[] visited = new boolean[100001];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (K == cur.now) {
                answer = Math.min(answer, cur.depth);
                continue;
            }

            // 다음 위치로 이동하는데, 순간이동은 우선하여 큐의 앞에 추가
            if (cur.now * 2 <= 100000 && !visited[cur.now * 2]) {
                q.add(new Node(cur.now * 2, cur.depth));
                visited[cur.now * 2] = true;
            }

            if (cur.now - 1 >= 0 && !visited[cur.now - 1]) {
                q.add(new Node(cur.now - 1, cur.depth + 1));
                visited[cur.now - 1] = true;
            }

            if (cur.now + 1 <= 100000 && !visited[cur.now + 1]) {
                q.add(new Node(cur.now + 1, cur.depth + 1));
                visited[cur.now + 1] = true;
            }
        }
    }
}
