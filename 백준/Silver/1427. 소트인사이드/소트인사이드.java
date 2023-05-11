
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] a = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            a[i] = Integer.parseInt(s.substring(i, i + 1));
        }

        for (int i = 0; i < a.length; i++) {
            int max = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] > a[max]) {
                    max = j;
                }
            }
            if (a[max] > a[i]) {
                int temp = a[i];
                a[i] = a[max];
                a[max] = temp;
            }
        }
        for (int j : a) {
            System.out.print(j);
        }
    }
}
