
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int P, Q, R, S, W;
            P = Integer.parseInt(st.nextToken());
            Q = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            S = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            int AComp = P * W;
            int BComp;
            if (W <= R) {
                BComp = Q;
            } else {
                BComp = Q + ((W - R) * S);
            }
            if (AComp >= BComp) {
                System.out.println("#" + i + " " + BComp);
            } else {
                System.out.println("#" + i + " " + AComp);
            }
        }
    }
}