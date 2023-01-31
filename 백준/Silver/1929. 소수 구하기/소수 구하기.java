import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[] primeNum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        primeNum = new boolean[b+1];
        prime(b);
        for (int i = 0; i < a; i++) {
            primeNum[i] = true;
        }
        primeNum[0]=primeNum[1]=true;
        for (int i = 0; i < primeNum.length; i++) {
            if (!primeNum[i]) {
                System.out.println(i);
            }
        }
    }
    static void prime( int b) {
        for (int i = 2; i <=b ; i++) {
            for (int j = i + i; j <= b; j += i) {
                primeNum[j] = true;
            }
        }
    }
}
