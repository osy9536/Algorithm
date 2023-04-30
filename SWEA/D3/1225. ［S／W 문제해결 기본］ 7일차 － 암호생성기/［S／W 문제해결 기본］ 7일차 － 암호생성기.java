
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            int n = sc.nextInt();
            List<Integer> queue = new ArrayList<>();
            for (int j = 0; j < 8; j++) {
                int num = sc.nextInt();
                queue.add(num);
            }
            while (queue.get(queue.size()-1)>0) {
                for (int j = 1; j <= 5; j++) {
                    queue.add(queue.get(0) - j);
                    queue.remove(0);
                    if (queue.get(queue.size() - 1) <= 0) break;
                }
            }
            queue.remove(queue.size() - 1);
            queue.add(0);
            System.out.print("#" + n + " ");
            for (Integer integer : queue) {
                System.out.print(integer+" ");
            }
            System.out.println();
        }
    }
}
