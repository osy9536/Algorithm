
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//달팽이 숫자
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];
            arr[0][0] = 1;

            int x = 0, y = 0;
            int num = 1, step = n-1;

            while (num != n * n) {
                if (num == 1) {
                    for (int i = 0; i < step; i++)
                        arr[x][++y] = ++num;
                }
                for (int i = 0; i < step; i++)
                    arr[++x][y] = ++num;
                for (int i = 0; i < step; i++)
                    arr[x][--y] = ++num;
                step--;
                for (int i = 0; i < step; i++)
                    arr[--x][y] = ++num;
                for (int i = 0; i < step; i++)
                    arr[x][++y] = ++num;
                step--;
            }
            System.out.println("#" + (t+1));
            for (int[] is : arr) {
                for (int i : is) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }

        }
    }
}