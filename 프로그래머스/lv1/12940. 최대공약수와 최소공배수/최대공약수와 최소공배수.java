import java.util.*;


class Solution {
    public static int[] solution(int n, int m){
        int gcd = 0;
        int lcm = 0;
//        비교대상인 두 개의 자연수 a와 b에서 (이때, a>b) a를 b로 나눈 나머지를 r 이라고 했을때
//        GCD(a, b) = GCD(b, r) 이며,
//        "r이 0이면 그때 b가 최대공약수이다."
        int[] answer = {gcd(n, m), lcm(n, m)};


        return answer;
    }
    public static int gcd(int a, int b){
        while(b != 0) {      //a= 10, b =15
            int r = a % b;  // r= 10    , r= 5  , r= 0
            a = b;          //a = 15    , a = 10    , a= 5
            b = r;          //b = 10    , b= 5      , b= 0
        }
        return a;
    }

    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}




