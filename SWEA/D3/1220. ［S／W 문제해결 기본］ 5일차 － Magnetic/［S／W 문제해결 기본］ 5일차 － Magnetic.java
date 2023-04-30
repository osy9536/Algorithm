
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        for (int m = 0; m < 10; m++) {
            int n = sc.nextInt();
            int cnt = 0;
            int[] arr = new int[100];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n; j++) {
                    int num = sc.nextInt();
                    if (arr[j] == 1 && num == 2) cnt++;
                    if (num != 0) arr[j] = num;
                }
            }
            System.out.println("#" + (m + 1) + " " + cnt);
        }
    }
}
