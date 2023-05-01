
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a1 = Integer.parseInt(st.nextToken()) - 1;
            int a2 = Integer.parseInt(st.nextToken()) - 1;
            int a3 = Integer.parseInt(st.nextToken()) - 1;

            int x = a1;

            while (x % 24 != a2 || x % 29 != a3) {
                x += 365;
            }
            bw.write("#" + (i + 1) + " " + (x + 1)+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
