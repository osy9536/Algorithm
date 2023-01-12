package String;

import java.util.Scanner;

public class GroupWordChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int cnt = 0;
        for(int i = 0; i< num;i++){
            int firstCnt = 0;
            String s=sc.next();
            boolean check[] = new boolean[26];
            for(int j = 0; j<s.length();j++){

                if(check[s.charAt(j)-'a']){
                    if(s.charAt(j)!=s.charAt(j-1)){
                        firstCnt=0;
                        break;
                    }
                }
                else{
                    check[s.charAt(j)-'a']=true;
                    firstCnt=1;
                }
            }
            cnt+=firstCnt;
        }

        System.out.println(cnt);
    }
}
