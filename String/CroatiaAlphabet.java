package String;

import java.util.Scanner;

public class CroatiaAlphabet {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int cnt = 0;
        while(s.contains("c=")){
            s=s.replaceFirst("c="," ");
            cnt++;
        }
        while(s.contains("c-")){
            s=s.replaceFirst("c-"," ");
            cnt++;
        }
        while(s.contains("dz=")){
            s=s.replaceFirst("dz="," ");
            cnt++;
        }
        while(s.contains("d-")){
            s=s.replaceFirst("d-"," ");
            cnt++;
        }
        while(s.contains("lj")){
            s=s.replaceFirst("lj"," ");
            cnt++;
        }
        while(s.contains("nj")){
            s=s.replaceFirst("nj"," ");
            cnt++;
        }
        while(s.contains("s=")){
            s=s.replaceFirst("s="," ");
            cnt++;
        }
        while(s.contains("z=")){
            s=s.replaceFirst("z="," ");
            cnt++;
        }
        s = s.replaceAll(" ", "");
        cnt+=s.length();

        System.out.println(cnt);
    }
}
