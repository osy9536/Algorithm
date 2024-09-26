import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[] A, B, C, D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        A = new int[n];
        B = new int[n];
        C = new int[n];
        D = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, Integer> cdMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = C[i] + D[j];
                cdMap.put(sum, cdMap.getOrDefault(sum, 0) + 1);
            }
        }

        long ansCnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int ab = A[i] + B[j];
                if (cdMap.containsKey(-ab)) {
                    ansCnt += cdMap.get(-ab);
                }
            }
        }

        System.out.println(ansCnt);
    }
}
