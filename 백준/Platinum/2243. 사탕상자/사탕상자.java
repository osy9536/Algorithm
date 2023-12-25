import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 음주코딩
// gold 1
public class Main {

    static final int SIZE = 1_000_000;
    static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int h = (int) Math.ceil(Math.log(n) / Math.log(2));

        tree = new int[SIZE*4];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            if (op == 1) {
                int candy = findCandy(1, SIZE, 1, a);
                sb.append(candy).append("\n");
            } else {
                int b = Integer.parseInt(st.nextToken());
                update(1, SIZE, 1, a, b);
            }
        }
        System.out.println(sb);
    }

    static void update(int start, int end, int node, int idx, int dif) {
        if(idx < start || end < idx) return;

        tree[node] += dif;
        if(start == end) return;

        int mid = (start+end)/2;
        update(start, mid, node*2, idx, dif);
        update(mid+1, end, node*2+1, idx, dif);
    }

    static int findCandy(int start, int end, int node, int idx) {
        if (start == end) {
            return start;
        }

        int mid = (start + end) / 2;
        if (idx <= tree[node * 2]) {
            tree[node*2]--;
            return findCandy(start, mid, node * 2, idx);
        } else {
            tree[node*2+1]--;
            return findCandy(mid + 1, end, node * 2 + 1, idx - tree[node * 2]);
        }
    }
}
