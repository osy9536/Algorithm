package implement;

import java.util.Scanner;

public class ReverseWord {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine()); // nextInt() 다음 enter 값이 남아서 다음
                                                //nextLine()시 공백이 읽혀버림
        for (int i = 0; i <n ; i++) {
            String s = sc.nextLine();
            String[] arr = s.split(" ");
            StringBuilder sb = new StringBuilder();
            for(int j= 0; j<arr.length; j++){
                StringBuilder sb2 = new StringBuilder(arr[j]);
                String reverse = String.valueOf(sb2.reverse());
                sb.append(reverse);
                sb.append(" ");
            }
            System.out.println(sb);
        }
    }
}
