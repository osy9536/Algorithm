import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 스도쿠 검증
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int[][] arr = new int[9][9];
            boolean answer = true;
            for (int j = 0; j < 9; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int k = 0; k < 9; k++) {
                    int n = Integer.parseInt(st.nextToken());
                    arr[j][k] = n;
                }
            }
            
            // 가로 검증
            for (int j = 0; j < 9; j++) {
                boolean[] visited = new boolean[10]; // 0부터 9까지 숫자 방문 여부 체크
                for (int k = 0; k < 9; k++) {
                    int num = arr[j][k];
                    if (visited[num]) {
                        answer = false;
                        break;
                    }
                    visited[num] = true;
                }
                if (!answer) {
                    break;
                }
            }
            
            // 세로 검증
            for (int j = 0; j < 9; j++) {
                boolean[] visited = new boolean[10];
                for (int k = 0; k < 9; k++) {
                    int num = arr[k][j];
                    if (visited[num]) {
                        answer = false;
                        break;
                    }
                    visited[num] = true;
                }
                if (!answer) {
                    break;
                }
            }

            // 3x3 영역 검증
            for (int j = 0; j < 9; j += 3) {
                for (int k = 0; k < 9; k += 3) {
                    boolean[] visited = new boolean[10];
                    for (int l = j; l < j + 3; l++) {
                        for (int m = k; m < k + 3; m++) {
                            int num = arr[l][m];
                            if (visited[num]) {
                                answer = false;
                                break;
                            }
                            visited[num] = true;
                        }
                        if (!answer) {
                            break;
                        }
                    }
                    if (!answer) {
                        break;
                    }
                }
                if (!answer) {
                    break;
                }
            }

            System.out.println("#" + (i + 1) + " " + (answer ? "1" : "0"));
        }
    }
}