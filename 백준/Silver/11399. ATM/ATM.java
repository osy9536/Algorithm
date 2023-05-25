
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        int[] s = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        // 3 1 4 3 2
        for (int i = 1; i < n; i++) {
            int insertIndex = i; //3
            int insertValue = a[i]; //3
            for (int j = i-1; j >=0 ; j--) {
                if (a[i] > a[j]) {
                    insertIndex = j + 1;
                    break;
                }
                if (j == 0) {
                    insertIndex = 0;
                }
            }
            for (int j = i; j > insertIndex; j--) {
                a[j] = a[j - 1];
            }
            a[insertIndex] = insertValue;
        }
        s[0] = a[0];
        for (int i = 1; i < n; i++) {
            s[i] = s[i - 1] + a[i];
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += s[i];
        }
        System.out.println(sum);
    }
}
