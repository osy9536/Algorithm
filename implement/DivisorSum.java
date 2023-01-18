package implement;

import java.util.Scanner;

public class DivisorSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            int n = sc.nextInt();
            if (n == -1) {
                break;
            }
            int sum = 0;
            StringBuilder sb = new StringBuilder();
            for(int i = 1; i<=n/2; i++){
                if(n%i==0){
                    sb.append(i);
                    sb.append(" + ");
                    sum+=i;
                }
            }
            sb.delete(sb.length() - 3, sb.length());
            if(sum==n){
                System.out.print(n);
                System.out.print(" = ");
                System.out.println(sb);
            }
            else {
                System.out.print(n);
                System.out.println(" is NOT perfect.");
            }


        }
    }
}
