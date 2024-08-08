import java.io.*;
import java.util.*;

public class Main {

    static final String output = "Data set ";
    static String one, two, three;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++) {
            String[] s = br.readLine().split(" ");
            one = s[0];
            two = s[1];
            three = s[2];

            boolean result = bfs();

            sb.append(output).append(i).append(": ").append(result ? "yes" : "no").append('\n');
        }

        System.out.print(sb);
    }

    static boolean bfs() {
        int len1 = one.length(), len2 = two.length(), len3 = three.length();

        if (len1 + len2 != len3) {
            return false;
        }

        boolean[][] visited = new boolean[len1 + 1][len2 + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int onePoint = current[0];
            int twoPoint = current[1];
            int threePoint = onePoint + twoPoint;

            if (threePoint == len3) {
                return true;
            }

            if (onePoint < len1 && one.charAt(onePoint) == three.charAt(threePoint) && !visited[onePoint + 1][twoPoint]) {
                visited[onePoint + 1][twoPoint] = true;
                queue.add(new int[]{onePoint + 1, twoPoint});
            }

            if (twoPoint < len2 && two.charAt(twoPoint) == three.charAt(threePoint) && !visited[onePoint][twoPoint + 1]) {
                visited[onePoint][twoPoint + 1] = true;
                queue.add(new int[]{onePoint, twoPoint + 1});
            }
        }

        return false;
    }
}
