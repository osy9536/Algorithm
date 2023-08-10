
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 규영이와 인영이의 카드게임
// D3
public class Solution {
    static int[] a, b;
    static boolean[] check;
    static int aCnt, bCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a = new int[9];
            b = new int[9];
            aCnt = 0;
            bCnt = 0;
            check = new boolean[9];
            boolean[] a1 = new boolean[19];
            for(int i = 0; i<9; i++) {
                int m =Integer.parseInt(st.nextToken());
                a1[m]=true;
                a[i]=m;
            }
            int b1= 0;
            for(int i = 1; i<=18;i++){
                if(!a1[i]){
                    b[b1++]=i;
                }
            }

            dfs( 0, 0, 0);
            System.out.println("#"+tc+" "+aCnt+" "+bCnt);
        }
    }
    // 1 3 5 7  9 11 13 15 17
    // 2 4 6 8 10 12 14 16 18
    private static void dfs(int idx, int aSum, int bSum) {
        if(idx==9){
            if(aSum>bSum) aCnt++;
            else if(aSum<bSum) bCnt++;
            return;
        }
        for(int i = 0; i<9; i++){
            if(!check[i]){
                check[i]=true;
                if(a[idx]>b[i]){
                    dfs(idx+1,aSum+a[idx]+b[i],bSum);
                }else{
                    dfs(idx+1,aSum,bSum+a[idx]+b[i]);
                }
                check[i]=false;
            }
        }
    }
}