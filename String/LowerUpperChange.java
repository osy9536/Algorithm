package String;

import java.util.*;

public class LowerUpperChange {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        StringBuilder sb = new StringBuilder();
        for(int i= 0;i<s1.length();i++){
            if(s1.charAt(i)>='a' && s1.charAt(i)<='z'){
                sb.append(s1.toUpperCase().charAt(i));
            }
            else if(s1.charAt(i)>='A' && s1.charAt(i)<='Z'){
                sb.append(s1.toLowerCase().charAt(i));
            }
        }
        System.out.println(sb);
    }
}