
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

// TITLE [S/W 문제해결 기본] 10일차 - 비밀번호
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 1; i <= 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            String s = st.nextToken();
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < s.length(); j++) {
                list.add(Integer.parseInt(String.valueOf(s.charAt(j))));
            }
            int idx = 0;
            while (true) {
                if (Objects.equals(list.get(idx), list.get(idx + 1))) {
                    list.remove(idx);
                    list.remove(idx);
                    if(idx!=0) idx--;
                }else idx++;
                if(idx>= (list.size()-1)) break;
            }
            System.out.print("#"+i+" ");
            list.forEach(System.out::print);
            System.out.println("\n");
        }
    }
}