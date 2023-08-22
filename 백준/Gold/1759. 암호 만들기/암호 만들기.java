
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 암호 만들기
// gold 5
public class Main {

    static int L, C;
    static char[] list;
    static char[] code;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        list = br.readLine().replace(" ","").toCharArray();
        code = new char[L];

        Arrays.sort(list);

        permu(0,0);
        System.out.print(sb.toString());
    }

    public static void permu(int x, int idx) {
        if (idx == L) {
            if (isValid()) {
                sb.append(code).append("\n");
            }
            return;
        }

        for (int i = x; i < C; i++) {
            code[idx] = list[i];
            permu(i+1, idx + 1);
        }
    }

    private static boolean isValid() {
        int mo = 0;
        int ja = 0;

        for (char x : code) {
            if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') {
                mo++;
            } else {
                ja++;
            }
        }

        if (mo >= 1 && ja >= 2) {
            return true;
        }
        return false;
    }
}
