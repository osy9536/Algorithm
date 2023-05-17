
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//TITLE Rooted Binary Tree 재구성
public class Solution {
    static int[] tree;
    static int idx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());
            int length = (int) (Math.pow(2, k) - 1);
            int[] arr = new int[length];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < length; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            tree = new int[length + 1];
            recursion(0, length - 1, 1, arr);
            int line = 1;
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(i + 1).append(" ");
            idx = 1;
            for (int j = 0; j < k; j++) {
                line = (int) Math.pow(2, j);
                for (int l = 0; l < line; l++, idx++) {
                    sb.append(tree[idx]).append(" ");
                }
                sb.append("\n");
            }
            System.out.print(sb);
        }
    }

    private static void recursion(int left, int right, int index, int[] arr) {
        int root = (left + right) / 2;
        tree[index] = arr[root];
        if (left == right) return;
        recursion(left, root - 1, index * 2, arr);
        recursion(root + 1, right, index * 2 + 1, arr);
    }
}