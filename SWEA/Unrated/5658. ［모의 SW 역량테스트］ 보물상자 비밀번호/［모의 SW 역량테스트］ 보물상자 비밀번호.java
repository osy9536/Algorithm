
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 보물상자 비밀번호
public class Solution {
    static Set<Integer> set;
    static Deque<Character> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc<=T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            set = new TreeSet<>();
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            String s = br.readLine();
            q = new ArrayDeque<>();
            for(int i = 0; i<s.length(); i++){
                q.add(s.charAt(i));
            }
            for(int i = 0; i<N/4; i++){
                solve(N / 4);
                q.addFirst(q.removeLast());
            }
            Iterator<Integer> it = set.iterator();
            int idx = set.size()+1;
            while (it.hasNext()){
                idx--;
                int n = it.next();
                if(idx==K){
                    System.out.println("#" + tc + " " + n);
                }
            }
        }
    }

    private static void solve(int div) {
        for(int i = 0; i<4; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j<div; j++){
                char c = q.poll();
                q.add(c);
                sb.append(c);
            }
            int a = Integer.parseInt(sb.toString(), 16);
            set.add(a);
        }
    }
}
