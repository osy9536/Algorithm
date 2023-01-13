package String;

import java.util.Scanner;

public class SweetPork {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for(int i =0; i<num; i++){
            String s=sc.next();
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for(int j=0; j<s.length(); j++){
                if(s.length()%2!=0){
                    s+=s;
                }
                if(j%2==0){
                    sb1.append(s.charAt(j));
                } else sb2.append(s.charAt(j));
            }
            System.out.println(sb1);
            System.out.println(sb2);
        }
    }
}
