import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a==0&&b==0)break;

            int cnt = 0;
            HashSet<Integer> list = new HashSet<>();
            for (int i = 0; i < a ; i++) {
                list.add(Integer.parseInt(br.readLine()));
            }
            for (int i = 0; i < b; i++) {
                if (list.contains(Integer.parseInt(br.readLine()))) {
                    cnt++;
                }
            }
            System.out.println(cnt);
        }

    }
}