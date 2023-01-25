import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        List<Integer> list1 = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            list1.add(Integer.valueOf(st.nextToken()));
        }
        int sum = 0;
        int idx = 1;
        int index = list.indexOf(1);
        for (int i = 0; i < k; i++) {
            int left = Math.abs(list.indexOf(list1.get(i))-list.indexOf(idx));
            int right = (idx == list1.get(i)) ? 0 : list.size() - list.indexOf(list1.get(i)) + list.indexOf(idx);
            if (left>right) {
                right(list, n, list1.get(i));
                sum+=right;
                list.remove(0);
                if(!list.isEmpty())  idx = list.get(0);
            }
            else {
                left(list, list1.get(i));
                sum+=left;
                list.remove(0);
                if(!list.isEmpty())  idx = list.get(0);
            }
        }
        System.out.println(sum);

    }
    static int left(List<Integer> list,int k){
        int cnt = 0;
        while (true) {
            if (list.get(0) == k) {
                break;
            }
            int tmp = list.get(0);
            list.remove(0);
            list.add(tmp);
            cnt++;

        }
        return cnt;
    }
    static int right(List<Integer> list, int n, int k){
        int cnt = 0;
        while (true) {
            if (list.get(0) == k) {
                break;
            }
            int tmp = list.get(list.size()-1);
            list.remove(list.size() - 1);
            list.add(0, tmp);
            cnt++;

        }
        return cnt;
    }
}
