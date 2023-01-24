import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int cnt = 1;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int idx = 0;
        System.out.print("<");
        while (list.size()>1) {
            if ((idx+1) % k==0) {
                System.out.print(list.get(0)+", ");
                list.remove(list.get(0));
                idx++;
            }
            else {
                list.add(list.get(0));
                list.remove(list.get(0));
                idx++;
            }
        }
        System.out.print(list.get(0)+">");

    }
}