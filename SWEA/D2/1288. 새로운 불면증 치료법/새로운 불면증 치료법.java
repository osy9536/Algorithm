
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            Set<Integer> set = new HashSet<>();
            int num = Integer.parseInt(br.readLine());
            int repNum = num;
            int j = 1;
            while (set.size() < 10) {
                while (repNum != 0) {
                    int splitNum = repNum % 10;
                    repNum /= 10;
                    set.add(splitNum);
                }
                repNum = num * j;
                j++;
            }
            System.out.println("#" + i + " " + (repNum - num));
        }
    }
}