import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        a = 1000 - a;
        int cnt = 0;
        while (a>0) {
            if(a>=500) {
                a-=500;
                cnt++;
            }
            else if (a >= 100) {
                a-=100;
                cnt++;
            } else if (a >= 50) {
                a -= 50;
                cnt++;
            } else if (a >= 10) {
                a -= 10;
                cnt++;
            } else if (a >= 5) {
                a-=5;
                cnt++;
            } else {
                a -= 1;
                cnt++;
            }
        }
        System.out.println(cnt);

    }
}