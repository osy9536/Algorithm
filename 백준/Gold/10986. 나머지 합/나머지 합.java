
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long answer = 0;
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long[] arr = new long[n];
        long[] c = new long[m];
        arr[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < n; i++) {
            arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            int remainder = (int) (arr[i] % m);
            if (remainder == 0) answer++;
            c[remainder]++;
        }

        for (int i = 0; i < m; i++) {
            if (c[i] > 1) {
                answer = answer + (c[i] * (c[i] - 1) / 2);
            }
        }

        System.out.println(answer);
    }
}