
import java.io.*;
import java.util.ArrayList;
import java.util.List;

// 찾기
// platinum 5
public class Main {

    static int cnt;
    static List<Integer> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String T = br.readLine();
        String P = br.readLine();
        answer = new ArrayList<>();
        cnt = 0;
        kmp(T, P);
        System.out.println(cnt);

        for (int i = 0; i < answer.size(); i++) {
            bw.write(Integer.toString(answer.get(i)));
            bw.write(" ");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void kmp(String parent, String pattern) {
        int[] table = makeTable(pattern);
        int n1 = parent.length();
        int n2 = pattern.length();

        int idx = 0;
        for (int i = 0; i < n1; i++) {
            while (idx > 0 && parent.charAt(i) != pattern.charAt(idx)) {
                idx = table[idx - 1];
            }
            if (parent.charAt(i) == pattern.charAt(idx)) {
                if (idx == n2 - 1) {
                    answer.add(i - idx + 1);
                    cnt++;
                    idx = table[idx];
                } else idx++;
            }
        }
    }

    static int[] makeTable(String pattern){
        int n = pattern.length();
        int[] table = new int[n];

        int idx = 0;
        for (int i = 1; i <n; i++) {
            while (idx>0 && pattern.charAt(i) != pattern.charAt(idx)){
                idx = table[idx - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(idx)) {
                idx++;
                table[i] = idx;
            }
        }

        return table;
    }
}
