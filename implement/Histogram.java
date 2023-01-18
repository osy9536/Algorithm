package implement;

import java.util.Scanner;

public class Histogram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i<n; i++){
            int a = sc.nextInt();
            char c = '=';
            for(int j = 0; j<a; j++){
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
