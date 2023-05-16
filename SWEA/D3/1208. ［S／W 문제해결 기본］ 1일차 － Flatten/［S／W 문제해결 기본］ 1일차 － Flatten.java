
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//TITLE [S/W 문제해결 기본] 1일차 - Flatten
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[101];
            for (int j = 0; j < 100; j++) {
                int m = Integer.parseInt(st.nextToken());
                arr[m] += 1;
            }
            // { 0, 0, 0, 2, 4, 1, 3, 0, 0, 5, 0}
            // { 0, 0, 0, 1, 5, 1, 3,
            // 투포인터 이용
            int left = 1;
            int right = 100;
            int cnt = n;
            while (cnt > 0) {
                if (arr[left] == 0) left++;
                if (arr[right] == 0) {
                    right--;
                } else {
                    arr[left]--;
                    arr[left + 1]++;
                    arr[right]--;
                    arr[right - 1]++;
                    cnt--;
                }
            }

            for (int j = 1; j <= 100; j++) {
                if (arr[j] != 0) {
                    left = j;
                    break;
                }
            }
            for (int j = 100; j >0 ; j--) {
                if (arr[j] != 0) {
                    right = j;
                    break;
                }
            }

            System.out.println("#" + (i + 1) + " " + (right - left));
        }
    }
}