
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 숫자 배열 회전
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());
            int[][] arr = new int[m][m];

            for (int j = 0; j < m; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            
            StringBuilder sb = new StringBuilder();
            int[][] arr_90 = new int[m][m];
            int[][] arr_180 = new int[m][m];
            int[][] arr_270 = new int[m][m];

            for (int j = 0; j < m; j++) {
                for (int k = 0; k < m; k++) {
                    arr_90[k][m - j - 1] = arr[j][k];
                }
            }
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < m; k++) {
                    arr_180[k][m - j - 1] = arr_90[j][k];
                }
            }
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < m; k++) {
                    arr_270[k][m - j - 1] = arr_180[j][k];
                }
            }
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < m; k++) {
                    sb.append(arr_90[j][k]);
                }
                sb.append(" ");
                for (int k = 0; k < m; k++) {
                    sb.append(arr_180[j][k]);
                }
                sb.append(" ");
                for (int k = 0; k < m; k++) {
                    sb.append(arr_270[j][k]);
                }
                sb.append("\n");
            }
            System.out.print("#"+(i+1)+"\n"+sb);
        }
    }
}
