
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        quickSort(a, 0, n - 1, k - 1);
        System.out.println(a[k - 1]);
    }
    // 4 8 6 3 5
    // 6 8 4 3 5
    // 6 5 4 3 8
    // 6 5 3 4 8
    // 3 5 3 4 8
    // 3 5 6 4 8

    //
    private static void quickSort(int[] a, int start, int end, int k) {
        if (start < end) {
            int pivot = partition(a, start, end);
            if (pivot == k) {
                return;
            } else if (k < pivot) {
                quickSort(a, start, pivot - 1, k);
            } else {
                quickSort(a, pivot + 1, end, k);
            }
        }
    }

    private static int partition(int[] a, int start, int end) {
        if (start + 1 == end) {
            if(a[start]>a[end]) swap(a, start, end);
        }
        int middle = (start + end) / 2;
        swap(a, start, middle);
        int pivot = a[start];
        int i = start + 1, j = end;
        while (i <= j) {
            while (pivot < a[j] && j > 0) {
                j--;
            }
            while (pivot > a[i] && i < a.length - 1) {
                i++;
            }
            if (i <= j) {
                swap(a, i++, j--);
            }
        }
        a[start] = a[j];
        a[j] = pivot;
        return j;
    }

    private static void swap(int[] a, int start, int end) {
        int temp = a[start];
        a[start] = a[end];
        a[end] = temp;
    }

}