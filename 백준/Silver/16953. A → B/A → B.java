
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// A → B
// silver 2
public class Main {
    static class Node {
        long num;
        int depth;

        Node(long num, int depth) {
            this.depth = depth;
            this.num = num;
        }
    }

    static long b, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        answer = Integer.MAX_VALUE;
        bfs(a);
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    static void bfs(long start) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start, 1));
        while (!q.isEmpty()) {
            Node cur = q.poll();
            if(cur.num==b){
                answer = Math.min(answer, cur.depth);
            }
            long mul = mul(cur.num);
            long plus = plus(cur.num);
            if (mul <= b) q.add(new Node(mul, cur.depth + 1));
            if (plus <= b) q.add(new Node(plus, cur.depth + 1));
        }
    }

    static long mul(long num) {

        return num * 2;
    }

    static long plus(long num) {

        return num * 10 + 1;
    }
}
