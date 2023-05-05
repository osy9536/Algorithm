
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            List<Integer> list = new ArrayList<>();
            while (st.hasMoreTokens()) {
                list.add(Integer.valueOf(st.nextToken()));
            }
            Collections.sort(list);
            System.out.printf("#%d ",i+1);
            StringBuilder sb = new StringBuilder();
            list.forEach(e-> sb.append(e).append(" "));
            sb.delete(sb.length() - 1, sb.length());
            System.out.println(sb);
        }
    }
}
