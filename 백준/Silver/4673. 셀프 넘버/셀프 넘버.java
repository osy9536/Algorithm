import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        int a = 1;
        while (true){
            list.add(selfNum(a));
            if (selfNum(a) > 10040) {
                break;
            }
            a++;
        }
        for (int i = 1; i <= 10000; i++) {
            if (!list.contains(i)) {
                System.out.println(i);
            }
        }
    }
    public static int selfNum(int n ){
        int answer = n;
        while (true) {
            if(n==0) break;
            answer+=n%10; // 112 -> 112+ 2, 11
            n/=10;
        }
        return answer;
    }
}