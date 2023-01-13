package String;

import java.util.Scanner;

public class PhoneNumCompatibility {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1=sc.next();
        String s2=sc.next();
        StringBuilder sb1=new StringBuilder();
        for(int i = 0; i<s1.length();i++){
            sb1.append(s1.charAt(i));
            sb1.append(s2.charAt(i));
        }
        StringBuilder sb2 = new StringBuilder();
        for(int i = 0; i<sb1.length()-1; i++){
            sb2.append((Integer.parseInt(String.valueOf(sb1.charAt(i)))+Integer.parseInt(String.valueOf(sb1.charAt(i+1))))%10);
        }
        while (sb2.length()>2){
            for(int i = 0; i<sb2.length()-1; i++){
                sb2.replace(i,i+1, String.valueOf((Integer.parseInt(String.valueOf(sb2.charAt(i)))+Integer.parseInt(String.valueOf(sb2.charAt(i+1))))%10));
            }
            sb2.delete(sb2.length()-1,sb2.length());
        }
        System.out.println(sb2);
    }
}
