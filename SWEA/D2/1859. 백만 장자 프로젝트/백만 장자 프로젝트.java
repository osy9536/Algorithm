
import java.io.IOException;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            long sum = 0;
            int n2 = sc.nextInt();

            List<Integer> list = new ArrayList<>();

            int max = 0;
            for (int j = 0; j < n2; j++) {
                int n3 = sc.nextInt();
                list.add(n3);
            }

            for (int j = list.size()-1; j >0 ; j--) {
                if(list.get(j)>max) max = list.get(j);
                if (max >= list.get(j - 1)) {
                    sum += max - list.get(j - 1);
                }
            }
            System.out.println("#" + (i + 1) + " " + sum);
        }
    }
}