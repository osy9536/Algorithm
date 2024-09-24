import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] coordinates = new int[N+1][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            coordinates[i][0] = x;
            coordinates[i][1] = y;
        }

        long sum1 = 0;
        long sum2 = 0;

        coordinates[N] = coordinates[0].clone();
        // x0y1 - x1y0 + x1y2 * x2y1 ... x(N-1)y0 - x0y(N-1)
        for (int i = 0; i < N; i++) {
            sum1 += (long) coordinates[i][0] * coordinates[i + 1][1];
            sum2 += (long) coordinates[i + 1][0] * coordinates[i][1];
        }
        
        System.out.printf("%.1f%n", Math.abs(sum1 - sum2) / 2D);
    }
}