import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class NumWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int cnt = 0;
        if(s.charAt(0)!=' '){
            cnt++;
        }
        for(int i=0;i<s.length()-1; i++){
            if(s.charAt(i)==' '){
                if(s.charAt(i+1)!=' '){
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
