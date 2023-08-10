
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 햄버거 다이어트
// D3
public class Solution {
    static int L,N, answer;
    static int[][] score_cal;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc<=T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            score_cal = new int[N][2];
            for(int i = 0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());
                score_cal[i][0]=n;
                score_cal[i][1]=l;
            }
            answer = 0;
            // score, cal, idx
            dfs(0,0,0);
            System.out.println("#"+tc+" "+answer);
        }
    }

    private static void dfs(int score, int cal,int idx) {
        if(cal>L){
            return;
        }
        if(idx==N){
            if(answer<score) {
                answer = score;
            }
            return;
        }
        dfs(score+ score_cal[idx][0],cal+ score_cal[idx][1],idx+1);
        dfs(score,cal,idx+1);
    }
}
