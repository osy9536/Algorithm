package String;
import java.util.*;
public class Dial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int minTime = 0;
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i)<=67) minTime+=3;
            else if(s.charAt(i)<=70) minTime+=4;
            else if(s.charAt(i)<=73) minTime+=5;
            else if(s.charAt(i)<=76) minTime+=6;
            else if(s.charAt(i)<=79) minTime+=7;
            else if(s.charAt(i)<=83) minTime+=8;
            else if(s.charAt(i)<=86) minTime+=9;
            else  minTime+=10;
        }
        System.out.println(minTime);
    }

}
