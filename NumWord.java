import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class NumWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int cnt = 1;
        for(int i=0;i<s.length(); i++){
            if(i!=0&& i!=s.length()-1){
                if(s.charAt(i)==32){
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
