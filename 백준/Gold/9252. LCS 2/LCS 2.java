
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// LCS 2
// gold 4
public class Main {
	static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();

        dp=new int[s1.length()+1][s2.length()+1];
        for(int i = 1; i<=s1.length(); i++){
            for(int j = 1; j<=s2.length(); j++){
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        int len = dp[s1.length()][s2.length()];
        System.out.println(dp[s1.length()][s2.length()]);

        if (len > 0) {
            StringBuilder result = new StringBuilder();
            int i = s1.length();
            int j = s2.length();
            while (i > 0 && j > 0) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    result.insert(0, s1.charAt(i - 1));
                    i--;
                    j--;
                } else if (dp[i - 1][j] > dp[i][j - 1]) {
                    i--;
                } else {
                    j--;
                }
            }
            System.out.println(result.toString());
        }
    }
}
