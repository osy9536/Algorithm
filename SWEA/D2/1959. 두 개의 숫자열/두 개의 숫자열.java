
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 두개의 숫자열
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st0 = new StringTokenizer(br.readLine());
            int aLength = Integer.parseInt(st0.nextToken());
            int bLength = Integer.parseInt(st0.nextToken());

            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Integer> listA = new ArrayList<>();
            List<Integer> listB = new ArrayList<>();
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                listA.add(Integer.valueOf(st.nextToken()));
            }
            while (st2.hasMoreTokens()) {
                listB.add(Integer.valueOf(st2.nextToken()));
            }
            List<Integer> temp;
            if (listA.size() > listB.size()) {
                temp = new ArrayList<>(listA);
                listA = new ArrayList<>(listB);
                listB = new ArrayList<>(temp);
            }

            int aSize = listA.size();
            int bSize = listB.size();
            int max = 0;
            for (int j = 0; j < bSize - aSize+1; j++) {
                int mul = 0;
                for (int k = j; k < j+aSize; k++) {
                    mul += listA.get(k) * listB.get(k);
                }
                if (max < mul) max = mul;
                listA.add(0, 0);
            }
            System.out.println("#" + (i+1) + " "+max);
        }
    }
}
