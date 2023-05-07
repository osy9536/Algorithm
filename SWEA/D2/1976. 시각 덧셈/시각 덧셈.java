
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시각 덧셈
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int firstHour = Integer.parseInt(st.nextToken());
            int firstMinute = Integer.parseInt(st.nextToken());
            int secondHour = Integer.parseInt(st.nextToken());
            int secondMinute = Integer.parseInt(st.nextToken());

            int hour = firstHour + secondHour;
            int minute = firstMinute + secondMinute;
            if (minute >= 60) {
                minute %= 60;
                hour++;
            }
            if (hour > 12) {
                hour -= 12;
            }

            System.out.println("#" + (i + 1) + " " + hour + " " + minute);
        }
    }
}
