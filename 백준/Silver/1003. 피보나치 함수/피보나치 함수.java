
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] fibo0 = new int[41];
            int[] fibo1 = new int[41];
            fibo0[0] = 1;
            fibo0[1] = 0;
            fibo1[0] = 0;
            fibo1[1] = 1;
            for(int k = 2; k <= N; k++){
                fibo0[k] = fibo0[k-1] + fibo0[k-2];
                fibo1[k] = fibo1[k-1] + fibo1[k-2];
            }
            System.out.println(fibo0[N] + " " + fibo1[N]);
        }
    }
}