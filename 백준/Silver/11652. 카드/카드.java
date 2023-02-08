import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            long integer = Long.parseLong(br.readLine());
            list.add(integer);
        }
        Collections.sort(list);
        list.add(list.get(list.size() - 1) + 1);
        long max = 0;
        long cnt = 1;
        long idx = list.get(0);
        long maxIdx = 0;
        // 1,1,1,2,2
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) == idx) {
                cnt++;
            } else {
                if (cnt > max) {
                    max = cnt;
                    maxIdx = idx;
                }
                idx = list.get(i);
                cnt = 1;
            }
        }
        System.out.println(maxIdx);
    }
}