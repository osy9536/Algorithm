package String;

import java.util.Scanner;

public class Secret {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = new String();

        while(true){
            s=sc.nextLine();
            StringBuilder sb = new StringBuilder(s);
            sb.reverse();
            if(s.equals("END")){
                break;
            }
            System.out.println(sb);
        }

    }
}
