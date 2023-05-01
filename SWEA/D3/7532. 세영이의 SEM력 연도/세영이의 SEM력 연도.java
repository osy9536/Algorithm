
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
            System.out.println("#" + (i + 1) + " " + (x + 1));
        }
    }
}
