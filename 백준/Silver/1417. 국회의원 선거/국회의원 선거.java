
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n-1];
        int dasom = sc.nextInt();
        if(n==1){
            System.out.println(0);
        }else {
            for (int i = 0; i < n-1; i++) {
                int people = sc.nextInt();
                arr[i]=people;
            }
            Arrays.sort(arr);//[3, 7, 8, 10]
            int cnt = 0;
            while (arr[n - 2] >= dasom) {
                if (arr[n - 2] < dasom) {
                    break;
                }
                else {
                    arr[n - 2] = arr[n - 2] - 1;
                    dasom += 1;
                    Arrays.sort(arr);
                    cnt++;
                }
            }
            System.out.println(cnt);
        }

    }
}
