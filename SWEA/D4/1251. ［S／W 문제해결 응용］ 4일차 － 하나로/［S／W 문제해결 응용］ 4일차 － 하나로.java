
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// [S/W 문제해결 응용] 4일차 - 하나로
// D4
public class Solution {

    public static class Node implements Comparable<Node> {
        int num;
        long w;

        public Node(int num, long w) {
            this.num = num;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.w, o.w);
        }

    }

    static List<Node>[] lists;
    static int N;
    static boolean[] visited;
    static double tax;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {

            // 섬의 갯수
            N = Integer.parseInt(br.readLine());
            Point[] island = new Point[N];
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            tax = Double.parseDouble(br.readLine());
            lists = new ArrayList[N];
            visited = new boolean[N];
            for(int i = 0 ; i<N; i++){
                lists[i] = new ArrayList<>();
                island[i] = new Point();
                island[i].x = Integer.parseInt(st1.nextToken());
                island[i].y = Integer.parseInt(st2.nextToken());
            }

            for(int i = 0 ; i<N ; i++){
                for(int j= 0; j<N; j++){
                    if(i==j)continue;
                    int distX = Math.abs(island[i].x-island[j].x);
                    int distY = Math.abs(island[i].y-island[j].y);
                    lists[i].add(new Node(j, (long) distX * distX + (long) distY * distY));
                }
            }

            long answer = prim();
            System.out.println("#" + tc + " " + answer);
        }
    }

    private static long prim() {
        Queue<Node> q = new PriorityQueue<>();
        q.add(new Node(0, 0));
        long answer = 0;
        int cnt = 0;
        while (!q.isEmpty()){
            Node cur = q.poll();
            if(visited[cur.num]) continue;
            visited[cur.num] = true;
            answer+=cur.w;
            if(++cnt==N)break;
            for(int i = 0; i<lists[cur.num].size(); i++){
                Node next = lists[cur.num].get(i);
                if(!visited[next.num]){
                    q.add(next);
                }
            }
        }
        return Math.round(answer*tax);
    }
}
