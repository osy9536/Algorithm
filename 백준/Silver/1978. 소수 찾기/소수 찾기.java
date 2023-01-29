import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[] primeNum = new boolean[1001];
        primeNum[0] = true;
        primeNum[1] = true;
        for (int i = 2; i < 1001; i++) {
            if (!primeNum[i]) {
                for (int j = i*i; j < 1001; j+=i) {
                    primeNum[j] = true;
                }
            }
        }
        int answer = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            if (!primeNum[a]) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}