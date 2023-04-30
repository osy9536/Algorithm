
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            int cnt = 0;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < num; j++) {
                String alphabet = sc.next();
                int number = sc.nextInt();
                for (int k = 0; k < number; k++, cnt++) {
                    if (cnt % 10 == 0) sb.append("\n");
                    sb.append(alphabet);
                }
            }
            System.out.println("#"+(i+1)+" "+sb);
        }
    }
}
