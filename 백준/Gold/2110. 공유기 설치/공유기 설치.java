import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int N, C;
    static int[] coordinates;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 집의 개수
        int C = Integer.parseInt(st.nextToken()); // 공유기의 개수

        coordinates = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());

            coordinates[i] = x;
        }

        Arrays.sort(coordinates);

        // 1 2 4 8 9
        // 2, 1

        int hi = coordinates[N - 1];
        int lo = 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            int pos = 0;
            int cnt = 1;

            for (int i = 1; i < N; i++) {
                if (coordinates[i] - coordinates[pos] >= mid) {
                    pos = i;
                    cnt++;
                }
            }

            if (cnt < C) {
                hi = mid - 1;
            } else lo = mid + 1;
        }

        System.out.println(lo - 1);
    }
}