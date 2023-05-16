
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// TITLE [S/W 문제해결 기본] 2일차 - Sum
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            int n = Integer.parseInt(br.readLine());
            int rowMax = 0;
            int colMax = 0;
            int firstDiag = 0;
            int lastDiag = 0;
            int max = 0;
            int[] colArr = new int[100];

            for (int j = 0; j < 100; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int rowNow = 0;
                for (int k = 0; k < 100; k++) {
                    int m = Integer.parseInt(st.nextToken());
                    rowNow += m; // row 덧셈
                    if (j == k) firstDiag += m; // 대각선 덧셈
                    colArr[k] += m; // col 덧셈
                    if (j + k == 99) lastDiag += m; // 역 대각선 덧셈
                }
                if (rowNow > rowMax) rowMax = rowNow;
            }
            Arrays.sort(colArr);
            colMax = colArr[99];
            max = Math.max(rowMax, Math.max(colMax, Math.max(firstDiag, lastDiag)));
            System.out.println("#" + n + " " + max);
        }
    }
}
