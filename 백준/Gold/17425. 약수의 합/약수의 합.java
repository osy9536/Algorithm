import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int MAX = 1_000_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        long[] fx = new long[MAX];
        long[] gx = new long[MAX];

        Arrays.fill(fx, 1);

        for (int i = 2; i < MAX; i++) {
            for (int j = 1; i * j < MAX; j++) {
                fx[i * j] += i;
            }
        }

        for (int i = 1; i < MAX; i++) {
            gx[i] = fx[i] + gx[i - 1];
        }

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());

            sb.append(gx[N]).append('\n');
        }

        System.out.print(sb);
    }
}
