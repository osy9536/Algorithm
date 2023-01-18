package implement;

import java.util.Scanner;

public class MathTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a= sc.nextInt();
        int b = sc.nextInt();
        int arr_n = 0;
        int cnt = 1;
        int[] arr = new int[b+1];
        int sum = 0;
        while(true){
            for(int i = 1; i<=cnt; i++){
                arr[arr_n] = cnt;
                ++arr_n;
                if(arr_n>=b+1){
                    break;
                }
            }
            cnt++;
            if(arr_n>=b+1){
                break;
            }
        }
        for(int i = a-1; i<b; i++){
            sum+=arr[i];
        }
        System.out.println(sum);
    }
}