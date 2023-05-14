import java.util.*;

class Solution {
    public static String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();

        String[] arr = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);

        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo((o1 + o2)));
        
        if(Objects.equals(arr[0], "0")) return "0";
        
        Arrays.stream(arr).forEach(sb::append);

        return sb.toString();
    }
}