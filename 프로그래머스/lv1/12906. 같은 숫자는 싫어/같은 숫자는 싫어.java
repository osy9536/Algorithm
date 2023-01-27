import java.util.*;

public class Solution {
    public static List<Integer> solution(int[] arr){
        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                continue;
            } else list.add(arr[i]);
        }
        return list;
    }
}