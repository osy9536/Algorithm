
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// TITLE [S/W 문제해결 기본] 8일차 - 암호문3
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            // 단어 갯수
            int n = Integer.parseInt(br.readLine());
            List<Integer> list = new ArrayList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                list.add(Integer.valueOf(st.nextToken()));
            }
            // 명령어 갯수
            int m = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                String c = st.nextToken();
                switch (c) {
                    case "I":
                        int insertPoint = Integer.parseInt(st.nextToken());
                        int insertNum = Integer.parseInt(st.nextToken());
                        for (int j = insertPoint; j < insertNum + insertPoint; j++) {
                            list.add(j, Integer.valueOf(st.nextToken()));
                        }
                        break;
                    case "D":
                        int deletePoint = Integer.parseInt(st.nextToken());
                        int deleteNum = Integer.parseInt(st.nextToken());
                        for (int j = deletePoint; j < deletePoint + deleteNum; j++) {
                            list.remove(j);
                        }
                        break;
                    case "A":
                        int addNum = Integer.parseInt(st.nextToken());
                        for (int j = 0; j < addNum; j++) {
                            list.add(Integer.valueOf(st.nextToken()));
                        }
                }
            }

            System.out.print("#" + (i + 1) + " ");
            for (int j = 0; j < 10; j++) {
                System.out.print(list.get(j)+" ");
            }
            System.out.println("\n");
        }
    }
}
