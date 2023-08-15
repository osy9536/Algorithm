
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int mul = 2*k;
        char[] a = new char[mul*2];
        int[][] ans = new int[mul][mul];
        String input = br.readLine();
        for (int i = 0; i < 2 * 2 * k-1; i++) {
            a[i] = input.charAt(i);
        }
        ans[0][0] = Integer.parseInt(br.readLine());
        int x = 1, y = 1;

        for (int i = 2*2 * k - 1; i >= 0; i--) {
            if (a[i] == 'L') {
                for (int j = 0; j < x; j++) {
                    for (int l = 0; l < y; l++) {
                        ans[j][2 * y - 1 - l] = ans[j][l] ^ 1;
                    }
                }
                y *= 2;
            }
            if (a[i] == 'R') {
                for (int j = 0; j < x; j++) {
                    for (int l = 0; l < y; l++) {
                        ans[j][l + y] = ans[j][l];
                    }
                }
                for (int j = 0; j < x; j++) {
                    for (int l = 0; l < y; l++) {
                        ans[j][l] = ans[j][2 * y - 1 - l] ^ 1;
                    }
                }
                y *= 2;
            }
            if (a[i] == 'D') {
                for (int j = 0; j < x; j++) {
                    for (int l = 0; l < y; l++) {
                        ans[j + x][l] = ans[j][l];
                    }
                }
                for (int j = 0; j < x; j++) {
                    for (int l = 0; l < y; l++) {
                        ans[j][l] = ans[2 * x - 1 - j][l] ^ 2;
                    }
                }
                x *= 2;
            }
            if (a[i] == 'U') {
                for (int j = 0; j < x; j++) {
                    for (int l = 0; l < y; l++) {
                        ans[2 * x - 1 - j][l] = ans[j][l] ^ 2;
                    }
                }
                x *= 2;
            }
        }

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
