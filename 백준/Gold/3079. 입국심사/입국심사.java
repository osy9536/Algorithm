import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 면접관 수
        int M = Integer.parseInt(st.nextToken()); // 면접자 수
        int[] times = new int[N];

        for (int i = 0; i < N; i++) {
            times[i] = Integer.parseInt(br.readLine()); // 각 면접관이 한 명의 면접을 진행하는데 걸리는 시간
        }

        long left = 0;
        long right = (long) times[0] * M; // 최악의 경우 시간 계산
        for (int time : times) {
            if ((long) time * M < right) {
                right = (long) time * M;
            }
        }

        long answer = right;
        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;

            // mid 시간동안 각 면접관이 면접 진행할 수 있는 횟수 합
            for (int time : times) {
                count += mid / time;
            }

            if (count >= M) { // 충분한 면접자 수를 수용할 수 있다면 시간 줄이기
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }
}
