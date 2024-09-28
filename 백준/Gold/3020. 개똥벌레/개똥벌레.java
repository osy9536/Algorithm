import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, H;
    static int[] heightPerObstacle;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 장애물 개수
        H = Integer.parseInt(st.nextToken()); // 높이

        heightPerObstacle = new int[H + 1]; // 누적합을 위해 H+1 크기로 배열 선언

        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(br.readLine());
            if (i % 2 == 0) {
                // 석순
                heightPerObstacle[1]++;  // 시작점 증가
                if (a + 1 <= H) heightPerObstacle[a + 1]--;  // 끝점 다음 감소
            } else {
                // 종유석
                heightPerObstacle[H - a + 1]++;  // 시작점 증가
            }
        }

        // 누적 합 계산
        int min = Integer.MAX_VALUE;
        int cnt = 0;
        int currentHeight = 0;
        for (int i = 1; i <= H; i++) {
            currentHeight += heightPerObstacle[i];
            if (currentHeight == min) {
                cnt++;
            } else if (currentHeight < min) {
                min = currentHeight;
                cnt = 1;
            }
        }

        System.out.print(min + " " + cnt);
    }
}
