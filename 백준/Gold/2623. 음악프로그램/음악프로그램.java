import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<Integer>[] lists;
    static int N;
    static int[] edgeCnt, ans;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 가수의 수
        int M = Integer.parseInt(st.nextToken()); // 보조 PD의 수

        lists = new List[N + 1];
        for (int i = 1; i < N + 1; i++) {
            lists[i] = new ArrayList<>();
        }
        edgeCnt = new int[N + 1];
        ans = new int[N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());

            int[] arr = new int[num];
            for (int j = 0; j < num; j++) {
                int a = Integer.parseInt(st.nextToken());

                arr[j] = a;
            }

            for (int j = 0; j < num - 1; j++) {
                lists[arr[j]].add(arr[j + 1]);
                edgeCnt[arr[j + 1]]++;
            }
        }

        topologicalSort();
        boolean isZero = false;
        for (int i = 0; i < N + 1; i++) {
            if (edgeCnt[i] != 0) {
                isZero = true;
                break;
            }
        }
        
        if(isZero) {
            System.out.print(0);
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(ans[i]).append('\n');
        }

        System.out.print(sb);
    }

    private static void topologicalSort() {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i < N + 1; i++) {
            if (edgeCnt[i] == 0) {
                q.add(i);
            }
        }

        int ansCnt = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            ans[ansCnt++] = cur;

            for (int i = 0; i < lists[cur].size(); i++) {
                int a = lists[cur].get(i);

                edgeCnt[a]--;
                if (edgeCnt[a] == 0) {
                    q.add(a);
                }
            }
        }
    }
}