import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N,M,L;
    static int[] mArr;
    static int[][] nArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 사대의 수
        N = Integer.parseInt(st.nextToken()); // 동물의 수
        L = Integer.parseInt(st.nextToken()); // 사정거리

        mArr = new int[M];
        nArr = new int[N][2];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int x = Integer.parseInt(st.nextToken());

            mArr[i] = x;
        }
        Arrays.sort(mArr);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            nArr[i][0] = x;
            nArr[i][1] = y;
        }

        int huntCnt = 0;

        for (int i = 0; i < N; i++) {
            if (isHunt(nArr[i][0], nArr[i][1])) {
                huntCnt++;
            }
        }

        System.out.println(huntCnt);
    }

    // nx, ny = 동물 위치, mx = 사대 위치
    static boolean isHunt(int nx, int ny) {

        if(ny>L) return false;

        int left = 0;
        int right = M-1;

        while (left <= right) {

            int mid = (left + right) / 2;

            int dist = dist(nx, ny, mArr[mid]);

            if(dist<=L) return true;

            if (mArr[mid] > nx) {
                right = mid -1;
                continue;
            }

            left = mid +1;
        }

        return false;
    }

    static int dist(int nx, int ny, int mx) {

        return Math.abs(nx - mx) + ny;
    }
}
