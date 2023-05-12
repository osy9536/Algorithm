
import java.io.*;

// TITLE 수 정렬하기 3
public class Main {
    static int[] a;
    static long result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }
        br.close();
        radixSortint(a, 5);
        for (int i = 0; i < n; i++) {
            bw.write(a[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    static void radixSortint(int[] a, int maxSize) {
        int[] output = new int[a.length];
        int jarisu = 1;
        int cnt = 0;
        // 215 15 344 372 294 100 8 145 24 198 831
        while (cnt != maxSize) {
            int[] bucket = new int[10];
            for (int i = 0; i < a.length; i++) {
                bucket[(a[i] / jarisu) % 10]++;
            }
            for (int i = 1; i < 10; i++) {
                bucket[i] += bucket[i - 1];
            }
            for (int i = a.length - 1; i >= 0; i--) {
                output[bucket[(a[i] / jarisu % 10)] - 1] = a[i];
                bucket[(a[i] / jarisu) % 10]--;
            }
            for (int i = 0; i < a.length; i++) {
                a[i] = output[i];
            }
            jarisu *= 10;
            cnt++;
        }
    }
}