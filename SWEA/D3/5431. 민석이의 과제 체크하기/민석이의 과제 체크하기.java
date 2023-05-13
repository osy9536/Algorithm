
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// TITLE 민석이의 과제 체크하기
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int submitNum = Integer.parseInt(st.nextToken());

            boolean[] a = new boolean[num + 1];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < submitNum; j++) {
                int submitPeople = Integer.parseInt(st.nextToken());
                a[submitPeople] = true;
            }
            System.out.print("#" + (i + 1) + " ");
            for (int j = 1; j < a.length; j++) {
                if(!a[j]) System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
