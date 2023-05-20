
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//TITLE 현주의 상자 바꾸기
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int i = 1; i <= tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 0, 0, 0, 0, 0
            // 1~i~2
            // 1~3 : 1
            // 1, 1, 1, 0, 0
            // 2~4 : 2
            // 1, 2, 2, 2, 0
            int n = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            for (int j = 1; j <= q; j++) {
                st = new StringTokenizer(br.readLine());
                int l = Integer.parseInt(st.nextToken()) - 1;
                int r = Integer.parseInt(st.nextToken()) - 1;

                while (l <= r) {
                    arr[l] = j;
                    l++;
                }
            }

            System.out.print("#" + i + " ");
            Arrays.stream(arr).forEach(num -> System.out.printf("%d ", num));
            System.out.println();
        }
    }
}
