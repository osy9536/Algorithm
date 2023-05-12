
import java.io.*;
import java.util.StringTokenizer;

// TITLE 버블 소트 프로그램2
public class Main {
    static int[] a, tmp;
    static long result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        a = new int[N + 1];
        tmp = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        result = 0;
        mergeSort(1, N);
        bw.write(Long.toString(result));
        bw.flush();
        bw.close();
    }

    private static void mergeSort(int s, int e) {
        if(e-s<1) return;
        int m = s + (e - s) / 2;
        mergeSort(s, m);
        mergeSort(m + 1, e);
        for (int i = s; i <= e; i++) {
            tmp[i] = a[i];
        }
        int k = s;
        int idx1 = s;
        int idx2 = m + 1;
        while (idx1 <= m && idx2 <= e) {
            if (tmp[idx1] > tmp[idx2]) {
                a[k] = tmp[idx2];
                result += idx2 - k;
                k++;
                idx2++;
            } else {
                a[k] = tmp[idx1];
                k++;
                idx1++;
            }
        }
        while (idx1 <= m) {
            a[k] = tmp[idx1];
            k++;
            idx1++;
        }
        while (idx2 <= e) {
            a[k] = tmp[idx2];
            k++;
            idx2++;
        }
    }
}
